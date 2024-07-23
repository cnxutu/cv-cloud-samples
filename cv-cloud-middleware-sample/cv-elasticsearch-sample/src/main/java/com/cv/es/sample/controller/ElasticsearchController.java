package com.cv.es.sample.controller;

import com.cv.es.sample.service.IElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


/**
 * es功能测试
 */
@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticsearchController {

    @Autowired
    private IElasticsearchService elasticsearchService;


    @PostMapping("/createIndex")
    public ResponseEntity<String> createIndex(@RequestParam String indexName) {
        try {
            boolean created = elasticsearchService.createIndex(indexName);
            return created ? ResponseEntity.ok("Index created") : ResponseEntity.status(500).body("Failed to create index");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/addDocument/{indexName}/{id}")
    public ResponseEntity<String> addDocument(@PathVariable String indexName, @PathVariable String id, @RequestBody Map<String, Object> document) {
        try {
            String docId = elasticsearchService.addDocument(indexName, id, document);
            return ResponseEntity.ok("Document added with id: " + docId);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity<String> getDocument(@RequestParam String index, @RequestParam String id) throws IOException {
        try {
            String documentDetail = elasticsearchService.getDocument(index, id);
            return ResponseEntity.ok("Document detail with id: " + documentDetail);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDocument(@RequestParam String index, @RequestParam String id, @RequestBody String jsonString) throws IOException {
        try {
            String docId = elasticsearchService.updateDocument(index, id, jsonString);
            return ResponseEntity.ok("Document update with id: " + docId);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDocument(@RequestParam String index, @RequestParam String id) throws IOException {
        try {
            String docId = elasticsearchService.deleteDocument(index, id);
            return ResponseEntity.ok("Document delete with id: " + docId);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}