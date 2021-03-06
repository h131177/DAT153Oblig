package no.hvl.dat153;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;


import java.util.List;

public class PersonRepository {
    private LiveData<List<Person>> personList;
    private LiveData<List<Person>> personListDesc;
    private LiveData<List<Person>> personListAsc;
    private PersonDao personDao;

    PersonRepository(Application application){
        AppDatabase db = AppDatabase.getDatabase(application);
        personDao = db.personDao();
        personList = personDao.getAllPersons();
        personListDesc = personDao.getAllPersonsDesc();
        personListAsc = personDao.getAllPersonsAsc();
    }

    LiveData<List<Person>> getAllPersons(){return personList;}
    LiveData<List<Person>> getAllPersonsDesc(){return personListDesc;};
    LiveData<List<Person>> getAllPersonsAsc(){return personListAsc;};

    public void insertPerson(Person insert) {
        InsertAsyncTask task = new InsertAsyncTask(personDao);
        task.execute(insert);
    }

    public void deletePerson(Person delete){
        DeleteAsyncTask task = new DeleteAsyncTask(personDao);
        task.execute(delete);
    }

    private static class DeleteAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao asyncTaskDao;
        DeleteAsyncTask(PersonDao dao) { asyncTaskDao = dao;}
        @Override
        protected Void doInBackground(final Person... person) {
            asyncTaskDao.delete(person[0]);
            return null;
        }
    }

    private static class InsertAsyncTask extends AsyncTask<Person, Void, Void> {
        private PersonDao asyncTaskDao;
        InsertAsyncTask(PersonDao dao) { asyncTaskDao = dao;}
        @Override
        protected Void doInBackground(final Person... person) {
            asyncTaskDao.insert(person[0]);
            return null;
        }
    }
}
