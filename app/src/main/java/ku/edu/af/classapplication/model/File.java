package ku.edu.af.classapplication.model;

public class File {

    private Integer id;
    private String title;
    private String file;
    private Integer lecture_id;

    public File(Integer id, String title, String file, Integer lecture_id) {
        this.id = id;
        this.title = title;
        this.file = file;
        this.lecture_id = lecture_id;
    }

    public File(String title, String file, Integer lecture_id) {
        this.title = title;
        this.file = file;
        this.lecture_id = lecture_id;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Integer lecture_id) {
        this.lecture_id = lecture_id;
    }
}
