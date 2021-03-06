package ed.edu.shisu.englishreading.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import ed.edu.shisu.englishreading.R;
import ed.edu.shisu.englishreading.adapter.ListContentAdapter;

/**
 * Created by haganwu on 16/8/21.
 */

public class LevelContentActivity extends Activity {

    private TextView tv_level_content_title;
    private ListView lv_level_content;
    private List<String> datas = new ArrayList<String>();
    private List<String> toNextDatas = new ArrayList<String>();
    private TextView tv_title_back;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.level_content);
        String title = getIntent().getStringExtra("title");
        position = getIntent().getIntExtra("position",-1);
        initView();
        tv_level_content_title.setText(title);
        initData();
        lv_level_content.setAdapter(new ListContentAdapter(getApplicationContext(),datas));
        tv_title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LevelContentActivity.this.finish();
            }
        });

        lv_level_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LevelContentActivity.this,TextContentActivity.class);
                intent.putExtra("textTitle",toNextDatas.get(position));
                intent.putExtra("textPosition",position);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        int startCount = 0;
        int endCount = 0;
        if(position == 0){
            startCount = 1;
            endCount = 5;
        }else if(position == 1){
            startCount = 6;
            endCount = 15;
        }else if(position == 2){
            startCount = 16;
            endCount = 20;
        }
       String[] titles =  getResources().getStringArray(R.array.wzyd_title);
        for (int i = startCount; i <= endCount; i++) {
            datas.add("Text " + i + "    "+ titles[i-1]);
            toNextDatas.add("Text " + i);
        }
    }



    private void initView() {
        tv_level_content_title = (TextView) findViewById(R.id.tv_level_content_title);
        lv_level_content = (ListView) findViewById(R.id.lv_level_content);
        tv_title_back = (TextView) findViewById(R.id.tv_title_back);
    }


}
