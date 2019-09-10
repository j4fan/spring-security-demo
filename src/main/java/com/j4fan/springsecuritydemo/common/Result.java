package com.j4fan.springsecuritydemo.common;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * response dto
 */
@Data
@Accessors(chain = true)
public class Result<R> {
    private int code;
    private String message;

    private R data;

    public Result setCode(ResultCode code) {
        this.code = code.code;
        return this;
    }

}
