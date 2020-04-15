package co.za.codeboss.data.elastic.common;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1696194043024336235L;

    /**
     * error code
     */
    private int errcode;

    /**
     * error message
     */
    private String errmsg;

    /**
     * Result data
     */
    private T data;

    public Result() {
    }

    private Result(ResultCode resultCode) {
        this(resultCode.code, resultCode.msg);
    }

    private Result(ResultCode resultCode, T data) {
        this(resultCode.code, resultCode.msg, data);
    }

    private Result(int errcode, String errmsg) {
        this(errcode, errmsg, null);
    }

    private Result(int errcode, String errmsg, T data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }



    /**
     * Success
     *
     * @param <T> Generic param
     * @return Response message {@code Result}
     */
    public static <T> Result<T> success() {
        return new Result<>(ResultCode.SUCCESS);
    }


    /**
     * @param data Response data
     * @param <T> Generic param
     * @return Response message {@code Result}
     */
    public static <T> Result<T> success(@Nullable T data) {
        return new Result<>(ResultCode.SUCCESS, data);
    }
}
