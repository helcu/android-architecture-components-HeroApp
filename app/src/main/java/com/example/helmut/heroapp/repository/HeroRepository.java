package com.example.helmut.heroapp.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.helmut.heroapp.HeroRoom;
import com.example.helmut.heroapp.dao.HeroDao;
import com.example.helmut.heroapp.model.HeroModel;

import java.util.List;

public class HeroRepository {

    private HeroDao heroDao;
    //private LiveData<List<HeroModel>> heroList;


    public HeroRepository(Application app){

        HeroRoom heroRoom =  HeroRoom.getInstance(app.getApplicationContext());
        heroDao = heroRoom.GetHeroDao();

        //heroList = heroDao.GetAll();

    }


    public LiveData<List<HeroModel>> getHeroList() {
        return heroDao.GetAll();
    }


    public void insert(HeroModel obj){

        new InsertAsyncTask(heroDao).execute(obj);

    }



    private static class InsertAsyncTask extends AsyncTask<HeroModel, Void,Void >{


        HeroDao heroDao;

        public InsertAsyncTask(HeroDao heroDao ){

            this.heroDao = heroDao;

        }

        @Override
        protected Void doInBackground(HeroModel... heroModels) {

            heroDao.Insert(heroModels[0]);
            return null;
        }
    }


}
