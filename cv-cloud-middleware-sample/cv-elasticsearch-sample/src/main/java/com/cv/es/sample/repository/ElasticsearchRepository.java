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
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class ElasticsearchRepository {

    @Autowired
    private RestHighLevelClient client;

    public String indexDocument(String index, String id, String jsonString) throws IOException {
        IndexRequest request = new IndexRequest(index).id(id).source(jsonString, XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        return response.getId();
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
