package base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19 0019.
 */
public abstract class BaseDataAdapter<E> extends BaseAdapter {
    protected Context context;
    protected LayoutInflater layoutInflate;
    private ArrayList<E> adapterDatas=new ArrayList<E>();
    public BaseDataAdapter(Context context){
        this.context=context;
        layoutInflate= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return adapterDatas.size();
    }


    public E getItemView(int position) {
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public ArrayList<E> getDataFromAdapter(){
        return adapterDatas;
    }
    public void setDataFromAdapter(List<E> e){
        adapterDatas.clear();
        if (e!=null){
            adapterDatas.addAll(e);
        }
    }
    public void addDataToAdapter(E e){
        if (e!=null){
            adapterDatas.add(e);
        }
    }
    public void addDataTpAdapter(List<E> e){
        if (e!=null){
            adapterDatas.addAll(e);
        }
    }
    public void clearAdapter(){
        adapterDatas.clear();
    }
    public void removeDataFromAdapter(E e){
        adapterDatas.remove(e);
    }
}
