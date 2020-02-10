package dubbo.client;

import dubbo.common.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author labvi
 * @version 1.0.0
 */
public class SimpleClient {
    public UserService buildRemoteService(String url){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("app-client");

        RegistryConfig registryConfig = new RegistryConfig(RegistryConfig.NO_AVAILABLE);

        //引用远程服务
        ReferenceConfig<UserService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(UserService.class);
        reference.setUrl(url);
        reference.setVersion("1.0.0");
        return reference.get();
    }

    public static void main(String[] args) throws IOException {
        SimpleClient simpleClient = new SimpleClient();
        //UserService userService = simpleClient.buildRemoteService("dubbo://127.0.0.1:12345/dubbo.common.UserService");
        //System.out.println(userService.getName("123"));

        //轮询调用
        List<UserService> services = new ArrayList<>();
        services.add(simpleClient.buildRemoteService("dubbo://127.0.0.1:20880/dubbo.common.UserService"));
        services.add(simpleClient.buildRemoteService("dubbo://127.0.0.1:20881/dubbo.common.UserService"));
        services.add(simpleClient.buildRemoteService("dubbo://127.0.0.1:20882/dubbo.common.UserService"));

        String cmd;
        int count = 0;
        while (!"quit".equals(cmd = read())){
            System.out.println(services.get(count++ % services.size()).getName(cmd));
        }
    }

    private static String read() throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(
                new InputStreamReader(System.in));
        return lineNumberReader.readLine();

    }
}