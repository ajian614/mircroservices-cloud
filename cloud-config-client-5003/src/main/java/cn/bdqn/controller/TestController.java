package cn.bdqn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/12/23 10:13
 * @Created by x1c
 */

@RestController

/*
RefreshScope: 它会代理当前这个bean对象，当我们再次访问时，
它会产出一个新的对象，致使里面代码会重新获取一次配置，从而实现了刷新，但是
这个刷新，需要手工访问它暴露出来的接口，它才会生效，即产出新的代理bean对象.
*/
@RefreshScope
public class TestController {
    @Value("${spring.application.name}") // 从项目里面取到对应配置的值
    private  String applicationName;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        String str = "application: " + applicationName + "\t port: " + port;
        System.out.println("********str: " + str);
        return "application: " + applicationName + "\t port: " + port;
    }
}
