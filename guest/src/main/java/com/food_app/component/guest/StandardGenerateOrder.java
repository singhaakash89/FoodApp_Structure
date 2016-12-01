package com.food_app.component.guest;

/**
 * Created by Aakash Singh on 23-10-2016.
 */
public class StandardGenerateOrder implements GenerateOrderContract{
    @Override
    public boolean createOrder() {
        return false;
    }

    @Override
    public boolean modifyOrder() {
        return false;
    }

    @Override
    public boolean previewOrder() {
        return false;
    }

    @Override
    public boolean finalizeOrder() {
        return false;
    }

    @Override
    public boolean seeOrderStatus() {
        return false;
    }

    @Override
    public boolean cancelOrder() {
        return false;
    }
}
