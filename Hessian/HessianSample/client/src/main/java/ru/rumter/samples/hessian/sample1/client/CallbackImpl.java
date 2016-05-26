package ru.rumter.samples.hessian.sample1.client;

import java.io.Serializable;

public class CallbackImpl implements Runnable, Serializable {

    @Override
    public void run() {
        System.out.println("callback work");
    }

}
