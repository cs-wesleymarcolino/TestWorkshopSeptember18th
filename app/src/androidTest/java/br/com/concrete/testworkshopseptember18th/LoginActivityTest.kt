package br.com.concrete.testworkshopseptember18th

import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmailAndPasswordEmpty() {
        loginAssert {
            checkEmailFieldIsEmpty()
            checkPasswordFieldIsEmpty()
        }
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmailIsEmptyError() {
        loginAct {
            typePassword("aA#412345")
            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.error_email_is_empty)
        }
    }

    @Test
    fun givenPasswordIsEmpty_whenLogin_shouldShowPasswordIsEmpty() {
        loginAct {
            typeEmail("w.jonathan.marcolino@accenture.com")

            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.error_password_is_empty)
        }
    }

    @Test
    fun givenPasswordIsInvalid_whenLogin_shouldShowInvalidPassword() {
        loginAct {
            typeEmail("w.jonathan.marcolino@accenture.com")
            typePassword("123456")

            clickLogin()
        }

        loginAssert {
            checkMessageWasShown(R.string.error_password_is_invalid)
        }
    }

    @Test
    fun givenEmailAndPasswordAreValid_whenLogin_shouldGoToHomeScreen() {
        loginArrange {
            mockHomeActivityIntent()
        }

        loginAct {
            typeEmail("w.jonathan.marcolino@accenture.com")
            typePassword("aA#123453")

            clickLogin()
        }

        loginAssert {
            checkHomeActivityIntentWasCalled()
        }
    }
}