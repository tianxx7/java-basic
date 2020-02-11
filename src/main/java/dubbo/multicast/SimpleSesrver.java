package dubbo.multicast;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import dubbo.common.UserService;
import dubbo.common.UserServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * @author labvi
 * @version 1.0.0
 */
public class SimpleSesrver {
    public void openService(int port) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        //当前应用配置
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("app-server");

        //组网广播控制中心
        RegistryConfig registryConfig = new RegistryConfig("multicast://224.1.2.3:11111");

        //服务提供者协议配置
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(port);
        protocolConfig.setThreads(2);

        //服务提供者暴露服务配置
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");
        serviceConfig.export();

        List<URL> exportedUrls = serviceConfig.getExportedUrls();
        userService.setPort(exportedUrls.get(0).getPort());
        System.out.println("服务已开启 : " + exportedUrls.get(0).getPort());
    }

    public static void main(String[] args) throws IOException {
        SimpleSesrver simpleSesrver = new SimpleSesrver();
        //测试集群
        simpleSesrver.openService(-1);
        System.in.read();
    }
}
