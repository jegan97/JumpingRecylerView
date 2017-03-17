package com.example.jegansbeast.jumpingrecylerview.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.jegansbeast.jumpingrecylerview.Point;
import com.example.jegansbeast.jumpingrecylerview.R;

/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public class RecyclerHolder extends RecyclerView.ViewHolder {

    private Point point;
    private TextView x,y;

    public RecyclerHolder(View itemView) {
        super(itemView);
        x = (TextView) itemView.findViewById(R.id.x);
        y = (TextView) itemView.findViewById(R.id.y);
    }

    public void setPoint(Point point) {
        this.point = point;
        x.setText(String.valueOf(point.getX()));
        y.setText(String.valueOf(point.getY()));
    }
}
