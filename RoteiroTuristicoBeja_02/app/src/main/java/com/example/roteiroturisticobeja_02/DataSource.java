package com.example.roteiroturisticobeja_02;

import android.content.Context;

import java.util.List;

public class DataSource {

    private DataSource() {

    }
    public static Monuments getMonument(Context context, long id) {
        return AppDatabase.getInstance(context).getMonumentDAO().getById(id);
    }
}

