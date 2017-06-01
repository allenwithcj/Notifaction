package com.example.lwl.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.lwl.notifaction.R;
import com.example.lwl.bean.Person;

import java.util.List;

/**
 * Created by lwl on 2017/5/24.
 */
public class MyAdapter extends RecyclerView.Adapter{
    private List<Person> personList;


    public interface onItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface onItemLongClickListener{
        void onItemLongClick(View view,int position);
    }

    private onItemClickListener mOnItemClickListener;
    private onItemLongClickListener mOnItemLongClickListener;

    public void setmOnItemClickListener(onItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setmOnItemLongClickListener(onItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    public void setData(List<Person> personList) {
        this.personList = personList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MyViewHolder){
            ((MyViewHolder) holder).name.setText(personList.get(position).getName());
        }

    }

    @Override
    public int getItemCount() {
        return personList == null ? 0:personList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getLayoutPosition();
                    mOnItemClickListener.onItemClick(view,position);
                }
            });

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(view,position);
                    return true;
                }
            });
        }
    }


}
