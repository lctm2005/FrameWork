package com.licong.repository.domain;


import javax.persistence.*;

/**
 * Created by lctm2005 on 2014/6/18.
 */
@Entity
public class GlobalConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemKey;
    private String itemValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String key) {
        this.itemKey = key;
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalConfig that = (GlobalConfig) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (itemKey != null ? !itemKey.equals(that.itemKey) : that.itemKey != null) return false;
        if (itemValue != null ? !itemValue.equals(that.itemValue) : that.itemValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (itemKey != null ? itemKey.hashCode() : 0);
        result = 31 * result + (itemValue != null ? itemValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GlobalConfig{" +
                "id=" + id +
                ", itemKey='" + itemKey + '\'' +
                ", itemValue='" + itemValue + '\'' +
                '}';
    }
}
