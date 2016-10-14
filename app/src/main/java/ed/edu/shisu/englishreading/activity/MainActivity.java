package ed.edu.shisu.englishreading.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import ed.edu.shisu.englishreading.R;
import ed.edu.shisu.englishreading.domin.TabDb;

public class MainActivity extends FragmentActivity implements TabHost.OnTabChangeListener {
    private FragmentTabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        tabHost=(FragmentTabHost)super.findViewById(android.R.id.tabhost);
        tabHost.setup(this,super.getSupportFragmentManager()
                ,R.id.contentLayout);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.setOnTabChangedListener(this);
        initTab();

    }
    private void initTab(){
        String tabs[]= TabDb.getTabsTxt();
        for(int i=0;i<tabs.length;i++){
            TabHost.TabSpec tabSpec=tabHost.newTabSpec(tabs[i]).setIndicator(getTabView(i));
            tabHost.addTab(tabSpec,TabDb.getFragments()[i],null);
            tabHost.setTag(i);
        }
    }
    private View getTabView(int idx){
        View view= LayoutInflater.from(this).inflate(R.layout.footer_tabs,null);
        ((TextView)view.findViewById(R.id.tvTab)).setText(TabDb.getTabsTxt()[idx]);
        if(idx==0){
            ((TextView)view.findViewById(R.id.tvTab)).setTextColor(Color.RED);
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(TabDb.getTabsImgLight()[idx]);
        }else{
            ((ImageView)view.findViewById(R.id.ivImg)).setImageResource(TabDb.getTabsImg()[idx]);
        }
        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        // TODO Auto-generated method stub
        updateTab();
    }
    private void updateTab(){
        TabWidget tabw=tabHost.getTabWidget();
        for(int i=0;i<tabw.getChildCount();i++){
            View view=tabw.getChildAt(i);
            ImageView iv=(ImageView)view.findViewById(R.id.ivImg);
            if(i==tabHost.getCurrentTab()){
                ((TextView)view.findViewById(R.id.tvTab)).setTextColor(Color.RED);
                iv.setImageResource(TabDb.getTabsImgLight()[i]);
            }else{        ((TextView)view.findViewById(R.id.tvTab)).setTextColor(Color.GRAY);
                iv.setImageResource(TabDb.getTabsImg()[i]);
            }

        }
    }

}