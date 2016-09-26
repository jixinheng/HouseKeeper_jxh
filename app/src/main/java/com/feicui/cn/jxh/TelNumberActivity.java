package com.feicui.cn.jxh;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.TelNumberAdapter;
import base.BaseActivity;
import db.DBReader;
import entity.TelNumberInfo;

public class TelNumberActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private ArrayList<TelNumberInfo> telNumberInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_number);
        listView = (ListView) findViewById(R.id.listview);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            int idx = (int) bundle.get("idx");
            asyncLoadData(idx);
            listView.setOnItemClickListener(this);
            //ArrayList<TelNumberInfo> telNumberInfos=DBReader.readTeldbTable(idx);
            //listView.setAdapter(new TelNumberAdapter(this,TelNumberInfo));
        }
    }

    private void asyncLoadData(final int idx) {
        final MyApplication application = (MyApplication) getApplication();
        new Thread() {
            @Override
            public void run() {
                super.run();
                telNumberInfos = DBReader.readTeldbTable(application.telFile, idx);
                listView.setAdapter(new TelNumberAdapter(TelNumberActivity.this, telNumberInfos));
            }
        }.start();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(TelNumberActivity.this, position + "", Toast.LENGTH_SHORT).show();
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        String num = telNumberInfos.get(position).getNumber();
        Uri data = Uri.parse("tel" + num);
        callIntent.setData(data);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{
                        Manifest.permission.CALL_PHONE
                },1);
            }else {
                Toast.makeText(TelNumberActivity.this, "请给我打电话权限------", Toast.LENGTH_SHORT).show();
            }
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else {
            Toast.makeText(TelNumberActivity.this, "我有打电话权限", Toast.LENGTH_SHORT).show();
        }
        startActivity(callIntent);
    }
}
