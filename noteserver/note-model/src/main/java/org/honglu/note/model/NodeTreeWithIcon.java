package org.honglu.note.model;

public class NodeTreeWithIcon {
    private Integer id;

    private Integer pId;

    private String name;

    private Integer type;

    private String iconSkin;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }
}
