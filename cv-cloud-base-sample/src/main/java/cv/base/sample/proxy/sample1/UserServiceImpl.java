package cv.base.sample.proxy.sample1;

/**
 * @author: xutu
 * @since: 2025/2/25 17:00
 */

public class UserServiceImpl implements UserService {
    @Override
    public void addUser() {
        System.out.println("Add a new user");
    }

}