package cn.bdqn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ConfigClientRest
 * @Description TODO
 * @Date 2020/12/22 1:08
 * @Created by x1c
 */
@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
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
