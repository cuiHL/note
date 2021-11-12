package org.honglu.note.model;

public class NodeField {
    private Integer id;

    private String title;

    private Integer pId;

    private  Integer type;

    private Integer sort;

    private Integer user_id;

    private String create_user;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return  title;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
        return sort;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public String getCreate_user() {
        return create_user;
    }
}
