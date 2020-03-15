package tech.mycps.sces.domain;

import java.util.List;

public class Permission {

    private String id;
    private String permissionName;
    private String permissionId;
    private String parPermissionId;
    private List<Menu> menus;

    private List<Role> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getParPermissionId() {
        return parPermissionId;
    }

    public void setParPermissionId(String parPermissionId) {
        this.parPermissionId = parPermissionId;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id='" + id + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", permissionId='" + permissionId + '\'' +
                ", parPermissionId='" + parPermissionId + '\'' +
                ", menus=" + menus +
                ", roles=" + roles +
                '}';
    }
}
