package ed.edu.shisu.englishreading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/21.
 */

public class TestFragment extends Fragment implements View.OnClickListener {

    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fg_test,null);
        }
        initView();
        return view;
    }

    private void initView() {
        view.findViewById(R.id.tv_section_a).setOnClickListener(this);
        view.findViewById(R.id.tv_section_b).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),getResources().getString(R.string.please_hope2),Toast.LENGTH_SHORT).show();
    }
}
