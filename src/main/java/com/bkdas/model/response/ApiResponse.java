package com.bkdas.model.response;

import com.bkdas.model.common.ApiError;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse<T> {

    private T payload;
    private String message;
    private ApiError error;
    private Boolean status;

    public ApiResponse(final T object){
        this.payload = object;
    }

}