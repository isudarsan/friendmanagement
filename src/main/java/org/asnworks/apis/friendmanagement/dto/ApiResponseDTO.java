/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

/**
 * @author sudambat
 */
public class ApiResponseDTO {

    private boolean success;

    public ApiResponseDTO(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
