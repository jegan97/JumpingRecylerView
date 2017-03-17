package com.example.jegansbeast.jumpingrecylerview.recylerview;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jegansbeast.jumpingrecylerview.pager.ListPagerAdapter;
import com.example.jegansbeast.jumpingrecylerview.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public class JumpingRecyclerView<T,K extends RecyclerView.ViewHolder> {

    private List<RecyclerAdapter<T,K>> adapters;
    private Context context;
    private ViewPager pager;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;

    public JumpingRecyclerView(Context context, FragmentManager manager) {
        this.context = context;
        adapters = new ArrayList<>();
        fragmentManager = manager;
    }

    public void addView(RecyclerAdapter<T,K> adapter) {
        adapter.setJumpingRecyclerView(this);
        adapters.add(adapter);
    }

    public View render(ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.pager, parent, false);
        pager = (ViewPager) view.findViewById(R.id.pager);
        ListPagerAdapter<T, K> pagerAdapter = new ListPagerAdapter<>(fragmentManager);
        pagerAdapter.setAdapters(adapters);
        pager.setAdapter(pagerAdapter);

        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(pager);

        return view;
    }

    void navigate(RecyclerAdapter<T,K> adapter, int holderpos, int direction){
       int index  =  adapters.indexOf(adapter);

        int next = index;

        if(index==-1){
          return;
        }
        else if (index==0){

            if(direction== ItemTouchHelper.RIGHT && adapters.size()>1){
                moveRight(adapter,holderpos);
                next = index+1;
            }

        }
        else if (index==adapters.size()-1){
            if(direction== ItemTouchHelper.LEFT && adapters.size()>1){
                moveLeft(adapter,holderpos);
                next = index-1;
            }
        }
        else{
            if(direction== ItemTouchHelper.RIGHT){
                moveRight(adapter,holderpos);
                next = index+1;
            }
            else{
                moveLeft(adapter,holderpos);
                next = index-1;
            }
        }

        pager.setCurrentItem(next);
    }

    private void moveRight(RecyclerAdapter<T,K> adapter, int holderpos){
        int index = adapters.indexOf(adapter);
        T data = adapter.getItemData(holderpos);

        adapter.onItemDataRemoved(holderpos);
        RecyclerAdapter<T,K> nextadapter = adapters.get(index+1);
        nextadapter.onItemDataAdded(data);

        adapter.notifyItemRemoved(holderpos);
        nextadapter.notifyItemInserted(nextadapter.getItemCount()-1);

    }

    private void moveLeft(RecyclerAdapter<T,K> adapter, int holderpos){
        int index = adapters.indexOf(adapter);
        T data = adapter.getItemData(holderpos);

        adapter.onItemDataRemoved(holderpos);
        RecyclerAdapter<T,K> preadapter = adapters.get(index-1);
        preadapter.onItemDataAdded(data);

        adapter.notifyItemRemoved(holderpos);
        preadapter.notifyItemInserted(preadapter.getItemCount()-1);


    }

    public ViewPager getPager() {
        return pager;
    }

    public TabLayout getTabLayout() {
        return tabLayout;
    }

}
