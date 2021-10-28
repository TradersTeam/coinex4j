package com.github.TradersTeam.coinex4j.model;

/**
 * Class used for API response de-serialization,
 * example of API response JSON:
 * <pre>
 * {@code
 *     "code": 0,
 *     "data": [
 *         "LTCBCH",
 *         "ETHBCH",
 *         "ZECBCH",
 *         "DASHBCH"
 *     ],
 *     "message": "Ok"
 * }
 * </pre>
 * {
 *
 * @param <T> type of API response data, which can be anything like {@code String, Long or List}
 */
@SuppressWarnings("unused")
public class ApiResponse<T> {
    private final int code;
    private final T data;
    private final String message;

    /**
     * @param code    http status code
     * @param data    API response data
     * @param message API response message
     */
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
