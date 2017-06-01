package com.example.lwl.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lwl.adapter.MyAdapter;
import com.example.lwl.bean.Person;
import com.example.lwl.notifaction.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lwl on 2017/5/24.
 */
public class Fragment1 extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private List<Person> personList;

    public static Fragment1 newInstance(String str){
        Fragment1 fragment1 = new Fragment1();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment1.setArguments(bundle);
        return fragment1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);
        initDate();
        return view;
    }

    private void initDate() {
        personList = new ArrayList<>();
        Person mPerson0= new Person("林黛玉");
        personList.add(mPerson0);
        Person mPerson1= new Person("薛宝钗");
        personList.add(mPerson1);
        Person mPerson2= new Person("贾元春");
        personList.add(mPerson2);
        Person mPerson3= new Person("贾迎春");
        personList.add(mPerson3);
        Person mPerson4= new Person("贾探春");
        personList.add(mPerson4);
        Person mPerson5= new Person("贾惜春");
        personList.add(mPerson5);
        Person mPerson6= new Person("史湘云");
        personList.add(mPerson6);
        Person mPerson7= new Person("王熙凤");
        personList.add(mPerson7);
        Person mPerson8= new Person("秦可卿");
        personList.add(mPerson8);
        Person mPerson9= new Person("贾宝玉");
        personList.add(mPerson9);

        myAdapter.setData(personList);
    }

    private void initView(View view) {
        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter();
        myAdapter.setmOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Snackbar.make(view,personList.get(position).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });

        myAdapter.setmOnItemLongClickListener(new MyAdapter.onItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, int position) {
                Snackbar.make(view,personList.get(position).getName(),Snackbar.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter);
    }


}
