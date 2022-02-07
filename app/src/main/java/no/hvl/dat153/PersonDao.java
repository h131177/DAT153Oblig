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

    List<Person> peoples = new LinkedList<>(Arrays.asList(
            new Person("Obama", ObamaB),
            new Person("Putin", PutinB),
            new Person("Trump", TrumpB),
            new Person("Bernie Sanders",SandersB),
            new Person("Justin Trudeau", TrudeauB)));
    List<String> names = new ArrayList<>();

    public PersonDao() {

    }

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
