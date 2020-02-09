package rmi;

import rmi.common.UserService;

import java.lang.management.ManagementFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author labvi
 * @version 1.0.0
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    protected UserServiceImpl() throws RemoteException {
    }
    @Override
    public String getName(Integer id) throws RemoteException {
        return String.format("myName is :%s", ManagementFactory.getRuntimeMXBean().getName());
    }
}
