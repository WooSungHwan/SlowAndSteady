package sas.study.blog.study;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@NoArgsConstructor(access = PROTECTED)
@Entity
@Table
public class Study {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;
    private String title;
    private String content;

    public static Study of(String title, String content) {
        Study study = new Study();
        study.title = title;
        study.content = content;
        return study;
    }

}