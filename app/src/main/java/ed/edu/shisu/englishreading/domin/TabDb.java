package ed.edu.shisu.englishreading.domin;

import ed.edu.shisu.englishreading.R;
import ed.edu.shisu.englishreading.fragment.LearnFragment;
import ed.edu.shisu.englishreading.fragment.HomeFragment;
import ed.edu.shisu.englishreading.fragment.TestFragment;
import ed.edu.shisu.englishreading.fragment.UserCenterFragment;

/**
 * Created by haganwu on 16/8/21.
 */

public class TabDb {

    public static String[] getTabsTxt(){
        String[] tabs={"首页","学习","测试","个人中心"};
        return tabs;
    }
    public static int[] getTabsImg(){
        int[] ids={R.mipmap.main_tab_item_home_normal,R.mipmap.main_tab_item_setting_normal,R.mipmap.main_tab_item_category_normal,R.mipmap.main_tab_item_user_normal};
        return ids;
    }
    public static int[] getTabsImgLight(){
        int[] ids={R.mipmap.main_tab_item_home_focus,R.mipmap.main_tab_item_setting_focus,R.mipmap.main_tab_item_category_focus,R.mipmap.main_tab_item_user_focus};
        return ids;
    }
    public static Class[] getFragments(){
        Class[] clz={HomeFragment.class,LearnFragment.class,TestFragment.class,UserCenterFragment.class};
        return clz;
    }
}
