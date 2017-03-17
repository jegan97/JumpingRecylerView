package com.example.jegansbeast.jumpingrecylerview;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.jegansbeast.jumpingrecylerview.recylerview.JumpingRecyclerView;
import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerHolder;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
            setTheme(R.style.KitKatTheme);
        }

        setContentView(R.layout.activity_main);
        FrameLayout layout = (FrameLayout) findViewById(R.id.frame);
        RelativeLayout root = (RelativeLayout) findViewById(R.id.root);

        JumpingRecyclerView<Point,RecyclerHolder> recylerView = new JumpingRecyclerView<>(this,getSupportFragmentManager());

        CheckAdapter adapter = new CheckAdapter("A");
        CheckAdapter adapter2 = new CheckAdapter("B");
        CheckAdapter adapter3 = new CheckAdapter("C");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Toolbar toolbar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.toolbar,root,false);
            toolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(toolbar);
            root.addView(toolbar,0);
        }


        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1,2));

        ArrayList<Point> points1 = new ArrayList<>();
        points1.add(new Point(4,6));

        ArrayList<Point> points2= new ArrayList<>();
        points2.add(new Point(20,45));

        adapter.setPoints(points);
        adapter2.setPoints(points1);
        adapter3.setPoints(points2);

        recylerView.addView(adapter);
        recylerView.addView(adapter2);
        recylerView.addView(adapter3);

        layout.addView(recylerView.render(layout),new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

    }
}
