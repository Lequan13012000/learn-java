package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class PagingDTO {

    private Integer current;

    private Integer size;

    @JsonProperty(value = "total_pages")
    private Integer totalPages;

    @JsonProperty(value = "total_records")
    private Long totalRecords;
}