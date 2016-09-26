package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicui.cn.jxh.LogoActivity;
import com.feicui.cn.jxh.R;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class ViewPagerFragment extends Fragment {
    private int resImg;


    public void initData(int resImg){
        this.resImg = resImg;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager,null);
        ImageView iv= (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(resImg);
        return view;
    }


}
