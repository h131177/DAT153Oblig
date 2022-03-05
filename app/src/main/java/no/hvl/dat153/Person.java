package no.hvl.dat153;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity(tableName = "person")
public class Person implements Parcelable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo (name = "path")
    private String path;


    public Person(String name, String path) {
        this.name = name;
        this.path = path;
    }

    protected Person(Parcel in) {
        name = in.readString();
        path = in.readString();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(String.valueOf(path));
    }
    public int randomColor() {
        Random rnd = new Random();
        int currentColor = Color.argb(69, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        return currentColor;
    }


}
