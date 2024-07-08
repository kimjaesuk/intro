package com.ohgiraffers.section03.projection;


import jakarta.persistence.*;

@Entity(name = "embedded_menu")
@Table(name = "tbl_menu")
public class EmbbedMenu {
    @Id
    @Column(name = "menu_code")
    private int menuCode;

    @Embedded
    private  MenuInfo menuInfo;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderavleStatus;

    public EmbbedMenu() {
    }

    public EmbbedMenu(int menuCode, MenuInfo menuInfo, int categoryCode, String orderavleStatus) {
        this.menuCode = menuCode;
        this.menuInfo = menuInfo;
        this.categoryCode = categoryCode;
        this.orderavleStatus = orderavleStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public MenuInfo getMenuInfo() {
        return menuInfo;
    }

    public void setMenuInfo(MenuInfo menuInfo) {
        this.menuInfo = menuInfo;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderavleStatus() {
        return orderavleStatus;
    }

    public void setOrderavleStatus(String orderavleStatus) {
        this.orderavleStatus = orderavleStatus;
    }

    @Override
    public String toString() {
        return "EmbbededMenu{" +
                "menuCode=" + menuCode +
                ", menuInfo=" + menuInfo +
                ", categoryCode=" + categoryCode +
                ", orderavleStatus='" + orderavleStatus + '\'' +
                '}';
    }
}
