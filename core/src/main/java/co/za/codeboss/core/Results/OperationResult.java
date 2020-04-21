package co.za.codeboss.core.Results;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperationResult<T> implements Serializable {

    private static final long serialVersionUID = 1696194043024336235L;

    private boolean isSuccess;

    /**
     * error message
     */
    private String error;

    /**
     * Result data
     */
    private T data;

    public OperationResult() {
    }

    private OperationResult(boolean isSuccess) {
        this(isSuccess, null);
    }

    private OperationResult(boolean isSuccess, T data) {
        this(isSuccess, null, data);
    }

    private OperationResult(String error) {
        this(false, error, null);
    }

    private OperationResult(boolean isSuccess, String error, T data) {
        this.isSuccess = isSuccess;
        this.error = error;
        this.data = data;
    }

    /**
     * Success
     *
     * @param <T> Generic param
     * @return Response message {@code Result}
     */
    public static <T> OperationResult<T> success() {
        return new OperationResult<>(true);
    }
    public static <T> OperationResult<T> failure() {
        return new OperationResult<>(false);
    }
    public static <T> OperationResult<T> failure(String error) {
        return new OperationResult<>(error);
    }


    /**
     * @param data Response data
     * @param <T> Generic param
     * @return Response message {@code Result}
     */
    public static <T> OperationResult<T> success(T data) {
        return new OperationResult<>(true, data);
    }
}
