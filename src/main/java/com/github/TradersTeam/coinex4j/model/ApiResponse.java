package com.github.TradersTeam.coinex4j.model;

public class ApiResponse<T> {
    private final int code;
    private final T data;
    private final String message;

    public ApiResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
