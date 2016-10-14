package ed.edu.shisu.englishreading.fragment;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import ed.edu.shisu.englishreading.R;

/**
 * Created by haganwu on 16/8/22.
 */

public class DlydFragment extends Fragment implements View.OnClickListener {

    private  View view;
    private TextView tv_dl_content;
    private TextView tv_ci_hui;
    private TextView tv_line_fan_yi;
    private  String[] contents;
    private  String[] ciHui;
    private  String[] fanYi;
    private int position;
    private PopupWindow popupWindow;
    private TextView tv_popup;
    private LinearLayout ll_view;
    private View popupView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view = inflater.inflate(R.layout.fg_dlyd,null);
        }
        position = getArguments().getInt("toFragmentPosition");
        initView();
        initData();
        tv_dl_content.setText(Html.fromHtml(contents[position]));
        initPopupWindow(inflater);
        return view;
    }

    private void initPopupWindow(LayoutInflater inflater) {
         popupView = inflater.inflate(R.layout.popu_view, null);
        // 创建PopupWindow对象
        popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, false);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popupWindow.setOutsideTouchable(true);
        tv_popup = (TextView) popupView.findViewById(R.id.tv_popu);
    }

    private void initData() {
        contents = getResources().getStringArray(R.array.dl_content);
        ciHui = getResources().getStringArray(R.array.ci_hui);
        fanYi = getResources().getStringArray(R.array.fan_yi);
    }

    private void initView() {
        tv_dl_content = (TextView) view.findViewById(R.id.tv_dl_content);
        tv_ci_hui = (TextView) view.findViewById(R.id.tv_ci_hui);
        tv_line_fan_yi = (TextView) view.findViewById(R.id.tv_line_fan_yi);
        tv_ci_hui.setOnClickListener(this);
        tv_line_fan_yi.setOnClickListener(this);
        ll_view = (LinearLayout) view.findViewById(R.id.ll_view);
    }

    private int getPhoneHeight(){
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);

//        int width = wm.getDefaultDisplay().getWidth();
        return  wm.getDefaultDisplay().getHeight();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_ci_hui:
                showPopupWindow(ciHui[position]);
                break;
            case R.id.tv_line_fan_yi:
                showPopupWindow(fanYi[position]);
                break;
        }
    }

    private void showPopupWindow(String content){
        if(popupWindow != null){
            tv_popup.setText(content);
            Log.e("height",getPhoneHeight()+","+popupView.getHeight()+","+ll_view.getHeight());
            popupWindow.showAtLocation(view, Gravity.CENTER,0,500);
        }
    }
}
