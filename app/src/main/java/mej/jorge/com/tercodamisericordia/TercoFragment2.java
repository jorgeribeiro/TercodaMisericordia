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

public class TercoFragment2 extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.fragment_terco, null);
        tabLayout = (TabLayout) x.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return x;
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 : return new BeginFragment();
                case 1 : return new MysteryOneFragment();
                case 2 : return new MysteryTwoFragment();
                case 3 : return new MysteryThreeFragment();
                case 4 : return new MysteryFourFragment();
                case 5 : return new MysteryFiveFragment();
                case 6 : return new EndFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0 : return "Início";
                case 1 : return "1º Mistério";
                case 2 : return "2º Mistério";
                case 3 : return "3º Mistério";
                case 4 : return "4º Mistério";
                case 5 : return "5º Mistério";
                case 6 : return "Final";
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

    }

}
