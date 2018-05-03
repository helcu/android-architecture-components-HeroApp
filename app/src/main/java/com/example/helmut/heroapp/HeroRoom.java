package com.example.helmut.heroapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.helmut.heroapp.dao.HeroDao;
import com.example.helmut.heroapp.model.HeroModel;

@Database(entities = {HeroModel.class}, version = 1)
public abstract class HeroRoom extends RoomDatabase{

    private static HeroRoom INSTANCE;

    public abstract HeroDao GetHeroDao();

    public static  HeroRoom getInstance(Context ctx){

            if(INSTANCE == null){

                INSTANCE = Room.databaseBuilder(ctx.getApplicationContext(), HeroRoom.class, "heroDb").build();
            }
            return INSTANCE;

    }


}
