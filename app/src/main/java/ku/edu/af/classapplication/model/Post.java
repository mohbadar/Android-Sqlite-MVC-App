package ku.edu.af.classapplication.model;

public class Post {

    private Integer id;
    private  String title;
    private String content;
    private String file;
    private String type;

    public Post(Integer id, String title, String content, String file, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.file = file;
        this.type = type;
    }

    public Post(String title, String content, String file, String type) {
        this.title = title;
        this.content = content;
        this.file = file;
        this.type = type;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
