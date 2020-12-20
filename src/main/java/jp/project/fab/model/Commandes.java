package jp.project.fab.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="COMMANDES")
public class Commandes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String ordre;
}
