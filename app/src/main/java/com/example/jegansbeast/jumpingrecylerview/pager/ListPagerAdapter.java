package com.example.jegansbeast.jumpingrecylerview.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.jegansbeast.jumpingrecylerview.recylerview.RecyclerAdapter;

import java.util.List;

/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public class ListPagerAdapter<T,K extends RecyclerView.ViewHolder> extends FragmentStatePagerAdapter {

    private List<RecyclerAdapter<T,K>> adapters=null;

    public ListPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        RecyclerFragment<T,K> fragment = new RecyclerFragment<>();
        if(position==0){
            fragment.setSwipeDirections(ItemTouchHelper.RIGHT);
        }
        else if(position==adapters.size()-1){
            fragment.setSwipeDirections(ItemTouchHelper.LEFT);
        }
        else{
            fragment.setSwipeDirections(ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT);
        }

        fragment.setAdapter(adapters.get(position));

        return fragment;
    }

    @Override
    public int getCount() {
        return adapters==null?0:adapters.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return adapters.get(position).getPageTitle();
    }

    public void setAdapters(List<RecyclerAdapter<T,K>> adapters) {
        this.adapters = adapters;
    }
}
