package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class AddEntryActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_OPEN = 1;

    private ImageView iv;
    private EditText nameInput;
    private Uri fullPhotoUri;
    //private PersonDao dao;
    private List<Person> personList;
    MainViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //dao = new PersonDao();
        //personList = PersonDao.getInstance().peoples;
        
        //PersonDao personDao = AppDatabase.getDatabase(getApplicationContext()).personDao();
        //personList = personDao.getAllPersons();
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        Button btnChoose = findViewById(R.id.choosePictureButton);
        Button btnAdd = findViewById(R.id.addButton);
        iv = findViewById(R.id.imagePreview);
        nameInput = findViewById(R.id.editTextName);

        btnChoose.setOnClickListener((View v) -> {
            selectImage();
        });

        btnAdd.setOnClickListener((View v) -> {
            String name = nameInput.getText().toString();
            //TODO Fix CurrentColor
            Person p = new Person(name, fullPhotoUri.toString());
            System.out.println(p);
            //PersonDao.getInstance().insert(p);
            //personDao.insert(p);
            mViewModel.insert(p);
            // TODO Add toast message
            String text = "Image of " + name + " added to database";
            Toast.makeText(AddEntryActivity.this, text, Toast.LENGTH_SHORT).show();
        });
    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_IMAGE_OPEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_OPEN && resultCode == RESULT_OK) {
            fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri
            iv.setImageURI(fullPhotoUri);

            getContentResolver().takePersistableUriPermission(fullPhotoUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
    }
}