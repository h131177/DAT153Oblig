package no.hvl.dat153;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private PersonRepository repository;
    private LiveData<List<Person>> personList;
    private LiveData<List<Person>> personListDesc;
    private LiveData<List<Person>> personListAsc;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonRepository(application);
        personList = repository.getAllPersons();
        personListDesc = repository.getAllPersonsDesc();
        personListAsc = repository.getAllPersonsAsc();

    }

    public LiveData<List<Person>> getAllPerson(){
        return personList;
    }
    public LiveData<List<Person>> getAllPersonsDesc(){return personListDesc;};
    public LiveData<List<Person>> getAllPersonsAsc(){return personListAsc;};

    public void insert(Person person){
        repository.insertPerson(person);
    }
    public void delete(Person person){
        repository.deletePerson(person);
    }
}
