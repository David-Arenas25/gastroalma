package com.restaurante.gastro.alma.domain;

public class Waiter {
    private int waiterId;
    private String waiterName;
    private String waiterLastName;


    public String getWaiterLastName() {
        return waiterLastName;
    }

    public void setWaiterLastName(String waiterLastName) {
        this.waiterLastName = waiterLastName;
    }

    public int getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(int waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

}
