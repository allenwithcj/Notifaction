package com.example.lwl.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lwl.notifaction.R;

/**
 * Created by lwl on 2017/5/24.
 */
public class Fragment2 extends Fragment{

    public static Fragment2 newInstance(String str){
        Fragment2 fragment2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment2.setArguments(bundle);
        return fragment2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }
}
