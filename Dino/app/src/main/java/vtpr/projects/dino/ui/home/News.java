package vtpr.projects.dino.ui.home;

public class News {
    private String text;
    Integer img, id;
    public News(){

    }

    public News( String text, Integer img, Integer id) {
        this.text = text;
        this.img = img;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
