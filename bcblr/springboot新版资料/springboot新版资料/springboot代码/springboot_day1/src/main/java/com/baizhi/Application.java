package com.baizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration  //作用: 开启自动配置 初始化spring环境  springmvc环境
@ComponentScan //作用: 用来扫描相关注解 扫描范围 当前入口类所在包及子包
public class Application {

    public static void main(String[] args) {
        //springApplication spring应用类  作用:用来启动springboot应用
        //参数1:传入入口类 类对象   参数2:main函数的参数
        SpringApplication.run(Application.class,args);
    }

}

/**
 * @EnableAutoConfiguration: //作用: 开启自动配置 修饰范围:只能用在类上
 *      //实际作用: 根据pom.xml文件中依赖依赖自动判断 如在第一个环境之中引入了 spring-boot-starter-web
 *                 会自动根据引入的这个依赖构建相关环境 springmvc环境 web容器环境
 *
 * @ComponentScan:  //作用:用来开启注解扫描 修饰范围: 只能用在类上
 *                    扫描注解范围:  默认当前包以及当前包下的子包
 *
 * @RestController:  //作用:用来实例化当前对象为一个控制器对象,并将类上所有方法的返回值转为json,响应给浏览器 修饰范围:用在类上
 *    @Controller(实例化当前类为一个控制器) + @ResponseBody(用来将当前方法返回值转为json,响应给浏览器)
 *
 * @RequestMapping: //作用:用来加入访问路径  修饰范围: 类 (加入命名空间) 方法上(指定具体路径)
 *     @GetMapping: //作用:限定请求方式只能是GET,并指定路径 修饰范围: 方法上
 *     @PostMapping @DeleteMapping @PutMapping
 *
 * main 方法的作用:  //通过标准java入口方式委托给SpringApplication,并告知当前springboot主应用类是谁,从而启动springboot中tomcat 容器
 *     args作用:    可以在启动时指定外部参数
 *
 *
 * starers: 启动器
 *    springboot-starter-web Starters是一组方便的依赖关系描述符 
 *
 *
 */
