package com.gui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.gui.mapper.UserMapper;
import com.gui.pojo.User;
import com.gui.service.UserService;
import com.gui.util.RedisUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

	@Autowired
	private RedisUtil redis ;
	
    @Override
    public int addUser(User user) {

        return userMapper.insertSelective(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }

   
	public User selectByPrimaryKey(Integer id) {
		
		//redis.setValue("id", id+"");
		System.out.println("得到这个id对应的value值"+redis.getValue("id"));
		System.out.println("得到这个id对应的value值存在时间"+redis.getExpire("id"));
		System.out.println("查看是否存在这个key对应的值"+redis.hasKey("id"));
		//System.out.println("删除这个key的缓存:");
		//redis.delete("id");
		System.out.println("查看是否存在这个key对应的值"+redis.hasKey("id"));
		return userMapper.selectByPrimaryKey(id);
	}

}
