package com.example.jegansbeast.jumpingrecylerview.pager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jegansbeast.jumpingrecylerview.R;
import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerAdapter;

/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public class RecyclerFragment<T,K extends RecyclerView.ViewHolder> extends Fragment {

    private int swipeDirections;
    private RecyclerAdapter<T,K> adapter;
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mainview = inflater.inflate(R.layout.listview,container,false);
        recyclerView = (RecyclerView) mainview.findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        Swiper swiper = new Swiper();
        ItemTouchHelper touchHelper = new ItemTouchHelper(swiper);
        touchHelper.attachToRecyclerView(recyclerView);
        return mainview;
    }

    public void setAdapter(RecyclerAdapter<T,K> adapter) {
        this.adapter = adapter;
    }


    private class Swiper extends ItemTouchHelper.SimpleCallback{

        Swiper() {
            super(ItemTouchHelper.DOWN, swipeDirections);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            adapter.onSwiped(viewHolder.getAdapterPosition(),direction);
        }
    }

    public void setSwipeDirections(int swipeDirections) {
        this.swipeDirections = swipeDirections;
    }
}
