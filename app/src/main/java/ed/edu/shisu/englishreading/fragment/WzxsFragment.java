package ed.edu.shisu.englishreading.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/22.
 */

public class WzxsFragment extends Fragment implements MediaPlayer.OnCompletionListener{

    private View view;
    private int position;
    private String[] titles;
    private String[] authors;
    private String[] englishArticles;
    private String[] chineseTranslates;
    private TextView tv_wzyd_title,tv_author,tv_to_read,tv_english_article,tv_chinese_translate;
    private MediaPlayer mPlayer = null;
    private boolean toReading = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fg_wzxs, null);
        }
        position = getArguments().getInt("toFragmentPosition");
        Log.d("TAG","position:"+position);
        initData();
        initView();
        tv_wzyd_title.setText(titles[position]);
        String author = authors[position];
        if(!TextUtils.isEmpty(author)){
            tv_author.setVisibility(View.VISIBLE);
            tv_author.setText(authors[position]);
        }else{
            tv_author.setVisibility(View.GONE);
        }
        tv_english_article.setText(englishArticles[position]);
        tv_chinese_translate.setText(chineseTranslates[position]);
        tv_to_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","readData() readData()");
                Log.d("TAG","position:"+position);
                readData();
            }
        });
        return view;
    }

    private void readData() {
        toReading = !toReading;
        if(toReading){
            tv_to_read.setText("阅读");
        }else{
            tv_to_read.setText("停止");
        }
        int soundId = getSoundId();
        if(soundId!= -1){
            if(mPlayer == null){
                mPlayer = MediaPlayer.create(getContext(),soundId);
                mPlayer.setLooping(true);
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mPlayer.setVolume(0.5f, 0.5f);
            }
            if(!toReading){

                if(mPlayer != null){
                    mPlayer.stop();
                }

                try {
                    mPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("TAG","reading reading");
                mPlayer.start();
                mPlayer.setOnCompletionListener(this);

            }else{
                Log.d("TAG","stop() stop()");
                mPlayer.stop();
            }


        }

    }



    private void initView() {
        tv_wzyd_title = (TextView) view.findViewById(R.id.tv_wzyd_title);
        tv_author = (TextView) view.findViewById(R.id.tv_author);
        tv_to_read = (TextView) view.findViewById(R.id.tv_to_read);
        tv_english_article = (TextView) view.findViewById(R.id.tv_english_article);
        tv_chinese_translate = (TextView) view.findViewById(R.id.tv_chinese_translate);
        if(position == 6){
            tv_to_read.setVisibility(View.GONE);
        }else{
            tv_to_read.setVisibility(View.VISIBLE);
        }
    }

    private void initData() {

        titles = getResources().getStringArray(R.array.wzyd_title);
        authors = getResources().getStringArray(R.array.wzyd_anthor);
        englishArticles = getResources().getStringArray(R.array.wzyd_english_article);
        chineseTranslates = getResources().getStringArray(R.array.wzyd_chinese_translate);


    }

    private int getSoundId() {
        int soundId = -1;
        switch (position){
            case 0:
                soundId = R.raw.sound1;
                break;
            case 1:
                soundId = R.raw.sound2;
                break;
            case 2:
                soundId = R.raw.sound3;
                break;
            case 3:
                soundId = R.raw.sound4;
                break;
            case 4:
                soundId = R.raw.sound5;
                break;
            case 5:
                soundId = R.raw.sound6;
                break;
            case 6:
//                soundId = R.raw.sound7;
                break;
            case 7:
                soundId = R.raw.sound8;
                break;
            case 8:
                soundId = R.raw.sound9;
                break;
            case 9:
                soundId = R.raw.sound10;
                break;
            case 10:
                soundId = R.raw.sound11;
                break;
            case 11:
                soundId = R.raw.sound12;
                break;
            case 12:
                soundId = R.raw.sound13;
                break;
            case 13:
                soundId = R.raw.sound14;
                break;
            case 14:
                soundId = R.raw.sound15;
                break;
            case 15:
                soundId = R.raw.sound16;
                break;
            case 16:
                soundId = R.raw.sound17;
                break;
            case 17:
                soundId = R.raw.sound18;
                break;
            case 18:
                soundId = R.raw.sound19;
                break;
            case 19:
                soundId = R.raw.sound20;
                break;
        }
        return soundId;
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void stopReadSound(){
        if(mPlayer != null){
            mPlayer.stop();
            toReading = true;
            tv_to_read.setText("阅读");
        }
    }
}
