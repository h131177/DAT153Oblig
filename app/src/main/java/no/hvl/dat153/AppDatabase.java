package no.hvl.dat153;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();

    private static AppDatabase INSTANCE;

//    Room.databaseBuilder(appContext, AppDatabase.class, "Sample.db")
//            .createFromAsset("database/myapp.db")
//    .fallbackToDestructiveMigration()
//    .build();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context, AppDatabase.class, "person.db")
                                    .createFromAsset("person.db")
                                    .allowMainThreadQueries()
                                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
