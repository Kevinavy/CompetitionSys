package com.kevinavy.competitionsys.model.vo;

import com.kevinavy.competitionsys.model.po.Role;

public class RoleVo {
    private Integer roleCode;
    private String role;

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleVo(Role role) {
        this.roleCode = role.getRoleCode();
        this.role = role.getRole();
    }

    public RoleVo() {
    }
}
