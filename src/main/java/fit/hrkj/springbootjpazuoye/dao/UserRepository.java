package fit.hrkj.springbootjpazuoye.dao;

import fit.hrkj.springbootjpazuoye.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

/**
 * @author 格格不入
 * @Description 持久层：封装一些数据库的增删改查操作
 * @Date 2023/4/27 0027 16:36
 * @Verson 1.0
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 用户登录验证方法（需要传入用户账号和密码)*
     * @param account
     * @param password
     * @return
     */
    List<User> findUserByAccountAndPassword(String account, String password);

    /**
     * * 通过用户账号查询该用户方法（需要传入用户账号）
     * @param account
     * @return
     */
    List<User> findByAccount(String account);

    /**
     * * 通过用户账户修改用户密码方法（需要传入用户账户和用户密码）
     * @param account
     * @return
     */
    User findUserByAccount(String account);


}
