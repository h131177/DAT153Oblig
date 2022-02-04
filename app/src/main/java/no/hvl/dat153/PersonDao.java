package no.hvl.dat153;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements Dao{

    List<Person> peoples;

    public PersonDao() {
        peoples = new ArrayList<Person>();
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
