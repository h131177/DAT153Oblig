package no.hvl.dat153;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.app.Activity;
import android.security.identity.ResultData;
import android.util.Log;
import android.widget.RadioGroup;


@RunWith(AndroidJUnit4.class)
public class QuizActivityTotalTest {


    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(QuizActivity.class);


    @Test
    public void totalTest() {
        onView(withId(R.id.submit)).perform(click());
        int button = no.hvl.dat153.QuizActivity.getCorrectButton();

        onView(withId(button)).perform(click());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.score)).check(matches(withText("Score: " + 1 + " of " + 1)));
    }




}
