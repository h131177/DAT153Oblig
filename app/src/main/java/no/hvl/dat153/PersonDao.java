package no.hvl.dat153;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM person")
    public LiveData<List<Person>> getAllPersons();

    @Insert
    public void insert(Person p);
    @Delete
    public void delete(Person p);

    @Query("SELECT * FROM person ORDER BY name DESC;")
    public LiveData<List<Person>> getAllPersonsDesc();

    @Query("SELECT * FROM person ORDER BY name ASC;")
    public LiveData<List<Person>> getAllPersonsAsc();
}

