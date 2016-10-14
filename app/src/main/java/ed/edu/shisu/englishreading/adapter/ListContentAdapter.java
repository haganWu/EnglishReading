package ed.edu.shisu.englishreading.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ed.edu.shisu.englishreading.R;


/**
 * Created by haganwu on 16/8/21.
 */

public class ListContentAdapter extends BaseAdapter {

    private List<String> datas;
    private Context context;


    public ListContentAdapter(Context context , List<String> datas){
        this.context = context;
        this.datas = datas;
    }
    @Override
    public int getCount() {
        return datas.size() == 0 ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null ){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
            viewHolder.item_text = (TextView) convertView.findViewById(R.id.item_text);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.item_text.setText(datas.get(position));
        return convertView;
    }


    class ViewHolder{
        TextView item_text;
    }

}
