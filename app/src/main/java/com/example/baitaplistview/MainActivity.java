package com.example.baitaplistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    Button them;
    Button capnhap;
    EditText edtName;

    int vitri = -1;



    ArrayList<String> arrayCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.listview1);
        them = (Button) findViewById(R.id.bt_add) ;
        edtName = (EditText)findViewById(R.id.editTextName);
        capnhap = (Button) findViewById(R.id.bt_update);

        arrayCourse = new ArrayList<>();

        arrayCourse.add("1");
        arrayCourse.add("2");
        arrayCourse.add("3");
        arrayCourse.add("4");
        arrayCourse.add("5");
        arrayCourse.add("6");
        arrayCourse.add("7");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);

        lv1.setAdapter(adapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtName.setText(arrayCourse.get(i));
                vitri = i;

            }
        });

        them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = edtName.getText().toString();
                arrayCourse.add(Name);
                adapter.notifyDataSetChanged();
            }
        });

        capnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri, edtName.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}