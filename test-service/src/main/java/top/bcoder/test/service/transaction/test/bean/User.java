package top.bcoder.test.service.transaction.test.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
    * id
    */
    private Integer id;

    /**
    * name
    */
    private String name;

    /**
    * password
    */
    private String password;

    /**
    * sex
    */
    private Integer sex;

    /**
    * des
    */
    private String des;

    public User() {
    }

}