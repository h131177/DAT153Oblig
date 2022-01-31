package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    protected Map<String, Object> actions = new HashMap<>();

    void prepareMenu() {
        //adding them to the map
        addMenuItem("Forms", dbActivity.class);
        addMenuItem("Indicators", QuizActivity.class);
        addMenuItem("Containers", AddEntryActivity.class);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareMenu();
        String[] keys = actions.keySet().toArray(new String[actions.keySet().size()]);



    }

    public void addMenuItem(String label, Class<?> cls) {
        actions.put(label, new Intent(this, cls));
    }
}