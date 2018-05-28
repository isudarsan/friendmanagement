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

    public static final String DUPLICATE_INVITATION_ERROR_CODE = "40001";

    public static final String DUPLICATE_SUBSCRIPTION_ERROR_CODE = "40003";

    public static final String FRIEND_BLOCKED_ERROR_CODE = "40002";

    public static final String INVALID_EMAIL_ERROR_CODE = "40006";

    public static final String INVALID_REQUEST_ERROR_CODE = "40000";

    public static final String INVALID_USER_ERROR_CODE = "40004";

    public static final String USER_DOES_NOT_EXISTS_ERROR_CODE = "40005";

    public static final String VALID_EMAIL_REGEX =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
}
