package ed.edu.shisu.englishreading.fragment;

import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/22.
 */

public class WzxsFragment extends Fragment {

    private View view;
    private int position;
    private String[] problems;
    private String[] englishContents;
    private TextView tv_problem;
    private TextView tv_english_content;
    private TextView tv_to_read;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fg_wzxs, null);
        }
        position = getArguments().getInt("toFragmentPosition");
        initData();
        initView();
        tv_problem.setText(problems[position]);
        tv_english_content.setText(englishContents[position]);
        tv_to_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","readData() readData()");
                readData();
            }
        });
        return view;
    }

    private void readData() {

    }


    private void initView() {
        tv_problem = (TextView) view.findViewById(R.id.tv_problem);
        tv_english_content = (TextView) view.findViewById(R.id.tv_english_content);
        tv_to_read = (TextView) view.findViewById(R.id.tv_to_read);
    }

    private void initData() {

        problems = getResources().getStringArray(R.array.problem);
        englishContents = getResources().getStringArray(R.array.english_content);

    }



}
