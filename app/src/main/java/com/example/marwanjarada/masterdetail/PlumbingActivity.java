package com.example.marwanjarada.masterdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class PlumbingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumbing);




        RecyclerView recyclerView = findViewById(R.id.rv_plumbing);

        final ArrayList<Item> plumbingItems = getPlumbingItems();


        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(this, plumbingItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = plumbingItems.get(position).getTitle();
                for(int x = 0 ; x<plumbingItems.size() ; x++){
                    if (plumbingItems.get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(PlumbingActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);


    }


    public ArrayList<Item> getPlumbingItems(){
        ArrayList<Item> plumbingItems = new ArrayList<>();
        plumbingItems.add(new Item("plumbing1"));
        plumbingItems.add(new Item("plumbing2"));
        plumbingItems.add(new Item("plumbing3"));
        plumbingItems.add(new Item("plumbing4"));
        plumbingItems.add(new Item("plumbing5"));
        plumbingItems.add(new Item("plumbing6"));

        return plumbingItems;
    }
}
