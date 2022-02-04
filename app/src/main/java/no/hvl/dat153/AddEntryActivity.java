package no.hvl.dat153;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class AddEntryActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_OPEN = 1;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        Button btnChoose = findViewById(R.id.choosePictureButton);
        Button btnAdd = findViewById(R.id.addButton);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            personList = MainActivity.personList;
            //personList = extras.getParcelableArrayList("liste");
            System.out.println("personList: " + personList);
        }
        System.out.println("Første item: " + personList.get(0).getName());

        btnChoose.setOnClickListener((View v) -> {
            selectImage();
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
            Uri fullPhotoUri = data.getData();
            // Do work with full size photo saved at fullPhotoUri

        }
    }
}