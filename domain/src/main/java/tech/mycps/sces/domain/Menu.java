package tech.mycps.sces.domain;

/**
 * 菜单实体类
 */
public class Menu {

    private String id;
    private String menuName;
    private String parMenu;
    private String url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
                ", url='" + url + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
