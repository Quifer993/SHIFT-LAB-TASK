package ru.zolotorevskii.task.mapper;

import org.springframework.stereotype.Component;
import ru.zolotorevskii.task.dto.SegmentDto;
import ru.zolotorevskii.task.entity.DigitEntity;

@Component
public class DigitMapper implements IMapper<DigitEntity, SegmentDto<Integer>>{
    @Override
    public DigitEntity toEntity(SegmentDto<Integer> dto) {
        return new DigitEntity(dto.getStart(), dto.getEnd());
    }

    @Override
    public SegmentDto<Integer> toDto(DigitEntity entity) {
        return new SegmentDto<Integer>(entity.getStart(), entity.getEnd());
    }
}
