package rmi;

import rmi.common.UserService;

import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author labvi
 * @version 1.0.0
 */
public class RmiClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        String remoteAddr = "rmi://localhost:8080/UserService";
        //获取
        UserService userService = (UserService) Naming.lookup(remoteAddr);
        System.out.println(String.format("引用远程服务成功，当前主机:%s ", ManagementFactory.getRuntimeMXBean().getName()));
        String response = userService.getName(11);
        System.out.println("=======> " + response + " <=======");
    }
}
