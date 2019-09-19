package br.com.concrete.testworkshopseptember18th

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun givenInitialState_shouldHaveEmailAndPasswordEmpty() {
        onView(withId(R.id.email))
            .check(matches(withText("")))

        onView(withId(R.id.password))
            .check(matches(withText("")))
    }

    @Test
    fun givenEmailIsEmpty_whenLogin_shouldShowEmailIsEmptyError() {
        onView(withId(R.id.password))
            .perform(typeText("aA#412345"))

        onView(withId(R.id.do_login))
            .perform(click())

        onView(withText(R.string.error_email_is_empty))
            .check(matches(isDisplayed()))
    }
}
