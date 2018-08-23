package com.facetofront.config;


import com.facetofront.domain.User;
import com.facetofront.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.util.Collection;

/**
 *路由器函数 配置
 *
 *
 */
@Configuration  //表示是一个配置对象，配置对象逐一取代java的配置文件
public class RouterFunctionConfiguration {

    /**
     *
     * 路由函数等于@PostMapping("/person/save")
     *
     * servlet      请求接口：servletRequest 或者 HttpServletRequest
     *              响应接口：servletResponse 或者 HttpServletResponse
     * spring 5.0重新定义了服务请求和响应接口：
     *
     * 请求接口：serverRequest
     * 响应接口：serverResponse
     * 即可支持servlet规范，也可以支持自定义，比如netty
     * 以本例：
     *    定义get请求，并且返回所有的用户对象， URI:/person/find/all
     *
     *注入的几种方式：
     *   方法注入，构造器注入，setget注入，字段注入，props注入
     *
     */
     @Bean
     @Autowired //方法参数进行注入
     public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){//userRepository依赖进来保证数据的来源
         Collection<User> users=userRepository.findAll();
         //RouterFunctions.route(RequestPredicates.GET("/person/find/all"));
         return null;
     }


}
