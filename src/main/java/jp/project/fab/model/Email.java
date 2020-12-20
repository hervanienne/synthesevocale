package jp.project.fab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name="EMAIL")
public class Email {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String objet;
    private String message;
    private String destinataire;
    private Date date;
}
