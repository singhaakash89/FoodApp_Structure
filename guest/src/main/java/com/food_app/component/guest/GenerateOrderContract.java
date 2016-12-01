package com.food_app.component.guest;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public interface GenerateOrderContract {

    boolean createOrder();

    boolean modifyOrder();

    boolean previewOrder();

    boolean finalizeOrder();

    boolean seeOrderStatus();

    boolean cancelOrder();

}
