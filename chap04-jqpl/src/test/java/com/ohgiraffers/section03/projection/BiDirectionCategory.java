package com.ohgiraffers.section03.projection;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "biBiDirection_category")
@Table(name = "tbl_category")
public class BiDirectionCategory {
    @Id
    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "ref_category_code")
    private Integer refCategoryCode;

    @OneToMany(mappedBy = "categoryCode")
    private List<BIDirectionMenu> menuList;

    public BiDirectionCategory() {
    }

    public BiDirectionCategory(int categoryCode, String categoryName, Integer refCategoryCode, List<BIDirectionMenu> menuList) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.menuList = menuList;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public List<BIDirectionMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<BIDirectionMenu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "BiDirectionCategory{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                '}';
    }
}
