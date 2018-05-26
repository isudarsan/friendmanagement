/**
 * 
 */
package org.asnworks.apis.friendmanagement.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

/**
 * @author sudambat
 */
public class ValidationUtilsTest {

    ValidationUtils utils = new ValidationUtils();

    @Test
    public void testExtractMailsFromText() {
        String text = "Hello @abc@gmail.com, how are you ! pqr@gmail.com";
        List<String> extractedMails = utils.extractMailsFromText(text);
        assertEquals(2, extractedMails.size());
    }

    @Test
    public void testExtractMailsFromText_Emails() {
        String text = "Hello @abc@gmail.com, how are you ! pqr@gmail.com";
        List<String> extractedMails = utils.extractMailsFromText(text);
        assertTrue(extractedMails.contains("abc@gmail.com"));
        assertTrue(extractedMails.contains("pqr@gmail.com"));
    }

    @Test
    public void testIsValidEmail() {
        String email1 = "abc@gmail.com";
        String email2 = "asn@@yahoo.com";
        assertTrue(utils.isValidEmail(email1));
        assertFalse(utils.isValidEmail(email2));

    }

}
