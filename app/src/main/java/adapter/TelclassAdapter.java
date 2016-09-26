package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.feicui.cn.jxh.R;
import com.feicui.cn.jxh.TelmsgActivity;

import java.util.ArrayList;
import java.util.List;

import entity.TelclassInfo;

/**
 * Created by pc on 2016/9/13.
 */
public class TelclassAdapter extends BaseAdapter{
    private final Context context;
    //private final ArrayList<TelclassInfo> telClassInfos;
    private LayoutInflater layoutInflater;


    @Override
    public int getCount(){
        return adapterDatas.size();
    }

    @Override
    public TelclassInfo getItem(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }*/
    @Override
    public View getView (int position,View convertView,ViewGroup parent){
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.inflate_telmgr_listitem,null);
        }
        TextView tv_text= (TextView) convertView.findViewById(R.id.textview);
        tv_text.setText(getItem(position).name);
        return convertView;
    }


    private ArrayList<TelclassInfo> adapterDatas =new ArrayList<TelclassInfo>();
    public void addDataToAdapter(TelclassInfo e){
        if (e!=null){
            adapterDatas.add(e);
        }
    }
    public void addDataToAdapter(List<TelclassInfo> e){
        if (e!=null){
            adapterDatas.addAll(e);
        }
    }

    public ArrayList<TelclassInfo> getDataFromAdapter(){
        return adapterDatas;
    }
    public void clearDataToAdapter(){
        adapterDatas.clear();
    }


    public
    TelclassAdapter(Context context){
        this.context = context;
       // this.telClassInfos=telClassInfos;
        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }





    public TelclassInfo getITem(int position){
        return adapterDatas.get(position);
    }

}
