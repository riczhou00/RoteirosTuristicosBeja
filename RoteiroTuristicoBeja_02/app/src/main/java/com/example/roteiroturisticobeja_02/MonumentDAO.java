package com.example.roteiroturisticobeja_02;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MonumentDAO {
    @Query("SELECT * FROM Monuments")
    List<Monuments> getAll();

    @Query("SELECT * FROM Monuments WHERE id = :monumentId")
    Monuments getById(long monumentId);


}
