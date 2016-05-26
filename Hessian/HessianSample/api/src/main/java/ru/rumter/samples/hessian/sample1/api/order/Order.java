package ru.rumter.samples.hessian.sample1.api.order;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private List<String> items;
    private String comment;
    private double total;

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
