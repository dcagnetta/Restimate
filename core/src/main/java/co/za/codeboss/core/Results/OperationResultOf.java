package co.za.codeboss.core.Results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationResultOf<T> extends OperationResult{
    /**
     * Result data
     */
    private T data;

    public OperationResultOf() {
    }

    private OperationResultOf(boolean isSuccess) {
        this(isSuccess, null);
    }

    private OperationResultOf(boolean isSuccess, T data) {
        this(isSuccess, null, data);
    }


    private OperationResultOf(boolean isSuccess, String error, T data) {
        this.isSuccess = isSuccess;
        this.error = error;
        this.data = data;
    }



    /**
     * @param data Response data
     * @param <T> Generic param
     * @return Response message {@code Result}
     */
    public static <T> OperationResultOf<T> success(T data) {
        return new OperationResultOf<>(true, data);
    }
}
