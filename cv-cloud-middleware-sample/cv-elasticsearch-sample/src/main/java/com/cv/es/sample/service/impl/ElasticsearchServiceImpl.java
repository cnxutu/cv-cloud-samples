package com.cv.es.sample.service.impl;


import com.cv.es.sample.repository.ElasticsearchRepository;
import com.cv.es.sample.service.IElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ElasticsearchServiceImpl implements IElasticsearchService {

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;

    public String indexDocument(String index, String id, String jsonString) throws IOException {
        return elasticsearchRepository.indexDocument(index, id, jsonString);
    }

    public String getDocument(String index, String id) throws IOException {
        return elasticsearchRepository.getDocument(index, id);
    }

    public String updateDocument(String index, String id, String jsonString) throws IOException {
        return elasticsearchRepository.updateDocument(index, id, jsonString);
    }

    public String deleteDocument(String index, String id) throws IOException {
        return elasticsearchRepository.deleteDocument(index, id);
    }
}