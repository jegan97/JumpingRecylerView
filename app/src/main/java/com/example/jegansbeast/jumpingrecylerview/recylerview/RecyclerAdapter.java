package com.example.jegansbeast.jumpingrecylerview.recylerview;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JEGAN'S BEAST on 3/11/2017.
 */

public abstract class RecyclerAdapter<T,K extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<K> {

    private JumpingRecyclerView<T,K> jumpingRecyclerView;

    private List<T> dataList;

    public RecyclerAdapter(){
          dataList = new ArrayList<>();
    }

    @Override
    public abstract void onBindViewHolder(K holder, int position);

    @Override
    public int getItemCount(){
        return dataList.size();
    }

    public void onSwiped(int pos, int direction){
        jumpingRecyclerView.navigate(this,pos,direction);
    }

    void setJumpingRecyclerView(JumpingRecyclerView<T,K> jumpingRecyclerView) {
        this.jumpingRecyclerView = jumpingRecyclerView;
    }

    public abstract void onItemDataRemoved(int pos);

    public abstract void onItemDataAdded(T newdata);

    public abstract T getItemData(int pos);

    public abstract String getPageTitle();


    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
