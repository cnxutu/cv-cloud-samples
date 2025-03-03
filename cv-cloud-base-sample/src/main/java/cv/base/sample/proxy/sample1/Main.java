package cv.base.sample.proxy.sample1;

/**
 * @author: xutu
 * @since: 2025/2/25 17:01
 */
public class Main {

    /**
     * 静态代理
     * @param args
     */
    public static void main(String[] args) {

        // 创建真实的业务对象
        UserServiceImpl userServiceImpl = new UserServiceImpl();

        // 创建代理对象
        UserServiceProxy userServiceProxy = new UserServiceProxy(userServiceImpl);

        // 通过代理类来调用方法
        userServiceProxy.addUser();

    }
}
