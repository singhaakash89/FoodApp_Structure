package com.food_app.component.oneui.navDrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.food_app.component.oneui.R;
import com.food_app.component.oneui.toast.ToastManager;

import java.util.Collections;
import java.util.List;

/**
 * Created by Aakash Singh on 21-08-2015.
 */
public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private DrawerLayout drawerLayout;
    private List<RowData> rowDataList = Collections.emptyList();
    private RecyclerView drawerList;
    private Intent intent;
    private static DrawerLayout mDrawerLayout;

    public static void reIntializeDrawerLayout(DrawerLayout drawerLayout) {
        mDrawerLayout = drawerLayout;
    }

    public NavigationAdapter(Context context, List<RowData> rowDataList, RecyclerView drawerList, DrawerLayout drawerLayout) {
        Log.d("CHECK :: ", "INSIDE (NavigationAdapter CONSTRUCTOR)");
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.rowDataList = rowDataList;
        this.drawerList = drawerList;
        this.drawerLayout = drawerLayout;
    }

    @SuppressLint("LongLogTag")
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("CHECK :: ", "INSIDE (onCreateViewHolder)");
        View view = inflater.inflate(R.layout.nav_custom_row, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(context, view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.e("CHECK :: ", "INSIDE (onBindViewHolder)");
        //fecthing data from ArrayList into Bean of Text/Image type
        RowData currentData = rowDataList.get(position);
        //setting data from Bean into Holder
        holder.titleTextView.setText(currentData.getTitleId());
        holder.iconImageView.setImageResource(currentData.getIconId());
    }

    @Override
    public int getItemCount() {
        Log.e("CHECK :: ", "INSIDE (getItemCount)");
        return rowDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        ImageView iconImageView;

        public MyViewHolder(Context context, View itemView) {
            super(itemView);
            Log.e("CHECK :: ", "INSIDE (MyViewHolder constructor)");
            titleTextView = (TextView) itemView.findViewById(R.id.navCustomRowTextView);
            iconImageView = (ImageView) itemView.findViewById(R.id.navCustomRowImageView);
            //setting onItemClick Listener
            iconImageView.setOnClickListener(this);
            titleTextView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //closing drawer
            Log.d("drawerLayout : ", "" + mDrawerLayout);
            Log.d("drawerList : ", "" + drawerList);
            if (mDrawerLayout != null) {
                mDrawerLayout.closeDrawers();
            }

            Log.e("CHECK :: ", "INSIDE (onClick)");
            String onPressed = titleTextView.getText().toString();
            ToastManager.showToast_SHORT(onPressed, " is pressed");
            //switch for opening corresponding Fragment on Clicking NavDrawer
            switch (onPressed) {
                case DrawerMenuItem.BREAKFAST:
                    intent = new Intent("broadcast_HomePageIntentFilter");
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    break;

                case DrawerMenuItem.STARTER:
                    intent = new Intent("broadcast_ChatIntentFilter");
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                    break;

                case DrawerMenuItem.MAIN_COURSE:
//                    context.startActivity(new Intent(context, SettingsActivity.class));
                    break;

                case DrawerMenuItem.BEVERAGES:
                    break;

                case DrawerMenuItem.SWEETS:
                    break;

                default:
                    break;
            }
        }
    }
}
