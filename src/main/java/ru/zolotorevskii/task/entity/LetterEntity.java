package ru.zolotorevskii.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "letter_table")
public class LetterEntity extends AbstractEntity{
    @Column(name = "\"start\"", nullable = false, length = 1)
    private String start;

    @Column(name = "\"end\"", nullable = false, length = 1)
    private String end;

    public LetterEntity(String start, String end){
        this.start = start;
        this.end = end;
    }

    public LetterEntity() {

    }
}
