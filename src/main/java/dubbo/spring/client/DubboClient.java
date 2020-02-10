package dubbo.spring.client;

import dubbo.common.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @author labvi
 * @version 1.0.0
 */
public class DubboClient {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();
        UserService userService = context.getBean(UserService.class);
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
