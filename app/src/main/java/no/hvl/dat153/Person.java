package no.hvl.dat153;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private String path;

    public Person() {
    }

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

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(path);
    }
}
