package com.made06.karyawan;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "karyawan")
public class Karyawan {

    @PrimaryKey(autoGenerate = true)
    Integer id;

    @ColumnInfo(name = "nama")
    String nama;
    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "no_hp")
    String no_hp;

    @ColumnInfo(name ="alamat")
    String alamat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
