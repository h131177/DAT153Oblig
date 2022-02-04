package no.hvl.dat153;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private Uri path;
    private int currentColor;

    public Person() {
    }

    public Person(String name, Uri path, int currentColor) {
        this.name = name;
        this.path = path;
        this.currentColor = currentColor;
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

    public void setPath(Uri path) {
        this.path = path;
    }

    public int getCurrentColor() { return currentColor;}

    public void setCurrentColor() { this.currentColor = currentColor;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(String.valueOf(path));
    }
}
