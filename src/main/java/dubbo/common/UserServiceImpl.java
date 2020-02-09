package dubbo.common;

/**
 * @author labvi
 * @version 1.0.0
 */
public class UserServiceImpl implements UserService {
    int port;
    @Override
    public String getName(String name) {
        return "my name is : "+name + " ,端口 : " + port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
