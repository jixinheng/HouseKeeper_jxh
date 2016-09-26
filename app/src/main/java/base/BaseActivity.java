package base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

import utils.LogUtil;

/**
 * Created by pc on 2016/9/18.
 * 让以后写的Activity都继承当前类
 */
public abstract class BaseActivity extends AppCompatActivity{
    private static final String TAG ="" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG,getClass().getSimpleName()+"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG,getClass().getSimpleName()+"onResum()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG,getClass().getSimpleName()+"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG,getClass().getSimpleName()+"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (onlineActivityList.contains(this)){
            onlineActivityList.remove(this);
        }
        LogUtil.d(TAG,getClass().getSimpleName()+"onDestroy()");
    }

    private static ArrayList<BaseActivity> onlineActivityList=new ArrayList<BaseActivity>();
    public static void finishAll(){
        Iterator<BaseActivity> iterator=onlineActivityList.iterator();
        while (iterator.hasNext()){
            iterator.next().finish();
        }
    }
//clazz被跳转的界面
    public void startActivity(Class clazz){
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
    }

    public void startActivityWithBundle(Class clazz,Bundle bundle){
        Intent intent=new Intent(this,clazz);
        startActivity(intent);
    }
}
