package com.feicui.cn.jxh;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.TelclassAdapter;
import base.BaseActivity;
import db.DBReader;
import entity.TelclassInfo;


public class TelClassActivity extends BaseActivity {
    private static final String TAG ="TelClassActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_telmsg);
        /*if (!DBReader.isExistsTeldbFile()){
            AssetsDBManager assetsManager=new AssetsDBManager();
            String path=assetsManager.copyAssetsFileToSD(this);
            Log.d(TAG,"onCreat:"+path);
        }*/
        MyApplication application= (MyApplication) getApplication();
        final ArrayList<TelclassInfo> telClassInfos=DBReader.readTeldbClasslist(application.telFile);
        ListView listView= (ListView) findViewById(R.id.Listview);
        TelclassAdapter adapter=new TelclassAdapter(this);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(TelClassActivity.this,id+"=="+position,Toast.LENGTH_SHORT).show();
                Bundle bundle=new Bundle();
                bundle.putInt("idx",telClassInfos.get(position).getIdx());
                startActivityWithBundle(TelNumberActivity.class,bundle);
            }
        });

    }
}
