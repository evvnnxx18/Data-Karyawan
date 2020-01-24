package com.made06.karyawan;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Karyawan.class},version = 1,exportSchema = false)
public abstract class KaryawanDB extends RoomDatabase {

    public abstract KaryawanDAO karyawanDAO();
}
