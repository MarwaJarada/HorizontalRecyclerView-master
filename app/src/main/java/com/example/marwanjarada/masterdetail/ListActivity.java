package com.example.marwanjarada.masterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import static java.security.AccessController.getContext;

public class ListActivity extends AppCompatActivity implements com.example.marwanjarada.masterdetail.ListFragment.ItemClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acttivity_list);


    }

    @Override
    public void onItemClicked(Item item) {

    }


    public void loadFragment(Fragment fragment) {
        //
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin the transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // We can add,replace or remove the fragments from the container layout
        fragmentTransaction.replace(R.id.container_layout, fragment);

        // Complete the changes added above
        fragmentTransaction.commit();
    }




}
