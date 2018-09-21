package com.example.marwanjarada.masterdetail;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class ElectricanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrican);


        RecyclerView recyclerView = findViewById(R.id.rv_cooking);

        final ArrayList<Item> cookingItems = getElectronicItems();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);



        RecyclerAdapter adapter = new RecyclerAdapter(this, cookingItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = cookingItems.get(position).getTitle();
                for(int x = 0 ; x<cookingItems.size() ; x++){
                    if (cookingItems.get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(ElectricanActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);


    }


    public ArrayList<Item> getElectronicItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Video1"));
        categoryItems.add(new Item("video2"));
        categoryItems.add(new Item("video3"));
        categoryItems.add(new Item("video5"));
        categoryItems.add(new Item("video5"));
        categoryItems.add(new Item("video6"));

        return categoryItems;
    }

}