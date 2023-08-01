package models;

import jakarta.persistence.*;

@Entity
@Table(name = "tutorials")
public class Tutorials {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name="publish")
    private Boolean publish;

    public Tutorials(){}

    public Tutorials(String title, String description, Boolean publish) {
        this.title = title;
        this.description = description;
        this.publish = publish;
    }

}
