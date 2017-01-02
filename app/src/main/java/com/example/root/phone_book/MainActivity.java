package com.example.root.phone_book;

import android.app.Application;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e_name, e_number, e_type, e_note;
    Button b_save, b_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e_name = (EditText) findViewById(R.id.name);
        e_number = (EditText) findViewById(R.id.number);
        e_type = (EditText) findViewById(R.id.type);
        e_note = (EditText) findViewById(R.id.note);
        b_save = (Button) findViewById(R.id.btn_save);
        b_show = (Button) findViewById(R.id.show);

        final DB db = new DB(getApplicationContext());

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = e_name.getText().toString().trim();
                String number = e_number.getText().toString().trim();
                String type = e_type.getText().toString().trim();
                String note = e_note.getText().toString().trim();
                PBFunctions fn = new PBFunctions(name, number, type, note);
                db.insert_data(fn);
                Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_LONG).show();
            }
        });

        b_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Contacts.class));
            }
        });
    }
}
