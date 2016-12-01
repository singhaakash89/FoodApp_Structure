package com.food_app.component.order.guestContracts;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public interface GuestPreviewOrderContact {

    boolean showItemWithPrice();

    boolean showTotalPrice();

    boolean showPaymentMethod();

    boolean showExpectedDelivery();

    boolean showOwnerContactInfo();
}
