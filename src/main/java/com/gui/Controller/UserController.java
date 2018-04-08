package com.gui.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gui.pojo.User;
import com.gui.service.UserService;

@RestController
public class UserController {

	 @Autowired
	    private UserService userService;

	 @Autowired
	 private StringRedisTemplate redis;
	    @ResponseBody
	    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
	    public int addUser(User user){
	    	System.out.println("00000000"+user.getPassword());
	        return userService.addUser(user);
	    }

	    @ResponseBody
	    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
	    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

	        return userService.findAllUser(pageNum,pageSize);
	    }
	    
	    @RequestMapping(value="/gui")
	    public User getUser() {
	    	System.out.println("99");
	    	User user = userService.selectByPrimaryKey(2);
	    	System.out.println(user.getUserName());
	    	return user;
	    }
	    @RequestMapping(value="/redisTest",method=RequestMethod.GET)
	    public String redisTest() {
	    	redis.opsForValue().set("aa", "bb");
	    	return redis.opsForValue().get("aa");
	    }
	    
	    
}
