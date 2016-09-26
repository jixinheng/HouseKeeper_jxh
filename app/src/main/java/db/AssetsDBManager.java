package db;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import utils.LogUtil;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class AssetsDBManager {
    private static final String TAG ="AssetsManager" ;

    public static void copyAssetsFileToFile(Context context, String path, File toFile) throws IOException{

        LogUtil.d("AssetsDBManager","copyAssetsFileToFile start");
        LogUtil.d("AssetsDBManager","file path:"+path);
        LogUtil.d("AssetsDBManager","file path:"+toFile.getAbsolutePath());
        InputStream inStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        try{
            inStream=context.getAssets().open(path);
            bufferedInputStream=new BufferedInputStream(inStream);
            bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(toFile,false));
            int len=0;
            byte [] buff=new byte[2*1024];
            while ((len=bufferedInputStream.read(buff))!=-1){
                bufferedOutputStream.write(buff,0,len);
            }
            bufferedOutputStream.flush();
        }catch (IOException e){
            throw e;
        }finally {
            bufferedInputStream.close();
            bufferedOutputStream.close();
            inStream.close();
            LogUtil.d("AssetsDBManager","copyAssetsFileToFile end");
        }

    }

    public String copyAssetsFileToSD(Context context) {
        AssetManager assetManager=context.getAssets();
        String path="db/commonnum.db";
        try{
            InputStream inputStream=assetManager.open(path);
            File filesDir=context.getFilesDir();
            File file=new File(filesDir,path);
            File parentDir=file.getParentFile();
            if (!parentDir.exists()) {
                parentDir.mkdirs();
            }
            FileOutputStream fileOutputStream=context.openFileOutput(file.getName(),Context.MODE_APPEND);
            BufferedOutputStream bufo=new BufferedOutputStream(fileOutputStream);
            BufferedInputStream bufi=new BufferedInputStream(inputStream);
            byte[] buf=new byte[1024];
            int eof=0;
            while ((eof=bufi.read(buf))!=-1){
                bufo.write(buf,0,eof);
                bufo.flush();
            }
            bufi.close();
            bufo.close();
            Log.d(TAG,"save data success");
            return file.getName();
        } catch (IOException e) {
            Log.d(TAG,path+"路径错误");
            e.printStackTrace();
        }
        return null;
    }
}
