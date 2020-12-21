package cn.bdqn.app;

import com.sun.org.apache.xml.internal.security.encryption.AgreementMethod;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Classname CloudConfig5001
 * @Description TODO
 * @Date 2020/12/21 16:13
 * @Created by x1c
 */
@SpringBootApplication(scanBasePackages = "cn.bdqn")
@EnableConfigServer // 开启配置中心服务端的功能
public class CloudConfig5001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfig5001.class, args);
    }
}
