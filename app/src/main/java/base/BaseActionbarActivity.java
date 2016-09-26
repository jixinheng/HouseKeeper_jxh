package base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicui.cn.jxh.R;

import utils.LogUtil;

/**
 * Created by pc on 2016/9/18.
 */
public abstract class BaseActionbarActivity extends BaseActivity {
    public static final int Null_ID=-1;
    public void setActionBar(int resIdTitle,int resIdLeft,int resIdRight){
        try{
            TextView tv_action_title= (TextView) findViewById(R.id.tv_actionbar_title);
            ImageView iv_action_left= (ImageView) findViewById(R.id.iv_action_left);
            ImageView iv_action_right= (ImageView) findViewById(R.id.iv_action_right);
            if (resIdLeft!=Null_ID){
                iv_action_left.setImageResource(resIdLeft);
            }
            else{
                iv_action_left.setVisibility(View.INVISIBLE);
            }
            if (resIdRight!=Null_ID){
                iv_action_right.setImageResource(resIdRight);
            }
            else {
                iv_action_right.setVisibility(View.INVISIBLE);
            }
            if (resIdTitle!=Null_ID){
                tv_action_title.setText(resIdTitle);
            }
        }catch (Exception e){
            LogUtil.w("BaseActionbarActivity","ActionBar 有异常，是否当前页面没有include==> include_actionbar.xml布局？");
        }
    }
}
