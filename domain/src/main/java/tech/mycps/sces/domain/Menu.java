package tech.mycps.sces.domain;

/**
 * 菜单实体类
 */
public class Menu {

    private String id;
    private String menuName;
    private String parMenu;
    private String menu_id;
    private String logo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParMenu() {
        return parMenu;
    }

    public void setParMenu(String parMenu) {
        this.parMenu = parMenu;
    }

    public String getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(String menu_id) {
        this.menu_id = menu_id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", parMenu='" + parMenu + '\'' +
                ", menu_id='" + menu_id + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
