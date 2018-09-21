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

public class PhoneActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);





        RecyclerView recyclerView = findViewById(R.id.rv_phone);

        final ArrayList<Item> phoneItems = getPhoneItems();

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);



        RecyclerAdapter adapter = new RecyclerAdapter(this, phoneItems, new RecyclerAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String itemChoosed = phoneItems.get(position).getTitle();
                for(int x = 0 ; x<phoneItems.size() ; x++){
                    if (phoneItems.get(x).getTitle().equals(itemChoosed)){
                        Toast.makeText(PhoneActivity.this,itemChoosed,Toast.LENGTH_LONG).show();
                    }else {
                        continue;
                    }


                }
            }
        });
        recyclerView.setAdapter(adapter);
    }


    public ArrayList<Item> getPhoneItems(){
        ArrayList<Item> phoneItems = new ArrayList<>();
        phoneItems.add(new Item("phone1"));
        phoneItems.add(new Item("phone2"));
        phoneItems.add(new Item("phone3"));
        phoneItems.add(new Item("phone4"));
        phoneItems.add(new Item("phone5"));
        phoneItems.add(new Item("phone6"));

        return phoneItems;
    }
    }

