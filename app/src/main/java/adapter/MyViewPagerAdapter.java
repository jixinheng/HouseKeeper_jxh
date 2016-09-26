package adapter;


import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.Random;

import fragment.ViewPagerFragment;

/**
 * Created by Administrator on 2016/9/20 0020.
 */
public class MyViewPagerAdapter extends FragmentStatePagerAdapter{

    private int count;
    //int[] colors;
    int[] imgs;
    public void setImges(int[] imgs) {
        this.imgs=imgs;
       /*Random r=new Random();
        for (int i = 0; i <count ; i++) {
            colors[i]= Color.rgb(r.nextInt(256),r.nextInt(256),r.nextInt(256));
        }*/
    }
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        ViewPagerFragment fragment=new ViewPagerFragment();
        fragment.initData(imgs[position]);
        return fragment;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }


}
