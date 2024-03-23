package com.example.login;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailValidatorTest {

    @Test
    public void emailValidator_CorrectEmailReturnsTrue() {
        assertTrue(EmailValidatorTest.isValidEmail("name@email.com"));
        assertTrue(EmailValidatorTest.isValidEmail("nAme@example.co"));

    }


    @Test
    public void emailValidator_InvalidEmailSubDomain_ReturnsFalse() {
        assertFalse(EmailValidatorTest.isValidEmail("name@email.co.uk"));
    }

    @Test
    public void emailValidator_InvalidEmail_ReturnsFalse() {
        assertFalse("InValid email",EmailValidatorTest.isValidEmail("A-Z"));
        assertFalse("InValid email",EmailValidatorTest.isValidEmail("name@email"));
        assertFalse("InValid email",EmailValidatorTest.isValidEmail("name@email..com"));
        assertFalse("InValid email",EmailValidatorTest.isValidEmail("@email.com"));

    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse("InValid email",EmailValidatorTest.isValidEmail(""));
    }
    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse("InValid email",EmailValidatorTest.isValidEmail(null));
    }
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        String emailPattern = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
        return email.matches(emailPattern);
    }

}

