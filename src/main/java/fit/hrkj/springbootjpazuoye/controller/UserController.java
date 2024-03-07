package fit.hrkj.springbootjpazuoye.controller;

import fit.hrkj.springbootjpazuoye.entity.User;
import fit.hrkj.springbootjpazuoye.service.UserService;
import fit.hrkj.utils.response.Message;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;

/**
 * @author 格格不入
 * @Description 控制器层：用来调用service类业务处理的方法实现业务
 * @Date 2023/4/27 0027 16:46
 * @Verson 1.0
 */

@RestController //提供json接口时需要的配置操作自动配置
@RequestMapping("/user") //用来标识 http 请求地址与 Controller 类的方法之间的映射
public class UserController {
    //将UserService实例化
    @Resource
    UserService userService;

    /**
     * /save：Post用户注册接口（需要传入用户账号和密码）*
     * @param user
     * @return message
     */
    @PostMapping("/save")
    public Message save(@RequestBody User user){
        return userService.save(user);
    }

    /**
     * * /login： Get用户登录接口（需要传入用户账号和密码)
     * @param account
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Message login(@RequestParam String account, String password){
        return userService.login(account,password);

    }

    /**
     * /deleteByUser： Delete通过用户删除用户接口(需要传入用户id，用户账号,密码)*
     * @param user
     * @return
     */
    @DeleteMapping("/deleteByUser")
    public Message deleteByUser(@RequestBody User user){
        return userService.deleteByUser(user);

    }

    /**
     * * /findByAccount: Get通过用户账号查询该用户接口（需要传入用户账号）
     * @param account
     * @return
     */
    @GetMapping("/findByAccount")
    public Message findByAccount(@RequestParam String account){
        return userService.findByAccount(account);

    }

    /**
     * * /edit：Put通过用户账户修改用户密码（需要传入用户账户和用户密码）
     * @param account
     * @param password
     * @return
     */
    @PutMapping("/edit")
    public Message edit(@RequestParam String account, String password){
        return userService.edit(account, password);

    }
}
