package com.food_app.component.superuser.analytics;

/**
 * Created by Aakash Singh on 24-10-2016.
 */
public interface OrderTracker {

    boolean orderCountInDay();

    boolean collectionInDay();

    boolean calculateCommissionInDay();

    boolean orderCountInWeek();

    boolean collectionInWeek();

    boolean calculateCommissionInWeek();

    boolean orderCountInMonth();

    boolean collectionInMonth();

    boolean calculateCommissionInMonth();
}
