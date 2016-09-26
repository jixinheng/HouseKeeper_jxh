package util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class copyAssetFileToInterSD {
    private static final String TAG = "copyAssetFileToInterSD";

    public static String copyAssetFileToInterSD(Context context, String fromFile, String toFile) throws IOException {
        AssetManager manager=context.getAssets();
        InputStream inputStream=manager.open(fromFile);
        OutputStream outputStream=context.openFileOutput(toFile,context.MODE_PRIVATE);
        boolean isSuccess=copyData(inputStream,outputStream);
        if (isSuccess){
            Log.d(TAG, "copyAssetFileToInterSD: success");
            File file=new File(context.getFilesDir(),toFile);
            return file.getPath();
        }
        return null;
    }

    private static boolean copyData(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufi = null;
        BufferedOutputStream bufo = null;
        try {
            bufi=new BufferedInputStream(inputStream);

            bufo=new BufferedOutputStream(outputStream);
            byte[] buf=new byte[8*1024];
            int eof;
            while ((eof=bufi.read(buf))!=-1){
                bufo.write(buf,0,eof);
                bufo.flush();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufi!=null){
                bufi.close();
            }
            if (bufo!=null){
                bufo.close();
            }
        }
        return false;
    }
}
