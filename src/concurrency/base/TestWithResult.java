package concurrency.base;

import java.util.concurrent.Callable;

/**
 * @author WangYao
 * @date 2020/6/10
 * @function 带返回值
 */
public class TestWithResult implements Callable<String> {
    int id;

    public TestWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result" + id;
    }
}
