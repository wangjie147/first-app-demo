package com.facetofront.Controller;


import com.facetofront.domain.User;
import com.facetofront.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

     //构造器方式进行注入
    ///////////////////////////////////////////////////////////
     private final  UserRepository userRepository;
     //userRepository这个是spring框架进行传递的，这里可以写@Autowired或者可以不写@Autowired
     @Autowired
     public UserController(UserRepository userRepository){
         this.userRepository = userRepository;
     }
     /////////////////////////////////////////////////////////

     @PostMapping("/person/save") //post请求参数传递到我们的服务端     404请求不合法
     public User save(@RequestParam("name") String name){
         User user = new User();
         user.setName(name);
         if(userRepository.save(user)){
              System.out.println("保存成功，用户对象："+user.getName()+"--"+user.getId());
         }
         return user;

     }

}
