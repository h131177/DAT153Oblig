package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

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

    private PersonDao dao = new PersonDao();
    private List<Person> personList = dao.getAllPersons();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);

        final Button add_entry = (Button) findViewById(R.id.add_entry);
        Intent entry = new Intent(this,AddEntryActivity.class);
        //Overfører heile listen med personer til addEntry aktiviteten
        entry.putExtra("liste", String.valueOf(personList));
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
                }
            });



        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.fragmentContainerView, fragment);
            transaction.commit();
        }
    }

}