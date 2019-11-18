package top.bcoder.test.service.transaction.test.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    /**
    * user_id
    */
    private Integer userId;

    /**
    * role_id
    */
    private Integer roleId;

    public UserRole() {
    }

}