package com.example.demo.service;

import com.example.demo.request.SearchRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.PagingResponse;

public interface CateService {
    BaseResponse<PagingResponse> search(SearchRequest request);
}