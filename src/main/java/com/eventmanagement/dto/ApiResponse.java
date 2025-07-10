package com.eventmanagement.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private boolean success;
    private T data;
    private String message;
    private int status;

    public ApiResponse(boolean success, T data, String message, int status) {
        this.success = success;
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public static <T> ApiResponse<T> success(T data, String message, int status) {
        return new ApiResponse<>(true, data, message, status);
    }

    public static <T> ApiResponse<T> error(String message, int status) {
        return new ApiResponse<>(false, null, message, status);
    }
}