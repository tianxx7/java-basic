package rmi;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author labvi
 * @version 1.0.0
 */
public class RmiRegister {
    public static void main(String[] args) throws IOException {
        //本地主机上的远程对象注册表
        LocateRegistry.createRegistry(8080);
        System.out.println("======= 注册中心启动成功! =======");
        System.in.read(new byte[1024]);
    }
}
