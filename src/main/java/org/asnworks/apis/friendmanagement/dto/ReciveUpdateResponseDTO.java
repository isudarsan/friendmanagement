/**
 * 
 */
package org.asnworks.apis.friendmanagement.dto;

import java.util.List;

/**
 * @author sudambat
 *
 */
public class ReciveUpdateResponseDTO extends ApiResponseDTO {

    private List<String> recipients;

    public ReciveUpdateResponseDTO(List<String> recipients) {
        super(true);
        this.recipients = recipients;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }
}
