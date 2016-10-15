package ed.edu.shisu.englishreading.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ed.edu.shisu.englishreading.R;
import ed.edu.shisu.englishreading.adapter.TextContentPagedViewAdapter;
import ed.edu.shisu.englishreading.fragment.DlydFragment;
import ed.edu.shisu.englishreading.fragment.MymjFragment;
import ed.edu.shisu.englishreading.fragment.WzxsFragment;

/**
 * Created by haganwu on 16/8/22.
 */

public class TextContentActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private TextView tv_wzxs;
    private TextView tv_dlyd;
    private TextView tv_mymj;
    private TextView tv_text_title;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<Fragment>();
    private int textPosition;
    private WzxsFragment wzxsFragment;
    private DlydFragment dlydFragment;
    private MymjFragment mymjFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_text_content);
        initView();
//        textPosition = getIntent().getIntExtra("textPosition",0);
        String title = getIntent().getStringExtra("textTitle");
        Log.e("title",title);
        String[] split = title.split(" ");
        Log.e("title",split[1]);
        textPosition = Integer.parseInt(split[1]) - 1;
        initFragment();
        tv_text_title.setText(title);
        viewPager.setAdapter(new TextContentPagedViewAdapter(getSupportFragmentManager(),fragments));
        viewPager.setCurrentItem(0);
        tv_wzxs.setSelected(true);
        viewPager.setOnPageChangeListener(this);
        tv_dlyd.setOnClickListener(this);
        tv_wzxs.setOnClickListener(this);
        tv_mymj.setOnClickListener(this);
        findViewById(R.id.tv_title_back).setOnClickListener(this);
    }


    private void initView() {
        tv_wzxs = (TextView) findViewById(R.id.tv_wzxs);
        tv_dlyd = (TextView) findViewById(R.id.tv_dlyd);
        tv_mymj = (TextView) findViewById(R.id.tv_mymj);
        tv_text_title = (TextView) findViewById(R.id.tv_text_title);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    private void initFragment() {
        fragments.clear();
        if(wzxsFragment == null){
            wzxsFragment =  new WzxsFragment();
        }
        Bundle bundle1 = new Bundle();
        bundle1.putInt("toFragmentPosition", textPosition);
        wzxsFragment.setArguments(bundle1);
        if(dlydFragment == null){
            dlydFragment =  new DlydFragment();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("toFragmentPosition", textPosition);
        dlydFragment.setArguments(bundle2);
        if(mymjFragment == null){
            mymjFragment =  new MymjFragment();
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("toFragmentPosition", textPosition);
        mymjFragment.setArguments(bundle3);
        fragments.add(wzxsFragment);
        fragments.add(dlydFragment);
        fragments.add(mymjFragment);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        viewPager.setCurrentItem(position);
        setTextSelected(position);
    }

    private void setTextSelected(int position) {
        switch (position){
            case 0:
                tv_wzxs.setSelected(true);
                tv_dlyd.setSelected(false);
                tv_mymj.setSelected(false);
                break;
            case 1:
                tv_dlyd.setSelected(true);
                tv_wzxs.setSelected(false);
                tv_mymj.setSelected(false);
                wzxsFragment.stopReadSound();
                break;
            case 2:
                tv_mymj.setSelected(true);
                tv_dlyd.setSelected(false);
                tv_wzxs.setSelected(false);
                wzxsFragment.stopReadSound();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_title_back:
                Log.d("TAG","finish() finish()");
                TextContentActivity.this.finish();
                break;
            case R.id.tv_wzxs:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_dlyd:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_mymj:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
