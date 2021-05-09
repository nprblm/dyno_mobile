package vtpr.projects.dino.ui.list;

public class Dino {
    private String name, weight, period;
    Integer eat, img, id;

    public Dino() {
    }

    public Dino(String name, String weight, String period, Integer eat, Integer img, Integer id) {
        this.name = name;
        this.eat = eat;
        this.img = img;
        this.weight = weight;
        this.period = period;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
