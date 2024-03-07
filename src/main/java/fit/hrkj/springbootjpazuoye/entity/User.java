package fit.hrkj.springbootjpazuoye.entity;

import fit.hrkj.utils.jpa.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * @author 格格不入
 * @Description User实体类：连接数据库
 * @Date 2023/4/27 0027 16:29
 * @Verson 1.0
 */

@Data //自动生成get、set等方法
@Entity //实体类
public class User extends BaseEntity {
    /**
     * 用户名*
     */
    private String account;
    /**
     * 密码*
     */
    private String password;
}
