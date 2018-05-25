/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

/**
 * @author sudambat
 */
public class ExceptionResponseDTO extends ApiResponseDTO {

    private String errorCode;
    private String message;

    public ExceptionResponseDTO(String errorCode, String message) {
        super(false);
        this.setErrorCode(errorCode);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
