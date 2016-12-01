package com.food_app.component.oneui.navDrawer;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.food_app.component.oneui.BaseActivity;
import com.food_app.component.oneui.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private ListView listView;
    //Nav Adapter reference
    private NavigationAdapter navigationAdapter;
    //Sahredpreference File
    public static final String PREF_FILE_NAME = "testpref";
    //Key for sharedPreferences
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private View containerView;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private ImageView fragmentImageForAppBar;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("CHECK :: ", "INSIDE (onCreate)");
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
        mContext = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e("CHECK :: ", "INSIDE (onCreateView)");
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        mDrawerLayout = (DrawerLayout) layout.findViewById(R.id.drawer_layout);
        navigationAdapter = new NavigationAdapter(getActivity(), getData(), recyclerView, mDrawerLayout);
        recyclerView.setAdapter(navigationAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public List<RowData> getData() {
        Log.e("CHECK :: ", "INSIDE (List<RowData> getData)");
        List<RowData> rowDataList = new ArrayList();
        int[] icons = {R.drawable.nav_icon, R.drawable.nav_icon, R.drawable.nav_icon, R.drawable.nav_icon, R.drawable.nav_icon};
        String[] titles = mContext.getResources().getStringArray(R.array.drawerListItem);
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            RowData rowData = new RowData();
            rowData.setIconId(icons[i]);
            rowData.setTitleId(titles[i]);
            rowDataList.add(rowData);
        }
        return rowDataList;
    }


    //------------Method setup()-------------
    public void setUp(int fragmentId, final DrawerLayout drawerLayout, final Toolbar toolbar, final ImageView fragmentImageForAppBar) {
        Log.e("CHECK :: ", "INSIDE (setUp)");
        containerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        this.fragmentImageForAppBar = fragmentImageForAppBar;

        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.e("CHECK :: ", "INSIDE (onDrawerOpened)");
                //Hiding appBar ImageView iconImageView when drawer is opened
                //fragmentImageForAppBar.setVisibility(ImageView.GONE);

                //Hiding appBar menu when drawer is opened
                //Making flag true to hide menu when drawer is opened
                BaseActivity.menuFlag = true;
                getActivity().invalidateOptionsMenu();

                //Sending drawer context to navAdapter for closing drawer
                NavigationAdapter.reIntializeDrawerLayout(drawerLayout);

                // =========================================

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.e("CHECK :: ", "INSIDE (onDrawerClosed)");
                //Showing appBar ImageView iconImageView when drawer is opened
                //fragmentImageForAppBar.setVisibility(ImageView.VISIBLE);
                //ReDrawing the options Menu
                BaseActivity.menuFlag = false;
                getActivity().invalidateOptionsMenu();
            }

//            //Uncomment this snippet to let toolbar fade-out when drawer comes-in
//            @Override
//            public void onDrawerSlide(View drawerView, float slideOffset) {
//                if (slideOffset < 0.4) {
//                    toolbar.setAlpha(1 - slideOffset);
//                }
//
//            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
                Log.e("CHECK :: ", "INSIDE (syncState)");
            }
        });
    }
    //----------------------------------------


    //Returning the reference for "mDrawerLayout"
    public DrawerLayout getmDrawerLayout() {
        Log.e("CHECK :: ", "INSIDE (getmDrawerLayout)");
        return mDrawerLayout;
    }
}


