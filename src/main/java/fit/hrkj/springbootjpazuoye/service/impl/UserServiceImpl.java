package fit.hrkj.springbootjpazuoye.service.impl;

import fit.hrkj.springbootjpazuoye.dao.UserRepository;
import fit.hrkj.springbootjpazuoye.entity.User;
import fit.hrkj.springbootjpazuoye.service.UserService;
import fit.hrkj.utils.response.Message;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

import java.util.List;


/**
 * @author 格格不入
 * @Description 实现类：实现UserService内定义的方法
 * *
 * @Date 2023/4/27 0027 16:39
 * @Verson 1.0
 */

@Service //标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中
public class UserServiceImpl implements UserService {
    @Resource
    UserRepository userRepository;

    /**
     * 实现用户注册接口（需要传入用户账号和密码）*
     * @param user
     * @return
     */
    @Override
    public Message save(User user) {
        User data = userRepository.save(user);
        return Message.ok(data, "注册成功");
    }

    /**
     * * 实现用户登录接口（需要传入用户账号和密码)
     * @param account
     * @param password
     * @return
     */
    @Override
    public Message login(String account, String password) {
        //先查找是否有该用户
        List<User> data = userRepository.findUserByAccountAndPassword(account, password);
        //证明有获取到用户，可以登录
        if (data != null && data.size() > 0) {
            User user = data.get(0);
            return Message.ok(user, "登录成功");
        }
        return Message.error("此账号不存在或密码错误");
    }

    /**
     * 实现通过用户删除用户接口(需要传入用户id，用户账号,密码)*
     * @param user
     * @return
     */
    @Override
    @Modifying
    public Message deleteByUser(User user) {

        userRepository.delete(user);
        return Message.ok("删除成功");
    }

    /**
     * 实现通过用户账号查询该用户接口（需要传入用户账号）*
     * @param account
     * @return
     */
    @Override
    public Message findByAccount(String account) {
        List<User> data = userRepository.findByAccount(account);
        if(data != null){
            return Message.ok(data, "查询成功");
        }
        return Message.error("查询失败");

    }

    /**
     * 实现通过用户账户修改用户密码（需要传入用户账户和用户密码）*
     * @param account
     * @param password
     * @return
     */
    @Override
    public Message edit(String account, String password) {
        //先查找是否有该用户
        User data1 = userRepository.findUserByAccount(account);
        //获取到该用户
        if (data1 != null) {
            //修改该用户的密码
            data1.setPassword(password);
            //通过调用注册方法把更改过密码的用户重新保存
            User data = userRepository.save(data1);
            return Message.ok(data, "修改成功");
        }
        return Message.error("账号不存在");
    }
}
