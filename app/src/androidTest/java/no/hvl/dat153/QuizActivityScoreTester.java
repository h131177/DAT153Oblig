package no.hvl.dat153;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class QuizActivityScoreTester {
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(QuizActivity.class);

    @Test
    public void scoreTest() {
        onView(withId(R.id.submit)).perform(click());
        int button = no.hvl.dat153.QuizActivity.getCorrectButton();
        onView(withId(button)).perform(click());
        onView(withId(R.id.submit)).perform(click());


        int wrongbutton = no.hvl.dat153.QuizActivity.getWrongButton1();
        onView(withId(wrongbutton)).perform(click());
        onView(withId(R.id.submit)).perform(click());

        int wrongbutton1 = no.hvl.dat153.QuizActivity.getWrongButton2();
        onView(withId(wrongbutton1)).perform(click());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.score)).check(matches(withText("Score: " + 1 + " of " + 3)));
    }
}
