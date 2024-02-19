package com.example.demo.requestResponse;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SuccessResponse {
    private String message;
    private boolean status;
    private Object data;

    public SuccessResponse(String message, Object data){
        this.data = data;
        this.message = message;
        this.status=true;
    }
}
