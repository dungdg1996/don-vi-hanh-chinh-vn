package entity;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "DVHC")
public class DVHC {
    @XmlElement(name = "MaDVHC")
    private int id;
    @XmlElement(name = "Ten")
    private String name;
    @XmlElement(name = "CapTren")
    private int parentId = -1;
    @XmlElement(name = "Cap")
    private String level;

    public DVHC(int id, String name, int parentId, String level) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.level = level;
    }

    public DVHC() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", level='" + level + '\'' +
                '}';
    }
}
