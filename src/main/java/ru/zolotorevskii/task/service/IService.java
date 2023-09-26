package ru.zolotorevskii.task.service;

import ru.zolotorevskii.task.dto.SegmentDto;

import java.util.List;

public interface IService<T, E extends Comparable<E>> {
    void putAll(List<T> intervals);
    SegmentDto<E> getMin();
}
