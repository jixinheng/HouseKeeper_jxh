package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.feicui.cn.jxh.R;

import java.util.ArrayList;
import java.util.List;

import entity.TelNumberInfo;
import entity.TelclassInfo;

/**
 * Created by pc on 2016/9/13.
 */
public class TelNumberAdapter extends BaseAdapter{
    private final ArrayList<TelNumberInfo> telNumberInfos;
    private LayoutInflater inflater;

    public TelNumberAdapter(Context context, ArrayList<TelNumberInfo> telClassInfos){
        this.telNumberInfos=telClassInfos;
        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount(){
        return telNumberInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return telNumberInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView (int position,View convertView,ViewGroup parent){
        if (convertView==null){
            convertView=inflater.inflate(R.layout.inflate_telmgr_listitem,null);
        }
        TextView tv_text= (TextView) convertView.findViewById(R.id.textview);
        tv_text.setText(telNumberInfos.get(position).getName());
        return convertView;
    }


    /*private ArrayList<TelclassInfo> TelNumberInfos =new ArrayList();
    public void addDataToAdapter(TelclassInfo e){
        if (e!=null){
            TelNumberInfos.add(e);
        }
    }
    public void addDataToAdapter(List<TelclassInfo> e){
        if (e!=null){
            TelNumberInfos.addAll(e);
        }
    }

    public ArrayList<TelclassInfo> getDataFromAdapter(){
        return TelNumberInfos;
    }
    public void clearDataToAdapter(){
        TelNumberInfos.clear();
    }
*/








}
