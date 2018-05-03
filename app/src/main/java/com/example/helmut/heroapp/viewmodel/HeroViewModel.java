package com.example.helmut.heroapp.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.helmut.heroapp.HeroRoom;
import com.example.helmut.heroapp.model.HeroModel;
import com.example.helmut.heroapp.repository.HeroRepository;

import java.util.List;

public class HeroViewModel extends AndroidViewModel {

    private HeroRepository heroRepository;

    private LiveData<List<HeroModel>> heroList;

    public HeroViewModel (Application application){

        super(application);

        heroRepository = new HeroRepository(application);
        heroList = heroRepository.getHeroList();


    }

    public void Insert(HeroModel hero){

        heroRepository.insert(hero);

    }


    public LiveData<List<HeroModel>> getHeroList() {
        return heroList;
    }

    public void setHeroList(LiveData<List<HeroModel>> heroList) {
        this.heroList = heroList;
    }
}
