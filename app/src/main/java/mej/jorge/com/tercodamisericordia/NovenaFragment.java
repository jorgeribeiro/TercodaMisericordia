package mej.jorge.com.tercodamisericordia;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mej.jorge.com.tercodamisericordia.Novena.*;

public class NovenaFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_novena, container, false);
        tabLayout = (TabLayout) view.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 : return new NovenaBeginFragment();
                case 1 : return new DayOneFragment();
                case 2 : return new DayTwoFragment();
                case 3 : return new DayThreeFragment();
                case 4 : return new DayFourFragment();
                case 5 : return new DayFiveFragment();
                case 6 : return new DaySixFragment();
                case 7 : return new DaySevenFragment();
                case 8 : return new DayEightFragment();
                case 9 : return new DayNineFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0 : return "Introdução";
                case 1 : return "Primeiro Dia";
                case 2 : return "Segundo Dia";
                case 3 : return "Terceiro Dia";
                case 4 : return "Quarto Dia";
                case 5 : return "Quinto Dia";
                case 6 : return "Sexto Dia";
                case 7 : return "Sétimo Dia";
                case 8 : return "Oitavo Dia";
                case 9 : return "Nono Dia";
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

    }

}
