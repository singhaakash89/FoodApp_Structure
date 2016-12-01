package com.food_app.component.oneui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.food_app.component.oneui.navDrawer.NavigationDrawerFragment;

/**
 * Created by Aakash Singh on 25-10-2016.
 */
public class BaseActivity extends AppCompatActivity {

    private static Context mContext;
    public static boolean menuFlag = false;
    private Toolbar toolbar;
    private TextView fragmentNameForAppBar;
    private ImageView fragmentImageForAppBar;
    private LinearLayout fullLayout;
    private FrameLayout mainContentFrameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        setContentView(R.layout.menu_item_row);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


    public static Context getContext() {
        return mContext;
    }

    /**
     * @param layoutResID Provide id of layout you want to inflate
     */
    @Override
    public void setContentView(final int layoutResID) {

        // Your base layout goes here
        fullLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);

        // Main content layout frame goes here
        mainContentFrameLayout = (FrameLayout) fullLayout.findViewById(R.id.mainContentFrameLayout);

        // Setting the content of layout your provided to the act_content frame
        getLayoutInflater().inflate(layoutResID, mainContentFrameLayout, true);
        super.setContentView(fullLayout);

        // here you can get your drawer buttons and define how they
        // should behave and what must they do, so you won't be
        // needing to repeat it in every activity class

        //---------ToolBar Implementation-------------
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        //toolbar.setLogo(R.drawable.ic_logo);
        setSupportActionBar(toolbar);
        //--------------------------------------------

        //--------------Navigation Drawer Implementation------------------
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, fragmentImageForAppBar);
        //----------------------------------------------------------------

        //Appbar Reformatting requirment when new fragment slides in
        fragmentNameForAppBar = (TextView) findViewById(R.id.fragmentNameForAppBar);
        fragmentImageForAppBar = (ImageView) findViewById(R.id.fragmentImageForAppBar);
        fragmentNameForAppBar.setText("FoodApp");



    }

}
