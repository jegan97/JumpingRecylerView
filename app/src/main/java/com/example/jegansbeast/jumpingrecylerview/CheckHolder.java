package com.example.jegansbeast.jumpingrecylerview;

import android.view.View;
import android.widget.TextView;

import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerHolder;

/**
 * Created by JEGAN'S BEAST on 3/12/2017.
 */

public class CheckHolder extends RecyclerHolder {
    private Point point;
    private TextView x,y;
    public CheckHolder(View itemView) {
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
