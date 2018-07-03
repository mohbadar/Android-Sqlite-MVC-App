package ku.edu.af.classapplication.model;

public class Terminology {

    private Integer id;
    private String term;
    private String content;


    public Terminology( String term, String content) {
        this.term = term;
        this.content = content;
    }

    @Override
    public String toString() {
        return getTerm();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
