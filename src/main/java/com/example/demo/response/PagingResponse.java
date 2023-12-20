package com.example.demo.response;

import com.example.demo.dto.PagingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PagingResponse {
    private PagingDTO paging;
    private List<?> items;
}
