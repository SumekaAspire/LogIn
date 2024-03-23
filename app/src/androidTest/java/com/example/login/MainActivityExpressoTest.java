package com.example.login;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;


@RunWith(AndroidJUnit4.class)
public class MainActivityExpressoTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testUIElementsDisplayed() {
        // To check UI elements are displayed
        onView(withId(R.id.date)).check(matches(isDisplayed()));
        onView(withId(R.id.time)).check(matches(isDisplayed()));
        onView(withId(R.id.image)).check(matches(isDisplayed()));
        onView(withId(R.id.name)).check(matches(isDisplayed()));
        onView(withId(R.id.email)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
        onView(withId(R.id.button)).check(matches(isDisplayed()));
    }


    @Test
    public void testLoginButton() {
        // Perform actions by typing text in EditText & click the login button
        onView(withId(R.id.name)).perform(typeText("Sumeka"));
        onView(withId(R.id.email)).perform(ViewActions.typeText("test@example.com"));
        onView(withId(R.id.password)).perform(typeText("password"));
        onView(withId(R.id.button)).perform(click());


    }
}
