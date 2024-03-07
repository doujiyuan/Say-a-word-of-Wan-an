package fit.hrkj.springbootjpazuoye.service;

import fit.hrkj.springbootjpazuoye.entity.User;
import fit.hrkj.utils.response.Message;


/**
 * @author 格格不入
 * @Description 服务层：业务模块的逻辑定义需要的方法，用实现类去实现这个接口里的方法
 * @Date 2023/4/27 0027 16:37
 * @Verson 1.0
 */

public interface UserService {
    /**
     * 用户注册*
     * @param user
     * @return
     */
    Message save(User user);

    /**
     * * 用户登录：验证账号密码
     * @param account
     * @param password
     * @return
     */
    Message login(String account,String password);

    /**
     * 跟据用户删除用户*
     * @param user
     * @return
     */
    Message deleteByUser(User user);

    /**
     * * 通过用户账号查询该用户
     * @param account
     * @return
     */
    Message findByAccount(String account);

    /**
     * * 通过用户账号修改用户密码
     * @param account
     * @param password
     * @return
     */
    Message edit(String account,String password);
}
