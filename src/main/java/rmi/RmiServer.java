package rmi;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;

/**
 * @author labvi
 * @version 1.0.0
 */
public class RmiServer {
    public static void main(String[] args) throws IOException, AlreadyBoundException {
        UserServiceImpl userService = new UserServiceImpl();
        //绑定URL 标准格式为rmi://host:port/name
        Naming.bind("rmi://localhost:8080/UserService",userService);
        System.in.read(new byte[1024]);
    }
}
