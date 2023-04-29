package com.example.mallelectron.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

/**
 * 
 * @TableName customer
 */
@TableName(value ="customer")
public class Customer implements Serializable {
    /**
     * 客户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 旺旺名称
     */
    private String nickname;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 姓名
     */
    private String name;

    /**
     * 地址信息
     */
    private String address;

    /**
     * 是否删除 0 否 1 是
     */
    @TableLogic
    private Boolean isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 客户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 客户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 旺旺名称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 旺旺名称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 地址信息
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址信息
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 是否删除 0 否 1 是
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 是否删除 0 否 1 是
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Customer other = (Customer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}