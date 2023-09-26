package ru.zolotorevskii.task.mapper;

import org.springframework.stereotype.Component;
import ru.zolotorevskii.task.dto.SegmentDto;
import ru.zolotorevskii.task.entity.LetterEntity;

@Component
public class LetterMapper implements IMapper<LetterEntity, SegmentDto<String>>{
    @Override
    public LetterEntity toEntity(SegmentDto<String> dto) {
        return new LetterEntity(dto.getStart(), dto.getEnd());
    }

    @Override
    public SegmentDto<String> toDto(LetterEntity entity) {
        return new SegmentDto<String>(entity.getStart(), entity.getEnd());
    }
}
