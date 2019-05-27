package com.example.recyclerview3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Person> people;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people.add(new Person("Ritesh","Singh","car"));
                myAdapter.notifyDataSetChanged();
            }
        });


        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
    //      layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
    //      layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
          recyclerView.setLayoutManager(layoutManager);

        people = new ArrayList<Person>();
        people.add(new Person("Joha","Rambo","car"));
        people.add(new Person("Dinesh","Mayal","plane"));
        people.add(new Person("Saqlane","Mishra","mac"));
        people.add(new Person("Shubham","Singh","plane"));

        people.add(new Person("Renu","Rambo","mac"));
        people.add(new Person("Neha","Mayal","car"));
        people.add(new Person("Shumaila","Mishra","mac"));
        people.add(new Person("Ritesh","Singh","car"));

        people.add(new Person("Shweta","Rambo","mac"));
        people.add(new Person("Rajnish","Mayal","car"));
        people.add(new Person("Vikas","Mishra","mac"));
        people.add(new Person("Neha","Singh","car"));

        people.add(new Person("Ram","Rambo","mac"));
        people.add(new Person("Shayam","Mayal","plane"));
        people.add(new Person("Ghanshyam","Mishra","mac"));
        people.add(new Person("Sita","Singh","car"));

        people.add(new Person("Nancy","Rambo","mac"));
        people.add(new Person("Ritu","Mayal","plane"));
        people.add(new Person("Shila","Mishra","mac"));
        people.add(new Person("Asha","Singh","car"));

        myAdapter = new PersonAdapter(this,people);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this,"Surname: "+people.get(index).getSurname(),Toast.LENGTH_SHORT).show();
    }
}
