package no.hvl.dat153;

import android.app.Activity;
import android.content.Intent;

import androidx.activity.result.ActivityResult;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class AddActivityTest {

    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(AddEntryActivity.class);

    @Test
    public void addPerson() {
        // Build the result to return when the activity is launched.
        Intent resultData = new Intent();
        String name = "Angela Merkel";
        String path = "android.resource://no.hvl.dat153/drawable/merkel";
        resultData.putExtra("name", name);
        resultData.putExtra("path", path);
        ActivityResult result =
                new ActivityResult(Activity.RESULT_OK, resultData);
    }
}
