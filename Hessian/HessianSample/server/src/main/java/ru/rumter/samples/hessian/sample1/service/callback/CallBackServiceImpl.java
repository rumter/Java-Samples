package ru.rumter.samples.hessian.sample1.service.callback;

import com.caucho.hessian.server.HessianServlet;
import ru.rumter.samples.hessian.sample1.api.callback.CallbackService;

public class CallBackServiceImpl extends HessianServlet implements CallbackService {

    @Override
    public void call(Runnable callback) {
        System.out.println("start callback");

        callback.run();

        System.out.println("complete callback.run");
    }

}
