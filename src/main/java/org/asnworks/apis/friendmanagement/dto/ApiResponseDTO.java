/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

import org.springframework.http.HttpStatus;

/**
 * @author sudambat
 */
public class ApiResponseDTO {

    private final boolean success;
    private int httpStatusCode;

    public ApiResponseDTO(boolean success, HttpStatus httpStatus) {
        this.success = success;
        this.httpStatusCode = httpStatus.value();
    }

    public boolean isSuccess() {
        return success;
    }


}
