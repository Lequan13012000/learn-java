package com.example.demo.response;

import com.example.demo.constant.CommonMessage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse<T> {

    @JsonIgnore
    private CommonMessage common;

    private long code;

    private String message;

    private T data;

    public BaseResponse() {
        this.code = CommonMessage.SUCCESS.code;
        this.message = CommonMessage.SUCCESS.message;
    }

    public BaseResponse(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(CommonMessage common) {
        this.code = common.code;
        this.message = common.message;
    }

//    public BaseResponse(CommonMessage common, String replaceStr) {
//        this.code = common.code;
//        this.message = Strings.replace(common.message, "{}", replaceStr);
//    }

    public BaseResponse(CommonMessage common, T data) {
        this.code = common.code;
        this.message = common.message;
        this.data = data;
    }
    public BaseResponse(T data) {
        this.data = data;
    }
}

