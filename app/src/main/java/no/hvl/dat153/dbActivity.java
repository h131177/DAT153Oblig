package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import no.hvl.dat153.recyclerview.CustomAdapter;
import no.hvl.dat153.recyclerview.RecyclerViewFragment;

public class dbActivity extends AppCompatActivity{

    //private PersonDao dao;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //dao = new PersonDao();
        //personList = dao.getAllPersons();
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
                        System.out.println("sort button 1 ");
                        return (person.getName().compareTo(t1.getName()));
                    }
                });
                //fragment();
            }
        });

        final Button sortRevAlpha = findViewById(R.id.sortButton2);
            sortRevAlpha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Collections.sort(personList, new Comparator<Person>() {
                        @Override
                        public int compare(Person person, Person t1) {
                            System.out.println("sort button 2");
                            return (person.getName().compareTo(t1.getName()));
                        }
                    });
                    Collections.reverse(personList);
                    fragment(savedInstanceState);

                }
            });

        fragment(savedInstanceState);
    }

    private void fragment(Bundle savedInstanceState){
        Intent db = new Intent(this,RecyclerViewFragment.class);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        RecyclerViewFragment fragment = new RecyclerViewFragment();
        transaction.replace(R.id.fragmentContainerView, fragment);
        Bundle bundle = new Bundle();
        List<Person> pl = new ArrayList<Person>();
        Iterator<Person> i = personList.iterator();

       // bundle.putSerializable("personList", personList);
        transaction.commit();

    }


}