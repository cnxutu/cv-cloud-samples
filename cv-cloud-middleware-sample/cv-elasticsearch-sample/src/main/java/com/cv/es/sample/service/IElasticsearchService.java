package com.cv.es.sample.service;

import java.io.IOException;
import java.util.Map;

public interface IElasticsearchService {

    public String indexDocument(String index, String id, String jsonString) throws IOException;

    public String getDocument(String index, String id) throws IOException;

    public String updateDocument(String index, String id, String jsonString) throws IOException;

    public String deleteDocument(String index, String id) throws IOException;

    boolean createIndex(String indexName) throws IOException;

    String addDocument(String indexName, String id, Map<String, Object> document) throws IOException;
}
