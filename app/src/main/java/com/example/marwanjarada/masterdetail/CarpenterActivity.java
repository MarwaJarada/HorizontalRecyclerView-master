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

public class CarpenterActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carpenter);





        RecyclerView recyclerView = findViewById(R.id.rv_carpenter);

        final ArrayList<Item> cookingItems = getCarpenterItems();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);


        RecyclerAdapter adapter = new RecyclerAdapter(this, cookingItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = cookingItems.get(position).getTitle();
                for(int x = 0 ; x<cookingItems.size() ; x++){
                    if (getCarpenterItems().get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(CarpenterActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);


    }


    public ArrayList<Item> getCarpenterItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Carpenter1"));
        categoryItems.add(new Item("Carpenter2"));
        categoryItems.add(new Item("Carpenter3"));
        categoryItems.add(new Item("Carpenter4"));
        categoryItems.add(new Item("Carpenter5"));
        categoryItems.add(new Item("Carpenter6"));

        return categoryItems;

    }
}
