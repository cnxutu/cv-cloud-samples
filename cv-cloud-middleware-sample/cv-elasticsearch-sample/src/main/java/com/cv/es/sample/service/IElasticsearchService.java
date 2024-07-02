package com.cv.es.sample.service;

import java.io.IOException;

public interface IElasticsearchService {

    public String indexDocument(String index, String id, String jsonString) throws IOException;

    public String getDocument(String index, String id) throws IOException;

    public String updateDocument(String index, String id, String jsonString) throws IOException;

    public String deleteDocument(String index, String id) throws IOException;

}
