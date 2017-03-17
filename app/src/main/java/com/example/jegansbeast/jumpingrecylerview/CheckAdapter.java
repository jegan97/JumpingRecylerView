package com.example.jegansbeast.jumpingrecylerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerAdapter;
import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public class CheckAdapter extends RecyclerAdapter<Point,RecyclerHolder> {

    private String title;
    private List<Point> points;

    public CheckAdapter(String title) {
        this.title = title;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.point,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        holder.setPoint(points.get(position));
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==1)
            return 1;
        else
            return 0;
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

    public List<Point> getPoints() {
        return points;
    }
}
