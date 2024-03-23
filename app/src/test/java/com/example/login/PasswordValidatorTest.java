package com.example.login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PasswordValidatorTest {

    @Test
    public void testValidPasswordPattern(){
        assertTrue(MainActivity.isValidPassword("valid!123"));
    }//".*[!@#$%^&*()].*"
    @Test
    public void passwordValidatorCorrectPassword() {
        assertTrue(MainActivity.isValidPassword("1en(.*of^"));

    }
    @Test
    public void testValidPassword() {
        assertFalse(MainActivity.isValidPassword("validPassword123"));
    }

    @Test
    public void testInvalidPassword_Null()
    {
        assertFalse(MainActivity.isValidPassword(null));
    }
    @Test
    public void testInValidPasswordPattern(){
        assertFalse(MainActivity.isValidPassword("valid@"));
    }
    @Test
    public void testInvalidPassword_TooShort() {

        assertFalse(MainActivity.isValidPassword("short"));
    }

}