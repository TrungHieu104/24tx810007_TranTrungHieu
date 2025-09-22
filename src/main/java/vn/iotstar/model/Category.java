package vn.iotstar.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Category implements Serializable {
	private int id;
    private String name;
    private String icon;
    private Boolean isActive;

    // Constructors
    public Category() {}

    public Category(String name, String icon, Boolean isActive) {
        this.name = name;
        this.icon = icon;
        this.isActive = isActive;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }
    
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    
    
    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", is_active='" + isActive + '\'' +
                '}';
    }
}
