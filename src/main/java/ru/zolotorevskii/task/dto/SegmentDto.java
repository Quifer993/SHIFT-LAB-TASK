package ru.zolotorevskii.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class SegmentDto<T extends Comparable<T>> {
    T start;
    T end;
}
