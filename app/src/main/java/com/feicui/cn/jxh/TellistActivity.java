package com.feicui.cn.jxh;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import adapter.TellistAdapter;
import db.DBReader;

public class TellistActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private TellistAdapter adapter;
    int idx = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tellist);
        idx = getIntent().getIntExtra("idx", -1);

        listView = (ListView) findViewById(R.id.listview);
        listView.setOnItemClickListener(this);

        adapter = new TellistAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = adapter.getItem(position).name;
        String number = adapter.getItem(position).number;
        showCallDiaLog(name, number);

    }

    /*@Override
    protected void onResume() {
        super.onResume();
        try {
            adapter.addDataToADapter(DBReader.readTeldbTable(idx));

        } catch (Exception e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }*/

    private void showCallDiaLog(final String name, final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("是否开始拨打" + name + "电话？\n\nTEL:" + number);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("拨号", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://" + number));
                if (ActivityCompat.checkSelfPermission(TellistActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        builder.show();
    }
}
