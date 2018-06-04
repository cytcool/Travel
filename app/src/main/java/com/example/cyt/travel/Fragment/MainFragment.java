package com.example.cyt.travel.Fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cyt.travel.R;
import com.example.cyt.travel.adapter.MainHeaderAdAdapter;
import com.example.cyt.travel.util.DataUtil;

import java.util.Objects;

public class MainFragment extends Fragment {

    protected int [] icons = {R.drawable.header_pic_ad1,R.drawable.header_pic_ad2,R.drawable.header_pic_ad1};
    protected ViewPager mViewPagerHeaderad;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPagerHeaderad = view.findViewById(R.id.viewPage_main_header_ad);
        MainHeaderAdAdapter adapter = new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAddInfo(getContext(),icons));
        mViewPagerHeaderad.setAdapter(adapter);
    }
}
