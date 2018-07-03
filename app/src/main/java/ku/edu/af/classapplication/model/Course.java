package ku.edu.af.classapplication.model;

public class Course {

    private Integer id;
    private String title;
    private String description;
    private Integer year;



    public Course(Integer id, String title, String description, Integer year) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
    }

    public Course(String title, String description, Integer year) {
        this.title = title;
        this.description = description;
        this.year = year;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
