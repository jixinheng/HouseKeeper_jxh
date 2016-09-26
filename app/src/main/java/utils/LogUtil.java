package utils;

import android.util.Log;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class LogUtil {
    public static boolean isOpenDebug =true;
    public static boolean isOpenWarn=true;


    public static void d(String tag,String msg){
        if(isOpenDebug){
            Log.d(tag, msg);
        }
    }
    public static void w(String tag,String msg){
        if (isOpenWarn){
            Log.d(tag,msg);
        }
    }
}
