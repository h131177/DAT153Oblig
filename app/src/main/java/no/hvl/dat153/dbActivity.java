package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.hvl.dat153.recyclerview.RecyclerViewFragment;

public class dbActivity extends AppCompatActivity{

    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        personList = PersonDao.getInstance().peoples;

        final Button add_entry = (Button) findViewById(R.id.add_entry);
        Intent entry = new Intent(this,AddEntryActivity.class);
        add_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(entry);
            }
        });


        final Button sortAlpha = findViewById(R.id.sortButton);
        sortAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(personList, new Comparator<Person>() {
                    @Override
                    public int compare(Person person, Person t1) {
                        return (person.getName().compareTo(t1.getName()));
                    }
                });
                fragment(savedInstanceState);
            }
        });

        final Button sortRevAlpha = findViewById(R.id.sortButton2);
            sortRevAlpha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.sort(personList, new Comparator<Person>() {
                        @Override
                        public int compare(Person person, Person t1) {
                            return (person.getName().compareTo(t1.getName()));
                        }
                    });
                    Collections.reverse(personList);
                    fragment(savedInstanceState);

                }
            });


    }

    private void fragment(Bundle savedInstanceState){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();

    }


}