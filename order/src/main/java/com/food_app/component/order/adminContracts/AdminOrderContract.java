package com.food_app.component.order.adminContracts;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public interface AdminOrderContract {

    boolean managerOrder();

    boolean showBookedOrder();

    boolean showDeliveredOrder();

    boolean showCancelledOrder();

    boolean captureCanceledOrderReason();

    boolean showCancelledOrderReason();

}
