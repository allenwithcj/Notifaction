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
public class Fragment3 extends Fragment{
    public static Fragment3 newInstance(String str){
        Fragment3 fragment3 = new Fragment3();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment3.setArguments(bundle);
        return fragment3;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        return view;
    }
}
