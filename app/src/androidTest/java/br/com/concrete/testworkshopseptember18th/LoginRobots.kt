package br.com.concrete.testworkshopseptember18th

import android.app.Activity
import android.app.Instrumentation
import androidx.annotation.StringRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers


class loginArrange(action: loginArrange.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun mockHomeActivityIntent() {
        Intents.intending(IntentMatchers.hasComponent(HomeActivity::class.java.name))
            .respondWith(Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null))
    }
}

class loginAct(action: loginAct.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun typeEmail(email: String) {
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .perform(ViewActions.typeText(email))
    }

    fun typePassword(password: String) {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .perform(ViewActions.typeText(password))
    }

    fun clickLogin() {
        Espresso.onView(ViewMatchers.withId(R.id.do_login))
            .perform(ViewActions.click())
    }
}

class loginAssert(action: loginAssert.() -> Unit) {
    init {
        action.invoke(this)
    }

    fun checkHomeActivityIntentWasCalled() {
        Intents.intended(IntentMatchers.hasComponent(HomeActivity::class.java.name))
    }

    fun checkEmailFieldIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.email))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkPasswordFieldIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.password))
            .check(ViewAssertions.matches(ViewMatchers.withText("")))
    }

    fun checkMessageWasShown(@StringRes messageRes: Int) {
        Espresso.onView(ViewMatchers.withText(messageRes))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}