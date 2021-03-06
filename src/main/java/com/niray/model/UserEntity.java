package com.niray.model;

import net.sf.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Mac on 16/10/10.
 */
@Entity
@Table(name = "user", schema = "qq", catalog = "")
public class UserEntity implements Serializable {
    private int id;
    private String nickname;
    private String password;
    private Collection<BlogEntity> blogById;


    public void toJson() {
        JSONObject jo = new JSONObject();
        jo.put("id", id);
    }


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 255)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userById")
    public Collection<BlogEntity> getBlogById() {
        return blogById;
    }

    public void setBlogById(Collection<BlogEntity> blogById) {
        this.blogById = blogById;
    }
}
