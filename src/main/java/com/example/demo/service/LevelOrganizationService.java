package com.example.demo.service;

import com.example.demo.request.SearchRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.PagingResponse;

public interface LevelOrganizationService {
    BaseResponse<PagingResponse> search(SearchRequest request);
}