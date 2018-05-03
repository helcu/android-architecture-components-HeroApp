package com.example.helmut.heroapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helmut.heroapp.R;
import com.example.helmut.heroapp.model.HeroModel;

import java.util.List;

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroViewHolder>{

    private List<HeroModel> heroList;

    public List<HeroModel> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<HeroModel> heroList) {
        this.heroList = heroList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        return new HeroViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        HeroModel hero = heroList.get(position);
        holder.id.setText(   String.valueOf(hero.getId()));
        holder.name.setText( hero.getName());

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView id;


        public HeroViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.nameHero);
             id = itemView.findViewById(R.id.idHero);


        }
    }
}
