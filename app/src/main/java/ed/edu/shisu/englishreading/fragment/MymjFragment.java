package ed.edu.shisu.englishreading.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/22.
 */

public class MymjFragment extends Fragment {

    private  View view;
    private ImageView iv_mymj;
    private TextView tv_mymj_english;
    private TextView tv_mymj_chinese;
    private int position;
    private  String[] contents;
    private List<Integer> pics = new ArrayList<Integer>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fg_mymj,null);
        }
        position = getArguments().getInt("toFragmentPosition");
        initView();
        initData();
       String content =  contents[position];
       String[] split = content.split("\\$");
        tv_mymj_english.setText(split[0]);
        tv_mymj_chinese.setText(split[1]);
        iv_mymj.setImageResource(pics.get(position));
        return view;
    }

    private void initData() {
        contents = getResources().getStringArray(R.array.mymj_content);
        pics.clear();
        pics.add(R.mipmap.pic1);
        pics.add(R.mipmap.pic2);
        pics.add(R.mipmap.pic3);
        pics.add(R.mipmap.pic4);
        pics.add(R.mipmap.pic5);
        pics.add(R.mipmap.pic6);
        pics.add(R.mipmap.pic7);
        pics.add(R.mipmap.pic8);
        pics.add(R.mipmap.pic9);
        pics.add(R.mipmap.pic10);
        pics.add(R.mipmap.pic11);
        pics.add(R.mipmap.pic12);
        pics.add(R.mipmap.pic13);
        pics.add(R.mipmap.pic14);
        pics.add(R.mipmap.pic15);
        pics.add(R.mipmap.pic16);
        pics.add(R.mipmap.pic17);
        pics.add(R.mipmap.pic18);
        pics.add(R.mipmap.pic19);
        pics.add(R.mipmap.pic20);
    }

    private void initView() {
        iv_mymj = (ImageView) view.findViewById(R.id.iv_mymj);
        tv_mymj_english = (TextView) view.findViewById(R.id.tv_mymj_english);
        tv_mymj_chinese = (TextView) view.findViewById(R.id.tv_mymj_chinese);
    }
}
