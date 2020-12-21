package cn.bdqn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/11/30 16:01
 * @Created by x1c
 */

@RequestMapping("/order")
@RestController
public class OrderController {
    private static String REMOTE_URL = "http://cloud-provider-goods";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient; // ?

    @GetMapping("/downOrder/{bookId}")
    public String downOrder(@PathVariable Integer bookId){
        String result = restTemplate.getForObject(REMOTE_URL+"/book/getBooks/"+bookId,String.class);
        return result;
    }
}