package br.com.concrete.testworkshopseptember18th

import org.junit.Test

import org.junit.Assert.*

class PasswordValidatorTest {
    @Test
    fun givenPasswordIsShorterThan8_whenValidate_shouldReturnFalse() {
        // arrange
        val password = "aA#4567"

        // act
        val result = PasswordValidator().isValid(password)

        // assert
        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveAnUppercaseLetter_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().isValid("aa#45678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveAnLowercaseLetter_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().isValid("AA#45678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveADigit_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().isValid("aa#aAaaf")

        assertFalse(result)
    }

    @Test
    fun givenPasswordDoesntHaveASpecialCharacter_whenValidate_shouldReturnFalse() {
        val result = PasswordValidator().isValid("aaAa45678")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsValid_whenValidate_shouldReturnTrue() {
        val result = PasswordValidator().isValid("aA#112345")

        assertTrue(result)
    }
}
