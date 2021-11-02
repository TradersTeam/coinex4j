package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class ApiResponse<T> extends PrettyJson {
    private final int code;
    private final T data;
    private final String message;
}
