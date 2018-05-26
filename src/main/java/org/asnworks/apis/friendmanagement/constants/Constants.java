/**
 * 
 */
package org.asnworks.apis.friendmanagement.constants;

/**
 * @author sudambat
 */
public class Constants {

    public static final String JPA_REPO_PACKAGE = "org.asnworks.apis.friendmanagement.repo";

    public static final String ENTITY_SCAN_PACKAGE = "org.asnworks.apis.friendmanagement.domain";

    public static final String SERVICE_COMPONENT_SCAN_PACKAGE = "org.asnworks.apis.friendmanagement.service";

    public static final String EMAIL_REGEX_MATCHER = "([a-z0-9_.-]+)@([a-z0-9_.-]+[a-z])";

    public static final String UNKNOWN_ERROR_CODE = "5000";

    public static final String UNKNOWN_ERROR_MESSAGE = "Unknown Error";

    public static final String VALID_EMAIL_REGEX =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
}
