package br.com.concrete.testworkshopseptember18th.mockexample

import br.com.concrete.testworkshopseptember18th.PasswordValidator
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ValidatorTest {

    private lateinit var passwordValidatorMock: PasswordValidator
    private lateinit var validator: Validator

    @Before
    fun setup() {
        passwordValidatorMock = mockk()
        validator =
            Validator(passwordValidatorMock)
    }

    @Test
    fun givenNameIsShorterThan8_whenValidate_shouldReturnFalse() {
        every { passwordValidatorMock.isValid(any()) } returns true

        val result = validator.validate("Wesley", "")

        assertFalse(result)
    }

    @Test
    fun givenPasswordIsInvalid_whenValidate_shouldReturnFalse() {
        every { passwordValidatorMock.isValid(any()) } returns false

        val result = validator.validate("Wesley Marcolino", "")

        assertFalse(result)
    }

    @Test
    fun givenNameIsLongerThan8_whenValidate_shouldReturnTrue() {
        every { passwordValidatorMock.isValid(any()) } returns true

        val result = validator.validate("Wesley Marcolino", "")

        assertTrue(result)
    }
}