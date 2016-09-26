package db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;

import entity.TelNumberInfo;
import entity.TelclassInfo;
import utils.LogUtil;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class DBReader {


    public static ArrayList<TelclassInfo> readTeldbClasslist(String telFile) {
        ArrayList<TelclassInfo> classListInfos=new ArrayList<TelclassInfo>();
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try{
            db=SQLiteDatabase.openOrCreateDatabase(telFile,null);
            cursor=db.rawQuery("select * from classlist",null);
            LogUtil.d("DBRead","read teldb classlist size:"+cursor.getCount());
            if (cursor.moveToFirst()){
                do {
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    int idx=cursor.getInt(cursor.getColumnIndex("idx"));
                    TelclassInfo classListInfo=new TelclassInfo(name,idx);
                    classListInfos.add(classListInfo);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            throw e;
        }
        finally {
            try {
                cursor.close();
                db.close();
            }catch (Exception e2){
                throw e2;
            }
            LogUtil.d("DBReader","read teldb classlist end [list size]:"+classListInfos.size());
        }
        return classListInfos;
    }

    public static ArrayList<TelNumberInfo> readTeldbTable(String telFile,int idx) {
        ArrayList<TelNumberInfo> numberInfos=new ArrayList<TelNumberInfo>();
        String sql="select * from table"+idx;
        SQLiteDatabase db=null;
        Cursor cursor=null;
        try {
            db=SQLiteDatabase.openOrCreateDatabase(telFile,null);
            cursor=db.rawQuery(sql,null);
            LogUtil.d("DBRead","read teldb number table size:"+cursor.getCount());
            if(cursor.moveToFirst()){
                do{
                    String name=cursor.getString(cursor.getColumnIndex("name"));
                    String number=cursor.getString(cursor.getColumnIndex("number"));
                    TelNumberInfo numberInfo=new TelNumberInfo(name,number);
                    numberInfos.add(numberInfo);
                }while (cursor.moveToNext());
            }
        }catch (Exception e){
            LogUtil.d("DBRead","read teldb classlist failed");
        }finally {
            try {
                cursor.close();
                db.close();
            }catch (Exception e2){
                throw e2;
            }

        }
        return numberInfos;
    }



}
