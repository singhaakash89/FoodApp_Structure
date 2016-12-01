package com.food_app.component.order.adminContracts;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public interface AdminManageOrderContract {

    boolean approveOrder();

    boolean cancelOrder();

    boolean updateOrderStatus();

}
