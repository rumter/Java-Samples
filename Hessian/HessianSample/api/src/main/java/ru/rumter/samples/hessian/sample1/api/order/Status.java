package ru.rumter.samples.hessian.sample1.api.order;

import java.io.Serializable;

public class Status implements Serializable {

    private final String status;

    public Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        System.out.println("call getStatus");
        return status;
    }

}
