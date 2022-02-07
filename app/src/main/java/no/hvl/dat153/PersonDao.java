package no.hvl.dat153;

import android.graphics.Color;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PersonDao implements Dao{

    Uri ObamaB = Uri.parse("android.resource://no.hvl.dat153/drawable/obama");
    Uri PutinB = Uri.parse("android.resource://no.hvl.dat153/drawable/putin");
    Uri TrumpB = Uri.parse("android.resource://no.hvl.dat153/drawable/trump");
    Uri SandersB = Uri.parse("android.resource://no.hvl.dat153/drawable/sanders");
    Uri TrudeauB = Uri.parse("android.resource://no.hvl.dat153/drawable/trudeau");
    Uri HillaryB = Uri.parse("android.resource://no.hvl.dat153/drawable/hillary");
    Uri JoeyB = Uri.parse("android.resource://no.hvl.dat153/drawable/joe");
    Uri JohnsonB = Uri.parse("android.resource://no.hvl.dat153/drawable/johnson");
    Uri WarrenB = Uri.parse("android.resource://no.hvl.dat153/drawable/warren");
    Uri MerkelB = Uri.parse("android.resource://no.hvl.dat153/drawable/merkel");
    Uri HarrisB = Uri.parse("android.resource://no.hvl.dat153/drawable/harris");

    //mockdatabase
    final List<Person> peoples = new LinkedList<>(Arrays.asList(
            new Person("Barack Obama", ObamaB),
            new Person("Vladimir Putin", PutinB),
            new Person("Donald Trump", TrumpB),
            new Person("Bernie Sanders",SandersB),
            new Person("Justin Trudeau", TrudeauB),
            new Person("Joe Biden", JoeyB),
            new Person("Hillary Clinton", HillaryB),
            new Person("Boris Johnson", JohnsonB),
            new Person("Elisabeth Warren", WarrenB),
            new Person("Angela Merkel", MerkelB),
            new Person("Kamala Harris", HarrisB)));
    List<String> names = new ArrayList<>();

    public PersonDao() {

    }

    public static PersonDao getInstance() {
        if(instance == null) {
            instance = new PersonDao();
        }
        return instance;
    }

    private static PersonDao instance;

    public List<String> getNames(){
        Iterator<Person> it = peoples.iterator();
        while(it.hasNext()){
            names.add(it.next().getName());
        }
        return names;
    }

    @Override
    public List<Person> getAllPersons() {
        return peoples;
    }

    @Override
    public Person getPerson(int index) {
        return peoples.get(index);
    }

    @Override
    public void insert(Person p) {
        peoples.add(p);
    }

    @Override
    public void delete(Person p) {
        peoples.remove(p);
    }


}
