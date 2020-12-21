package cn.bdqn;

import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname TestLambda
 * @Description TODO
 * @Date 2020/12/14 10:03
 * @Created by x1c
 */

public class TestLambda {

    @Test
    void test1(){
        // java中遍历集合
        List<String> strList = Arrays.asList("张三", "李四", "王五");
        for (String str: strList ) {
            //System.out.println(str);
        }

        // JDK8新特性(lambda表达式)
        strList.forEach(s -> System.out.println(s));

        strList.forEach(s -> {System.out.println(s);System.out.println(s);System.out.println(s);});
    }

    // 内部类（静态内部类，非静态内部类，局部内部类，借助匿名内部类的写法）
    @Test
    void test2(){
        //局部内部类
        class Abc implements Runnable{

            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        }

        // 采用方式：静态内部类或非静态内部类或局部内部类
        //new Thread(new Abc()).start();
        //new Thread(new Abc()).start();

        // 采用方式：匿名内部类  new 对应接口的实现类或者父类
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱中国");
            }
        }).start();*/

        // 采用方式：函数式编程
        new Thread(() -> {
            for (int i =0 ; i<=10;i++){
                System.out.println("我爱中国");
            }
        }).start();
    }


    @Test
    void test3(){
        ZonedDateTime dateTime = ZonedDateTime.now();// 默认时区时间
        System.out.println(dateTime);// 2020-12-14T11:02:48.147+08:00[Asia/Shanghai]
    }
}
