package dubbo.redis.Server;

import dubbo.common.UserServiceImpl;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

/**
 * @author labvi
 * @version 1.0.0
 */
public class DubboServer {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("redis/provider.xml");
        context.start();
        ServiceConfig bean = context.getBean(ServiceConfig.class);
        List<URL> exportedUrls = bean.getExportedUrls();
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
        userService.setPort(exportedUrls.get(0).getPort());
        System.out.println();
        System.in.read();
    }
}
