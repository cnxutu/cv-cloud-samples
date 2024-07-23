package com.cv.es.sample.repository;

import com.cv.es.sample.pojo.dto.HotelDTO;
import com.cv.es.sample.pojo.query.HotelQuery;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.GeoDistanceQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xutu
 * @since: 2024/7/23 15:12
 */
@Repository
public class HotelRepository {

    private final RestHighLevelClient client;

    @Autowired
    public HotelRepository(RestHighLevelClient client) {
        this.client = client;
    }

    public List<String> saveHotelsBatch(List<HotelQuery> hotels) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        for (HotelQuery hotel : hotels) {
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("name", hotel.getName());
            jsonMap.put("location", Map.of("lat", hotel.getLat(), "lon", hotel.getLon()));
            jsonMap.put("price", hotel.getPrice());
            jsonMap.put("rating", hotel.getRating());

            IndexRequest request = new IndexRequest("hotels").source(jsonMap);
            bulkRequest.add(request);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        List<String> ids = new ArrayList<>();
        bulkResponse.forEach(bulkItemResponse -> ids.add(bulkItemResponse.getId()));
        return ids;
    }


    public String saveHotel(HotelQuery hotel) throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", hotel.getName());
        jsonMap.put("location", Map.of("lat", hotel.getLat(), "lon", hotel.getLon()));
        jsonMap.put("price", hotel.getPrice());
        jsonMap.put("rating", hotel.getRating());

        IndexRequest request = new IndexRequest("hotels").source(jsonMap);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return response.getId();
    }

    public List<HotelDTO> findHotelsByLocation(double lat, double lon, double distance) throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotels");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        GeoDistanceQueryBuilder distanceQueryBuilder = QueryBuilders
                .geoDistanceQuery("location")
                .point(lat, lon)
                .distance(distance, org.elasticsearch.common.unit.DistanceUnit.KILOMETERS);

        searchSourceBuilder.query(distanceQueryBuilder);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        List<HotelDTO> hotels = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            hotels.add(new HotelDTO(
                    (String) sourceAsMap.get("name"),
                    (double) ((Map) sourceAsMap.get("location")).get("lat"),
                    (double) ((Map) sourceAsMap.get("location")).get("lon"),
                    (double) sourceAsMap.get("price"),
                    (double) sourceAsMap.get("rating")
            ));
        }
        return hotels;
    }


    public List<HotelDTO> findExpensiveHotelsByLocation(double lat, double lon, double distance, double minPrice) throws IOException {
        SearchRequest searchRequest = new SearchRequest("hotels");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 创建地理距离查询和价格过滤查询
        GeoDistanceQueryBuilder distanceQueryBuilder = QueryBuilders
                .geoDistanceQuery("location")
                .point(lat, lon)
                .distance(distance, org.elasticsearch.common.unit.DistanceUnit.KILOMETERS);

        // 使用 Bool 查询组合地理距离和价格查询
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery()
                .must(distanceQueryBuilder)
                .filter(QueryBuilders.rangeQuery("price").gt(minPrice));

        searchSourceBuilder.query(boolQuery);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

        List<HotelDTO> hotels = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            hotels.add(new HotelDTO(
                    (String) sourceAsMap.get("name"),
                    (double) ((Map) sourceAsMap.get("location")).get("lat"),
                    (double) ((Map) sourceAsMap.get("location")).get("lon"),
                    (double) sourceAsMap.get("price"),
                    (double) sourceAsMap.get("rating")
            ));
        }
        return hotels;
    }

}

