package ru.rumter.samples.hessian.sample1.client;

import java.net.MalformedURLException;
import java.util.Arrays;

import com.caucho.hessian.client.HessianProxyFactory;
import ru.rumter.samples.hessian.sample1.api.callback.CallbackService;
import ru.rumter.samples.hessian.sample1.api.order.Order;
import ru.rumter.samples.hessian.sample1.api.order.OrderService;
import ru.rumter.samples.hessian.sample1.api.order.Status;

public class Client {

    static void testCalcService() throws MalformedURLException {
        String url = "http://localhost:8081/calc";
        HessianProxyFactory factory = new HessianProxyFactory();

        CalcService calcService = (CalcService) factory.create(CalcService.class, url);

        System.out.println("calcService: " + calcService);

        int sum = calcService.sum(1, 2);

        System.out.println("sum: " + sum);
    }

    static void testOrderService() throws MalformedURLException {
        String url = "http://localhost:8081/order";
        HessianProxyFactory factory = new HessianProxyFactory();

        OrderService orderService = (OrderService) factory.create(OrderService.class, url);

        System.out.println("orderService: " + orderService);

        Order order = new Order();
        order.setItems(Arrays.asList("1", "2", "3"));
        order.setComment("hello");
        order.setTotal(123.12);

        Status status = orderService.processOrder(order);

        System.out.println("status: " + status.getStatus());
    }

    static void testCallbackService() throws MalformedURLException {
        String url = "http://localhost:8081/callback";
        HessianProxyFactory factory = new HessianProxyFactory();

        CallbackService callbackService = (CallbackService) factory.create(CallbackService.class, url);

        System.out.println("callbackService: " + callbackService);

        /*
         * client: java.lang.IllegalArgumentException: argument type mismatch
         * server: java.lang.ClassNotFoundException: ru.rumter.samples.hessian.sample1.client.CallbackImpl
         */
        callbackService.call(new CallbackImpl());
    }

    public static void main(String[] args) throws MalformedURLException {
        System.out.println("start client");

        //testCalcService();
        testOrderService();
        //testCallbackService();
    }

}
