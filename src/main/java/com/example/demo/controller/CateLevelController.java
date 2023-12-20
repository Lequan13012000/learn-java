package com.example.demo.controller;

import com.example.demo.request.SearchRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.LevelOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/org")
public class CateLevelController {

    @Autowired
    private LevelOrganizationService service;

    @PostMapping("/captcs")
    public ResponseEntity<BaseResponse<?>> search(@RequestBody SearchRequest request) {
        return ResponseEntity.ok(service.search(request));
    }
}
