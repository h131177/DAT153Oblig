package no.hvl.dat153;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainMenuButtonTest {

    @Rule
    public ActivityScenarioRule activityScenarioRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void clickButtonToActivity() {
        onView(withId(R.id.see_list))
                .check(matches(isDisplayed()));

        onView(withId(R.id.see_list))
                .perform(click());

        //intended(hasComponent(dbActivity.class.getName()));
    }
}
