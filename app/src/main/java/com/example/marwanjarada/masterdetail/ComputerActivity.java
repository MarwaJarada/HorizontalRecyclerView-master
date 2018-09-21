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

public class ComputerActivity extends AppCompatActivity{
    ListFragment.ItemClickListener mCallBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        RecyclerView recyclerView = findViewById(R.id.rv_computer);
        final ArrayList<Item> computerItems = getCookingItems();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(this, computerItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = computerItems.get(position).getTitle();
                for(int x = 0 ; x<computerItems.size() ; x++){
                    if (computerItems.get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(ComputerActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);



    }



    public ArrayList<Item> getCookingItems() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("computer1"));
        items.add(new Item("computer2"));
        items.add(new Item("computer3"));
        items.add(new Item("computer4"));
        items.add(new Item("computer5"));
        items.add(new Item("computer6"));
        return items;
    }





    }

