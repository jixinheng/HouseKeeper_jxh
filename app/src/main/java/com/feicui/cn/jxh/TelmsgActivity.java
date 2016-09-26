package com.feicui.cn.jxh;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

import adapter.TelclassAdapter;
import db.AssetsDBManager;
import db.DBReader;
import entity.TelclassInfo;
import utils.ToastUtil;


public class TelmsgActivity extends AppCompatActivity implements AdapterView.OnItemClickListener /*implements AdapterView.OnItemClickListener*/ {

    private TelclassAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telmsg);

        listView= (ListView) findViewById(R.id.Listview);
        adapter=new TelclassAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }





    /*public void initAppDBFile(){
        if (!DBReader.isExistsTeldbFile()){
            try {
                AssetsDBManager.copyAssetsFileToFile(getApplicationContext(),"db/commonnum.db", DBReader.telFile);
            }catch (IOException e){
                ToastUtil.show(this,"初始通讯大全数据库文件异常", Toast.LENGTH_SHORT);
            }
        }
    }*/


    /*@Override
    protected void onResume() {
        super.onResume();
        initAppDBFile();
        adapter.clearDataToAdapter();
        adapter.addDataToAdapter(new TelclassInfo("本地通话",0));
        try{
            adapter.addDataToAdapter(DBReader.readTeldbClasslist());
        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }*/




    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (position==0){
            Intent intent=new Intent();
            intent.setAction(Intent.ACTION_DIAL);
            startActivity(intent);
            return;
        }
        TelclassInfo classInfo=adapter.getItem(position);
        Intent intent=new Intent(this,TellistActivity.class);
        intent.putExtra("idx",classInfo.idx);
        startActivity(intent);

    }

}