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


/**
 * Created by pc on 2016/9/17.
 */
public class TellistAdapter extends BaseAdapter{
    @Override
    public int getCount() {
        return adapterDatas.size();
    }

    @Override
    public TelNumberInfo getItem(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public View getView(int position,View convertview,ViewGroup parent) {
        if (convertview==null){
            convertview=layoutInflater.inflate(R.layout.inflate_tellist_listitem,null);
        }
        TextView tv_name= (TextView) convertview.findViewById(R.id.tv_name);
        TextView tv_number= (TextView) convertview.findViewById(R.id.tv_number);
        tv_name.setText(getItem(position).name);
        tv_number.setText(getItem(position).number+"");
        return convertview;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    private ArrayList<TelNumberInfo> adapterDatas=new ArrayList<>();

    public void addDataToAdapter(TelNumberInfo e){
        if (e!=null){
            adapterDatas.add(e);
        }
    }
    public void addDataToADapter(List<TelNumberInfo> e){
        if (e!=null){
            adapterDatas.addAll(e);
        }
    }
    public void replaceDataTpAdapter(List<TelNumberInfo> e){
        if (e!=null){
            adapterDatas.clear();
            adapterDatas.addAll(e);
        }
    }
    public ArrayList<TelNumberInfo> getDataFromAdapter(){
        return adapterDatas;
    }
    private LayoutInflater layoutInflater;
    public TellistAdapter(Context context){
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
