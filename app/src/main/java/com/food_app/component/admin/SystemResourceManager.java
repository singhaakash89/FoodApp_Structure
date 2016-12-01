package com.food_app.component.admin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Aakash Singh on 31-10-2016.
 */

public class SystemResourceManager extends AppCompatActivity {

    private static Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
    }

    /**
     * make sure onCreate() always invokes before this method
     * @return returning context of Application
     */
    public static Context getAdminContext() {
        return mContext;
    }
}
