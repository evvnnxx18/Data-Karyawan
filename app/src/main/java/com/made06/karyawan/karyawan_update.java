package com.made06.karyawan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.made06.karyawan.MainActivity.karyawanDB;

public class karyawan_update extends AppCompatActivity {

    EditText ed_nama,ed_email,ed_nohp,ed_alamat;
    ImageButton saveUpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karyawan_update);

        init();

        int getPassedData = getIntent().getIntExtra("id",0);

        Karyawan object = karyawanDB.karyawanDAO().getOnlyOne(getPassedData);

        ed_nama.setText(object.getNama());
        ed_email.setText(object.getEmail());
        ed_nohp.setText(object.getNo_hp());
        ed_alamat.setText(object.getAlamat());

        saveUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed_nama.getText().toString().isEmpty() && ed_email.getText().toString().isEmpty() && ed_nohp.getText().toString().isEmpty() && ed_alamat.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "Isi semua kolom", Toast.LENGTH_LONG).show();
                }else{
                    Bundle bundle = getIntent().getExtras();
                    Karyawan karyawan = new Karyawan();
                    karyawan.setId(bundle.getInt("id"));
                    karyawan.setNama(ed_nama.getText().toString());
                    karyawan.setEmail(ed_email.getText().toString());
                    karyawan.setNo_hp(ed_nohp.getText().toString());
                    karyawan.setAlamat(ed_alamat.getText().toString());

                    MainActivity.karyawanDB.karyawanDAO().upKaryawan(karyawan);
                    Toast.makeText(getBaseContext(),"Data telah diupdate", Toast.LENGTH_LONG).show();
                    System.out.println(ed_nama.getText().toString());

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent fun = new Intent(karyawan_update.this, MainActivity.class);
                            startActivity(fun);
                        }
                    },500);
                }
            }
        });

    }

    private void init() {
        ed_nama = findViewById(R.id.ed_nama);
        ed_email = findViewById(R.id.ed_email);
        ed_nohp = findViewById(R.id.ed_nohp);
        ed_alamat = findViewById(R.id.ed_alamat);
        saveUpd = findViewById(R.id.ed_saveBtn);
    }
}
