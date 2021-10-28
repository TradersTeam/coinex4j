package com.github.TradersTeam.coinex4j.network.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://github.com/coinexcom/coinex_exchange_api/wiki/013error_code">API references for codes</a>
 */
public enum APIResponseEnum {
    SUCCESS(200), SUCCESS_ALT(0),
    PAGE_DOES_NOT_EXIST(404),
    ERROR(1),
    PARAMETER_ERROR(2),
    INTERNAL_ERROR(3),
    IP_NOT_ALLOW(23),
    ACCESS_ID_NOT_EXIST(24),
    SIGNATURE_ERROR(25),
    SERVICE_UNAVAILABLE(35),
    SERVICE_TIMEOUT(36),
    MAIN_AND_SUB_ACCOUNTS_UNPAIRED(40),
    TRANSFER_TO_SUB_ACCOUNT_REJECTED(49),
    INSUFFICIENT_BALANCE(107),
    FORBID_TRADING(115),
    TONCE_CHECK_ERROR(227),
    ORDER_NUMBER_DOES_NOT_EXIST(600),
    OTHER_USERS_ORDER(601),
    BELOW_MIN_BUY_SELL_LIMIT(602),
    ORDER_PRICE_AND_LATEST_PRICE_DEVIATION_TOO_LARGE(606),
    MERGE_DEPTH_ERROR(651);

    public final int code;

    private APIResponseEnum(int code) {
        this.code = code;
    }

    private static final Map<Integer, APIResponseEnum> CODES = new HashMap<>();

    static {
        for (APIResponseEnum apiResponseEnum : values()) {
            CODES.put(apiResponseEnum.code, apiResponseEnum);
        }
    }

    public static APIResponseEnum valueOfCode(int code) {
        return CODES.get(code);
    }
}
