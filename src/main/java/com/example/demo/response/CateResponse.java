package com.example.demo.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class CateResponse {
    private String cap_name;
    private String cap;
    private Long cap_id;
}

