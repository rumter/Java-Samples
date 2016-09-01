import com.caucho.hessian.client.HessianProxyFactory

@Grapes([
        @Grab(group = 'com.caucho', module = 'hessian', version = '4.0.38'),
        @Grab(group = 'ru.rumter.samples.hessian.sample1', module = 'api', version = '1.0-SNAPSHOT')
])


interface CalcService {

    int sum(int a, int b);

}


def url = 'http://localhost:8081/calc'

def hessianProxyFactory = new HessianProxyFactory()

CalcService service = hessianProxyFactory.create(CalcService, url)

println service
println 'sum: ' + service.sum(10, 20)