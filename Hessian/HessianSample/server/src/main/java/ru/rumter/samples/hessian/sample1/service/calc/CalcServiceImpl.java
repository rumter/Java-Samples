package ru.rumter.samples.hessian.sample1.service.calc;

import com.caucho.hessian.server.HessianServlet;

public class CalcServiceImpl extends HessianServlet implements CalcService {

    public int sum(int a, int b) {
        System.out.println("call sum with a:" + a + ", b:" + b);

        return a + b;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("call mul with a:" + a + ", b:" + b);

        return a * b;
    }

}
