package no.hvl.dat153;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Random;

@Entity(tableName = "person")
public class Person implements Parcelable {

    @PrimaryKey
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo (name = "path")
    private Uri path;
    private int currentColor;

    public Person(String name, Uri path) {
        this.name = name;
        this.path = path;
        this.currentColor = randomColor();
    }

    protected Person(Parcel in) {
        name = in.readString();
        path = Uri.parse(in.readString());
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

    public Uri getPath() {
        return path;
    }

    public int getCurrentColor() {
        return currentColor;
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
