package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.hvl.dat153.recyclerview.CustomAdapter;
import no.hvl.dat153.recyclerview.RecyclerViewFragment;

public class dbActivity extends AppCompatActivity{

    private List<Person> person;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //personList = PersonDao.getInstance().peoples;
        //personList = AppDatabase.getDatabase(getApplicationContext()).personDao().getAllPersons();

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.getAllPerson().observe(this, (List<Person> personList) ->{
            person = personList;
        });


        final Button add_entry = (Button) findViewById(R.id.add_entry);
        Intent entry = new Intent(this,AddEntryActivity.class);
        add_entry.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(entry);
            }
        });

/*

       final Button sortAlpha = findViewById(R.id.sortButton);
        sortAlpha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sortDesc();
                fragment(savedInstanceState);
            }
        });

        final Button sortRevAlpha = findViewById(R.id.sortButton2);
            sortRevAlpha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.sort(person, new Comparator<Person>() {
                        @Override
                        public int compare(Person person, Person t1) {
                            return (person.getName().compareTo(t1.getName()));
                        }
                    });
                    Collections.reverse(person);
                    fragment(savedInstanceState);

                }
            });
*/
        //fragment(savedInstanceState);

    }



   /* private void fragment(Bundle savedInstanceState){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();

    }*/



}