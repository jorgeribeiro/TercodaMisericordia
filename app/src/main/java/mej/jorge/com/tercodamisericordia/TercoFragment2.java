package mej.jorge.com.tercodamisericordia;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TercoFragment2 extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String PREFS_NAME = "MyPrefsFile";
    private int mPage;

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 7;


    /**
    public static TercoFragment2 newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        TercoFragment2 fragment = new TercoFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View x = inflater.inflate(R.layout.activity_terco, null);
        tabLayout = (TabLayout) x.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        SharedPreferences settings = getActivity().getSharedPreferences(PREFS_NAME, 0);
        boolean dialogShown = settings.getBoolean("dialogShown", false);
        if (!dialogShown) {
           AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                   .setMessage("Para retornar ao Menu, pressione o botão Voltar do seu aparelho")
                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       public void onClick(DialogInterface dialog, int which) {
                           // Do something else
                       }
                   });
            AlertDialog alert = builder.create();
            alert.show();

            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("dialogShown", true);
            editor.apply();
        }

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
        public int getCount() {
            return int_items;
        }
    }


}
