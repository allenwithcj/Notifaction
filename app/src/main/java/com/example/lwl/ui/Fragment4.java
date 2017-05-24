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
public class Fragment4 extends Fragment{
    public static Fragment4 newInstance(String str){
        Fragment4 fragment4 = new Fragment4();
        Bundle bundle = new Bundle();
        bundle.putString("str",str);
        fragment4.setArguments(bundle);
        return fragment4;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        return view;
    }
}
