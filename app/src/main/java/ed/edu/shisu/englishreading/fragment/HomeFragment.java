package ed.edu.shisu.englishreading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/21.
 */

public class HomeFragment extends Fragment {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fg_main,null);
        }
        return view;
    }
}
