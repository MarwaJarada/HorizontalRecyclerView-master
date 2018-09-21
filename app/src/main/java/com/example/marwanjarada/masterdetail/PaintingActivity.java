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

public class PaintingActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_painting);


        RecyclerView recyclerView = findViewById(R.id.rv_painting);

        final ArrayList<Item> paintingItems = getPaintingItems();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);



        RecyclerAdapter adapter = new RecyclerAdapter(this, paintingItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = paintingItems.get(position).getTitle();
                for(int x = 0 ; x<paintingItems.size() ; x++){
                    if (paintingItems.get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(PaintingActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);
    }


    public ArrayList<Item> getPaintingItems(){
        ArrayList<Item> phoneItems = new ArrayList<>();
        phoneItems.add(new Item("painting1"));
        phoneItems.add(new Item("painting2"));
        phoneItems.add(new Item("painting3"));
        phoneItems.add(new Item("painting5"));
        phoneItems.add(new Item("painting6"));
        phoneItems.add(new Item("painting7"));

        return phoneItems;
    }
}

