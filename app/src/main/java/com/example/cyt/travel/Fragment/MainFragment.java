package com.example.cyt.travel.Fragment;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cyt.travel.R;
import com.example.cyt.travel.adapter.MainHeaderAdAdapter;
import com.example.cyt.travel.adapter.MainMenuAdapter;
import com.example.cyt.travel.util.DataUtil;

import java.util.Objects;

public class MainFragment extends Fragment {

    protected int[] icons = {R.drawable.header_pic_ad1, R.drawable.header_pic_ad2, R.drawable.header_pic_ad1};
    protected ViewPager mViewPagerHeaderad;

    protected int[] menuIcons = {R.drawable.menu_airport, R.drawable.menu_hatol, R.drawable.menu_trav,
            R.drawable.menu_nearby, R.drawable.menu_ticket, R.drawable.menu_car,
            R.drawable.menu_course, R.drawable.menu_trav};
    protected RecyclerView mRecyclerViewMenu;
    protected String[] menuNames;

    protected RecyclerView mRecyclerViewSecondMenu;
    protected int[] secondMenuIcons = {R.drawable.menu_second_ticket,R.drawable.menu_second_service,R.drawable.menu_second_airport};
    protected String[] secondMenuNames;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        secondMenuNames = view.getResources().getStringArray(R.array.second_menu);
        mRecyclerViewSecondMenu = view.findViewById(R.id.recyclerView_second_menu);
        menuNames = view.getResources().getStringArray(R.array.main_menu);
        mRecyclerViewMenu = view.findViewById(R.id.recyclerView_main_menu);
        mViewPagerHeaderad = view.findViewById(R.id.viewPage_main_header_ad);
        MainHeaderAdAdapter adapter = new MainHeaderAdAdapter(getActivity(), DataUtil.getHeaderAddInfo(getContext(), icons));
        mViewPagerHeaderad.setAdapter(adapter);

        //布局样式
        mRecyclerViewMenu.setLayoutManager(new GridLayoutManager(getActivity(),4));
        //菜单
        MainMenuAdapter mainMenuAdapter = new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(menuIcons,menuNames));
        mRecyclerViewMenu.setAdapter(mainMenuAdapter);

        mRecyclerViewSecondMenu.setLayoutManager(new GridLayoutManager(getActivity(),3));
        MainMenuAdapter secondMainMenuAdapter = new MainMenuAdapter(getActivity(),DataUtil.getMainMenus(secondMenuIcons,secondMenuNames));
        mRecyclerViewSecondMenu.setAdapter(secondMainMenuAdapter);
    }
}
