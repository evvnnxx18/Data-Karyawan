package com.made06.karyawan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class karyawan_view extends AppCompatActivity {

    TextView namae, emaile,nohpe,alamate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karyawan_view);

        namae = (TextView) findViewById(R.id.txt_name);
        emaile = (TextView) findViewById(R.id.txt_email);

        Bundle bundle = getIntent().getExtras();
        namae.setText(bundle.getString("nama"));
        emaile.setText(bundle.getString("email"));
    }
}
