package com.example.jegansbeast.jumpingrecylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JEGAN'S BEAST on 3/12/2017.
 */

public class CheckAdapter2 extends RecyclerAdapter<Point,CheckHolder>{

    private String title;
    private List<Point> points;

    public CheckAdapter2(String title) {
        this.title = title;
    }

    @Override
    public CheckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.check,parent,false);
        return new CheckHolder(view);
    }

    @Override
    public void onBindViewHolder(CheckHolder holder, int position) {
        holder.setPoint(points.get(position));
    }

    @Override
    public int getItemCount() {
        return points==null?0:points.size();
    }

    @Override
    public void onItemDataRemoved(int pos) {
        points.remove(pos);
    }

    @Override
    public void onItemDataAdded(Point newdata) {
        if(points==null)
            points = new ArrayList<>();
        points.add(newdata);

    }

    @Override
    public Point getItemData(int pos) {
        return points.get(pos);
    }

    @Override
    public String getPageTitle() {
        return title;
    }


    void setPoints(List<Point> points) {
        this.points = points;
    }
}
