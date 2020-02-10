package dubbo.multicast;

import dubbo.common.UserService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author labvi
 * @version 1.0.0
 */
public class SimpleClient {
    public UserService buildRemoteService(String url){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("app-client");

        RegistryConfig registryConfig = new RegistryConfig("multicast://224.1.2.3:11111");

        //引用远程服务
        ReferenceConfig<UserService> reference = new ReferenceConfig<>();
        reference.setApplication(applicationConfig);
        reference.setRegistry(registryConfig);
        reference.setInterface(UserService.class);
        reference.setLoadbalance("roundrobin");//默认随机,设定为轮询的方式
        reference.setUrl(url);
        reference.setVersion("1.0.0");
        return reference.get();
    }

    public static void main(String[] args) throws IOException {
        SimpleClient simpleClient = new SimpleClient();
        UserService userService = simpleClient.buildRemoteService(null);
        String cmd;
        while (!"quit".equals(cmd = read())){
            System.out.println(userService.getName(cmd));
        }
    }

    private static String read() throws IOException {
        LineNumberReader lineNumberReader = new LineNumberReader(
                new InputStreamReader(System.in));
        return lineNumberReader.readLine();

    }
}