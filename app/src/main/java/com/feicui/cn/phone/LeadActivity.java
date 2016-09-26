package com.feicui.cn.phone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.feicui.cn.jxh.LogoActivity;
import com.feicui.cn.jxh.R;
import adapter.MyViewPagerAdapter;
import fragment.ViewPagerFragment;


public class LeadActivity extends AppCompatActivity {

    private TextView jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead);

        jump= (TextView) findViewById(R.id.jump);
        jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LeadActivity.this, LogoActivity.class);
                startActivity(intent);
                finish();
            }
        });


        final ImageView[] ivs = new ImageView[3];
        ivs[0] = (ImageView) findViewById(R.id.icon1);
        ivs[1] = (ImageView) findViewById(R.id.icon2);
        ivs[2] = (ImageView) findViewById(R.id.icon3);

        ViewPager viewPager = (ViewPager) findViewById(R.id.vp);
        //创建设配器
        final MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        //初始化页面数
        adapter.setImges(new int[]{
                R.drawable.adware_style_applist,
                R.drawable.adware_style_banner,
                R.drawable.adware_style_creditswall
        });
        //设配器绑定
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                                              @Override
                                              public void onPageSelected(int position) {
                                                  super.onPageSelected(position);
                                                  if (position==ivs.length-1){

                                                      jump.setVisibility(View.VISIBLE);
                                                  }

                                                  Toast.makeText(LeadActivity.this, "" + position, Toast.LENGTH_SHORT);
                                                  for (int i = 0; i < ivs.length ; i++) {
                                                      ivs[i].setBackgroundResource(R.drawable.indicator_unselected);
                                                  }
                                                  ivs[position].setBackgroundResource(R.drawable.indicator_selected);
                                              }
            /*private void showJump(int position) {
                ViewPagerFragment fragment= (ViewPagerFragment) adapter.getItem(position);
                fragment.showJump();
            }*/
          }
        );
    }
}
