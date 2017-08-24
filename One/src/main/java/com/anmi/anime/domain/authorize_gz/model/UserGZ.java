package com.anmi.anime.domain.authorize_gz.model;

import javax.persistence.*;

/**
 * Created by wangjue on 2017/8/24.
 */
@Entity
@Table(name = "gafis_authorize_UserGZ", schema = "authorize")
public class UserGZ {
    private String pkId;
    private String UserGZname;
    private String password;
    private String name;
    private Integer deltag;

    @Id
    @Column(name = "PK_ID")
    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    @Basic
    @Column(name = "UserGZNAME")
    public String getUserGZname() {
        return UserGZname;
    }

    public void setUserGZname(String UserGZname) {
        this.UserGZname = UserGZname;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "DELTAG")
    public Integer getDeltag() {
        return deltag;
    }

    public void setDeltag(Integer deltag) {
        this.deltag = deltag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserGZ that = (UserGZ) o;

        if (pkId != null ? !pkId.equals(that.pkId) : that.pkId != null) return false;
        if (UserGZname != null ? !UserGZname.equals(that.UserGZname) : that.UserGZname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (deltag != null ? !deltag.equals(that.deltag) : that.deltag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkId != null ? pkId.hashCode() : 0;
        result = 31 * result + (UserGZname != null ? UserGZname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (deltag != null ? deltag.hashCode() : 0);
        return result;
    }
}
