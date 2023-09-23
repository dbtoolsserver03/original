package com.baizhiedu;

import com.baizhiedu.bean.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
/*@ComponentScan(basePackages = "com.baizhiedu.scan",
               excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Service.class}),
                                 @ComponentScan.Filter(type= FilterType.ASPECTJ,pattern = "*..User1")})*/
/*@ComponentScan(basePackages = "com.baizhiedu.scan",
               useDefaultFilters = false,
               includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value={Service.class})})*/
@ComponentScan(basePackages = "com.baizhiedu.scan")
@Import(User.class)
public class AppConfig2 {

}
