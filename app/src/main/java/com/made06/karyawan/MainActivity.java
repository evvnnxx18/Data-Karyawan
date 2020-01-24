package com.made06.karyawan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnAdd;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    List<Karyawan> data;
    public static KaryawanDB karyawanDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.addBtn);
        btnAdd.setOnClickListener(this);

        karyawanDB = Room.databaseBuilder(getApplicationContext(), KaryawanDB.class,"karyawandb.sqlite").allowMainThreadQueries().build();

        recyclerView = (RecyclerView) findViewById(R.id.xRecycler);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        data = karyawanDB.karyawanDAO().getKaryawan();
        adapter = new KaryawanAdapter(data);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addBtn:
                Intent fun = new Intent(MainActivity.this,karyawan_add.class);
                startActivity(fun);
                break;
        }
    }
}
