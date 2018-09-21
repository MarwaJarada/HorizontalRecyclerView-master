package com.example.marwanjarada.masterdetail;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    ItemClickListener mCallBack;
    Context mContext;


    public ArrayList<Item> getCategoryItems(){
        ArrayList<Item> categoryItems = new ArrayList<>();
        categoryItems.add(new Item("Electrician"));
        categoryItems.add(new Item("Computer"));
        categoryItems.add(new Item("Phone"));
        categoryItems.add(new Item("Carpenter"));
        categoryItems.add(new Item("Plumbing"));
        categoryItems.add(new Item("Painting"));

        return  categoryItems;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_list,container,false);
        final RecyclerView listView = rootView.findViewById(R.id.listView_items);
        final ArrayList<Item> items = getCategoryItems();
        RecyclerView.LayoutManager layoutManager=
                new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        listView.setLayoutManager(layoutManager);

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        RecyclerAdapter adapter = new RecyclerAdapter(getContext(), items, new RecyclerAdapter.CustomItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                Intent intent;
                if(items.get(position).getTitle().equals("Electrician")){
                    Toast.makeText(getContext(),"Electrician",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),ElectricanActivity.class);
                    getContext().startActivity(intent);


                }

                else if(items.get(position).getTitle().equals("Computer")){
                    Toast.makeText(getContext(),"Computer",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),ComputerActivity.class);
                    getContext().startActivity(intent);

                }
                else if(items.get(position).getTitle().equals("Painting")){
                    Toast.makeText(getContext(),"Painting",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),PaintingActivity.class);
                    getContext().startActivity(intent);

                }
                else if(items.get(position).getTitle().equals("Phone")){
                    Toast.makeText(getContext(),"Phone",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),PhoneActivity.class);
                    getContext().startActivity(intent);

                }
                else if(items.get(position).getTitle().equals("Carpenter")){
                    Toast.makeText(getContext(),"Carpenter",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),CarpenterActivity.class);
                    getContext().startActivity(intent);

                }
                else if(items.get(position).getTitle().equals("Plumbing")){
                    Toast.makeText(getContext(),"Plumbing",Toast.LENGTH_LONG).show();
                    intent = new Intent(getContext(),PlumbingActivity.class);
                    getContext().startActivity(intent);

                }
            }
            });
        listView.setAdapter(adapter);



        return rootView;
    }



    public interface ItemClickListener{
        public void onItemClicked(Item item);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);


        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallBack = (ItemClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }

    }



}
