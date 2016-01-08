package mej.jorge.com.tercodamisericordia.notUsed;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import mej.jorge.com.tercodamisericordia.notUsed.TercoFragment;

public class TercoFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 7;
    private String tabTitles[] = new String[] { "Início", "1º Mistério", "2º Mistério", "3º Mistério", "4º Mistério",
            "5º Mistério", "Final" };
    private Context context;

    public TercoFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return TercoFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
