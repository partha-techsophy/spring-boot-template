package com.scubetech.demo.application.response;

import lombok.Value;

@Value
public class ApiResponse<T>
{
    private final T data;
    private final Boolean success;
    private final String message;
}
