package co.za.codeboss.data.elastic.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(0, "Request Successful"),
    FAILURE(-1, "System Busy");

    final int code;
    final String msg;
}