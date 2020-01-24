package com.made06.karyawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class karyawan_add extends AppCompatActivity {

    EditText namaAdd,emailAdd,nohpAdd,alamatAdd;
    ImageButton saveAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karyawan_add);

        namaAdd = findViewById(R.id.txt_name);
        emailAdd = findViewById(R.id.txt_email);
        alamatAdd = findViewById(R.id.txt_address);
        nohpAdd = findViewById(R.id.txt_phone);

        saveAdd = findViewById(R.id.btnSimpan);
        saveAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (namaAdd.getText().toString().isEmpty() && emailAdd.getText().toString().isEmpty() && alamatAdd.getText().toString().isEmpty() && nohpAdd.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Isi semua kolom", Toast.LENGTH_LONG).show();
                }else{
                    Karyawan karyawan = new Karyawan();
                    karyawan.setNama(namaAdd.getText().toString());
                    karyawan.setEmail(emailAdd.getText().toString());
                    karyawan.setAlamat(alamatAdd.getText().toString());
                    karyawan.setNo_hp(nohpAdd.getText().toString());

                    MainActivity.karyawanDB.karyawanDAO().addKaryawan(karyawan);
                    Toast.makeText(getBaseContext(),"Data telah disimpan", Toast.LENGTH_SHORT).show();

                    nohpAdd.setText(null);
                    emailAdd.setText(null);
                    namaAdd.setText(null);
                    alamatAdd.setText(null);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(karyawan_add.this, MainActivity.class);
                            startActivity(intent);
                        }
                    },500);
                }
            }
        });
    }
}
