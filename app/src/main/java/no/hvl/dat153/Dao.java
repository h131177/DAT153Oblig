package no.hvl.dat153;

import java.util.List;

public interface Dao {
    public List<Person> getAllPersons();
    public Person getPerson(int index);
    public void insert(Person p);
    public void delete(Person p);
}

