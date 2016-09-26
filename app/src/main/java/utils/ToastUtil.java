package utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.widget.Toast;
import java.io.IOException;
import db.AssetsDBManager;
import db.DBReader;

/**
 * Created by pc on 2016/9/13.
 */
public class ToastUtil {
    private static Toast toast;
    public static void show(Context context, String text, int duration){
        if (toast==null) {
            toast = Toast.makeText(context, text, duration);
        }
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }

}
