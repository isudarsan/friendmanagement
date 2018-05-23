/**
 * 
 */
package org.asnworks.apis.friendmanagement.service;

import org.asnworks.apis.friendmanagement.domain.AppUser;

/**
 * @author sudambat
 *
 */
public interface AppUserService {

    AppUser signUp(final String email);
}
