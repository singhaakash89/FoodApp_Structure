package com.food_app.component.order.guestContracts;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public interface GuestMasterOrderContracts {

    boolean generateOrder();

    boolean showCategory();

    boolean selectVegNonVeg();

    boolean selectQuantity();

    boolean showMenuForSelectedCategory();

    boolean addToCart();

    boolean removeFromCart();

    boolean sendMessageToUser();

    boolean cancelOrder();

    boolean paymentMethodIdentification();

    boolean finishOrder();
}
