package ed.edu.shisu.englishreading.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ed.edu.shisu.englishreading.adapter.ListContentAdapter;
import ed.edu.shisu.englishreading.R;
import ed.edu.shisu.englishreading.activity.LevelContentActivity;

/**
 * Created by haganwu on 16/8/21.
 */

public class LearnFragment extends Fragment {

    private View view;
    private ListView lv_learn;
    private List<String> datas = new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fg_learn,null);
        }
        lv_learn = (ListView) view.findViewById(R.id.lv_learn);
        initDatas();
        ListContentAdapter adapter = new ListContentAdapter(getContext(),datas);
        lv_learn.setAdapter(adapter);
        lv_learn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), LevelContentActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("title",datas.get(position));
                startActivity(intent);
            }
        });
        return view;
    }


    private void initDatas() {
        datas.clear();
        datas.add("U1 初级篇");
        datas.add("U2 中级篇");
        datas.add("U3 高级篇");
    }


}
