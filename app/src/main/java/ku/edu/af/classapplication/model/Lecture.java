package ku.edu.af.classapplication.model;

public class Lecture {

    private Integer id;
    private String title;
    private String description;
    private Integer course_id;

    public Lecture(Integer id, String title, String description, Integer course_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.course_id = course_id;
    }

    public Lecture(String title, String description, Integer course_id) {
        this.title = title;
        this.description = description;
        this.course_id = course_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }
}
