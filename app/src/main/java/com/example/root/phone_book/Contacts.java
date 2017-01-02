package com.example.root.phone_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Contacts extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        tv = (TextView) findViewById(R.id.show_data);

        DB db = new DB(getApplicationContext());
        String[] data= db.select_data();
        String s="";
        for (int i=0; i<data.length; i++ ){
            s = s + data[i]+"\n\n";
        }
        tv.setText(s);
    }


}
