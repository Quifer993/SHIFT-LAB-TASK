package ru.zolotorevskii.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "digit_table")
public class DigitEntity extends AbstractEntity{
    @Column(name = "\"start\"", nullable = false)
    private Integer start;

    @Column(name = "\"end\"", nullable = false)
    private Integer end;

    public DigitEntity(Integer start, Integer end) {
        super();
        this.start = start;
        this.end = end;
    }

    public DigitEntity() {

    }
}
