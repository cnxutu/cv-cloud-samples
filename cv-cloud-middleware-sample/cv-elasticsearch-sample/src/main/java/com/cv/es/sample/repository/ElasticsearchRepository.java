package com.cv.es.sample.repository;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Map;

@Repository
public class ElasticsearchRepository {

    @Autowired
    private RestHighLevelClient client;

    public boolean createHotelIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("hotels");
        String mapping = "{\n" +
                "  \"mappings\": {\n" +
                "    \"properties\": {\n" +
                "      \"name\": { \"type\": \"text\" },\n" +
                "      \"location\": { \"type\": \"geo_point\" }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        request.source(mapping, XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }


    public boolean createIndex(String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        request.settings("{\n" +
                "  \"number_of_shards\": 1,\n" +
                "  \"number_of_replicas\": 0\n" +
                "}", XContentType.JSON);

        CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }


    public String indexDocument(String index, String id, String jsonString) throws IOException {
        IndexRequest request = new IndexRequest(index).id(id).source(jsonString, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return response.getId();
    }


    public String addDocument(String indexName, String id, Map<String, Object> jsonMap) throws IOException {
        IndexRequest indexRequest = new IndexRequest(indexName)
                .id(id)
                .source(jsonMap);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse.getId();
    }

    public String getDocument(String index, String id) throws IOException {
        GetRequest request = new GetRequest(index, id);
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        return response.getSourceAsString();
    }

    public String updateDocument(String index, String id, String jsonString) throws IOException {
        UpdateRequest request = new UpdateRequest(index, id).doc(jsonString, XContentType.JSON);
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        return response.getId();
    }

    public String deleteDocument(String index, String id) throws IOException {
        DeleteRequest request = new DeleteRequest(index, id);
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        return response.getId();
    }


}
