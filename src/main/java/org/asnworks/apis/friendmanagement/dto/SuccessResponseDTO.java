/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

import org.springframework.http.HttpStatus;

/**
 * @author sudambat
 *
 */
public class SuccessResponseDTO extends ApiResponseDTO {

    public SuccessResponseDTO() {
        super(true, HttpStatus.OK);
    }

}
