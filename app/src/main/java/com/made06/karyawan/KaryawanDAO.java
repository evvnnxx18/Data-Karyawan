package com.made06.karyawan;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface KaryawanDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addKaryawan(Karyawan karyawan);

    @Query("SELECT * FROM karyawan")
    public List<Karyawan> getKaryawan();

    @Query("SELECT * FROM karyawan WHERE karyawan.id=:id")
    Karyawan getOnlyOne(int id);

    @Update
    public void upKaryawan(Karyawan karyawan);

    @Delete
    public  void deleteKaryawan(Karyawan karyawan);


}
