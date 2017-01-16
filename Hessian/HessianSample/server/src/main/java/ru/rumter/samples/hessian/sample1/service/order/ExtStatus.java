package ru.rumter.samples.hessian.sample1.service.order;

import ru.rumter.samples.hessian.sample1.api.order.Status;

public class ExtStatus extends Status {

    private String extField;

    public ExtStatus(String status) {
        super(status);
    }

    public String getExtField() {
        return extField;
    }

    public void setExtField(String extField) {
        this.extField = extField;
    }

}
