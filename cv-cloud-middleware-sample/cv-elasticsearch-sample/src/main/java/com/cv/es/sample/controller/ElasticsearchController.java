package com.cv.es.sample.controller;

import com.cv.es.sample.service.IElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticsearchController {

    @Autowired
    private IElasticsearchService elasticsearchService;

    @PostMapping("/index")
    public String indexDocument(@RequestParam String index, @RequestParam String id, @RequestBody String jsonString) throws IOException {
        return elasticsearchService.indexDocument(index, id, jsonString);
    }

    @GetMapping("/get")
    public String getDocument(@RequestParam String index, @RequestParam String id) throws IOException {
        return elasticsearchService.getDocument(index, id);
    }

    @PutMapping("/update")
    public String updateDocument(@RequestParam String index, @RequestParam String id, @RequestBody String jsonString) throws IOException {
        return elasticsearchService.updateDocument(index, id, jsonString);
    }

    @DeleteMapping("/delete")
    public String deleteDocument(@RequestParam String index, @RequestParam String id) throws IOException {
        return elasticsearchService.deleteDocument(index, id);
    }
}