package co.za.codeboss.core.Results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationResult {

    /**
     * success status
     */
    protected boolean isSuccess;

    /**
     * error message
     */
    protected String error;

    /**
     * Constructors
     */
    protected OperationResult() {   }
    private OperationResult(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    private OperationResult(String error) {
        this(false);
        this.error = error;
    }

    /**
     * Factories
     *
     * @return OperationResult {@code Result}
     */

    public static OperationResult success() {
        return new OperationResult(true);
    }
    public static OperationResult failure() {
        return new OperationResult(false);
    }
    public static OperationResult failure(String error) {
        return new OperationResult(error);
    }

}
