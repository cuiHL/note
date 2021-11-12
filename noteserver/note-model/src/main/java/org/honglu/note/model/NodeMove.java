package org.honglu.note.model;

public class NodeMove {
    Integer id;
    Integer pId;
    Integer sort;

    public NodeMove(Integer id, Integer pId, Integer sort) {
        this.id = id;
        this.pId = pId;
        this.sort = sort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
