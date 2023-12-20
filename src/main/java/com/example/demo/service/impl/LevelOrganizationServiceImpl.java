package com.example.demo.service.impl;

import com.example.demo.constant.CommonMessage;
import com.example.demo.dto.PagingDTO;
import com.example.demo.entity.Cate;
import com.example.demo.repository.CateRepository;
import com.example.demo.request.SearchRequest;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.PagingResponse;
import com.example.demo.service.LevelOrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LevelOrganizationServiceImpl implements LevelOrganizationService {
    private final CateRepository cateRepository;

    @Override
    public BaseResponse<PagingResponse> search(SearchRequest request) {
        if (request.getPage_index() == 0 || request.getPage_size() == 0) {
            request.setPage_index(1);
            request.setPage_size(20);
        }
        int offset = (request.getPage_index() - 1) * request.getPage_size();
        List<Cate> cates = cateRepository.findByNameContainingAndCdSortedByValAndCreatedAt(request.getStr().trim(), organizationLevel, request.getPage_size(), offset);
        List<LevelOrganizationResponse> response = cates.stream().map(cate -> LevelOrganizationResponse.of(cate.getName(), cate.getVal(), cate.getId())).toList();
        Long totalRecords = cateRepository.countFindByNameContainingAndCdSortedByValAndCreatedAt(request.getStr().trim(), organizationLevel);
        int totalPages = (int) Math.ceil((double) totalRecords / request.getPage_size());
        PagingDTO pagingResponse = new PagingDTO();
        pagingResponse.setCurrent(request.getPage_index());
        pagingResponse.setSize(response.size());
        pagingResponse.setTotalPages(totalPages);
        pagingResponse.setTotalRecords(totalRecords);
        return new BaseResponse<>(CommonMessage.SUCCESS, PagingResponse.of(pagingResponse, response));
    }
}
