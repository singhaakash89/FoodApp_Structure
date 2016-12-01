package com.food_app.component.oneui.toast;

import android.content.Context;
import android.widget.Toast;

import com.food_app.component.oneui.BaseActivity;

/**
 * Created by Aakash Singh on 31-10-2016.
 */

public class ToastManager {
    private static Context mContext = BaseActivity.getContext();

    public static void showToast_LONG(String msg1, String msg2) {
        Toast.makeText(mContext, msg1 + " " + msg2, Toast.LENGTH_LONG).show();
    }

    public static void showToast_SHORT(String msg1, String msg2) {
        Toast.makeText(mContext, msg1 + " " + msg2, Toast.LENGTH_SHORT).show();
    }

}
