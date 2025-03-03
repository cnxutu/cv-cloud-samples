package cv.base.sample.proxy.sample1;

/**
 * @author: xutu
 * @since: 2025/2/25 17:01
 */
public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;

    public UserServiceProxy(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void addUser() {
        System.out.println("Logging: About to add a user...");
        userService.addUser();  // 调用真实的业务方法
        System.out.println("Logging: User added successfully.");
    }
}
