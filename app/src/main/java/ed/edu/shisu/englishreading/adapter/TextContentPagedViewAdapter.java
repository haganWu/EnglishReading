package ed.edu.shisu.englishreading.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by haganwu on 16/8/22.
 */

public class TextContentPagedViewAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;

    public TextContentPagedViewAdapter(FragmentManager fm ) {
        super(fm);
    }
    public TextContentPagedViewAdapter(FragmentManager fm , List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size() == 0 ? 0 : fragments.size();
    }
}
