package com.ele.pojo;

/**
 * 管理员
 */
public class Admin {

    /**
     * 管理员id
     */
    private Integer admin_id;

    /**
     * 管理员姓名
     */
    private String admin_name;

    /**
     * 管理员密码
     */
    private String password;

    @Override
    public String toString() {
        return "\uD83D\uDC68\u200D\uD83D\uDCBB管理员信息{" +
                "管理员编号：" + admin_id  +
                ", 管理员姓名：" + admin_name  +
                ", 管理员密码(已加密)：" + password  +
                '}';
    }

    public Admin(Integer admin_id, String admin_name, String password) {
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.password = password;
    }

    public Admin() {
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
