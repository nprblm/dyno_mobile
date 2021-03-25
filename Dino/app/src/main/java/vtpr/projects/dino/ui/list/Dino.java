package vtpr.projects.dino.ui.list;

public class Dino {
    private String name;
    Integer eat, img;

    public Dino() {
    }

    public Dino(String name, Integer eat, Integer img) {
        this.name = name;
        this.eat = eat;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEat() {
        return eat;
    }

    public void setEat(Integer eat) {
        this.eat = eat;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
