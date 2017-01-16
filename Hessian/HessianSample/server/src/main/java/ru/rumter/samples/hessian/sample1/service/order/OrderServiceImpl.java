package ru.rumter.samples.hessian.sample1.service.order;

import com.caucho.hessian.server.HessianServlet;
import ru.rumter.samples.hessian.sample1.api.order.Order;
import ru.rumter.samples.hessian.sample1.api.order.OrderService;
import ru.rumter.samples.hessian.sample1.api.order.Status;

public class OrderServiceImpl extends HessianServlet implements OrderService {

    @Override
    public Status processOrder(Order order) {
        String statusMessage = String.format("total: %.2f, items.size: %d, comment: %s", order.getTotal(), order.getItems().size(), order.getComment());

        //Status status = new Status(statusMessage);

        ExtStatus status = new ExtStatus(statusMessage);
        status.setExtField("12345");

        return status;
    }

}
