package com.cv.es.sample.service.impl;


import com.cv.es.sample.repository.ElasticsearchRepository;
import com.cv.es.sample.service.IElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class ElasticsearchServiceImpl implements IElasticsearchService {

    @Autowired
    private ElasticsearchRepository elasticsearchRepository;


    /**
     * 创建酒店 index
     * @return
     * @throws IOException
     */
    public boolean createHotelIndex() throws IOException {
        return elasticsearchRepository.createHotelIndex();
    }



    @Override
    public boolean createIndex(String indexName) throws IOException {
        return elasticsearchRepository.createIndex(indexName);
    }


    /**
     * 使用 map 格式传参进行文档添加
     * @param indexName
     * @param id
     * @param document
     * @return
     * @throws IOException
     */
    @Override
    public String addDocument(String indexName, String id, Map<String, Object> document) throws IOException {
        return elasticsearchRepository.addDocument(indexName, id, document);
    }


    /**
     * 使用 json 格式传参进行文档添加
     * @param index
     * @param id
     * @param jsonString
     * @return
     * @throws IOException
     */
    @Override
    public String indexDocument(String index, String id, String jsonString) throws IOException {
        return elasticsearchRepository.indexDocument(index, id, jsonString);
    }


    /**
     * 通过 index、id 查询 document
     * @param index
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public String getDocument(String index, String id) throws IOException {
        return elasticsearchRepository.getDocument(index, id);
    }

    /**
     * 通过 index、id 更新 document
     * @param index
     * @param id
     * @param jsonString
     * @return
     * @throws IOException
     */
    @Override
    public String updateDocument(String index, String id, String jsonString) throws IOException {
        return elasticsearchRepository.updateDocument(index, id, jsonString);
    }

    /**
     * 通过 index、id 删除 document
     * @param index
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public String deleteDocument(String index, String id) throws IOException {
        return elasticsearchRepository.deleteDocument(index, id);
    }
}