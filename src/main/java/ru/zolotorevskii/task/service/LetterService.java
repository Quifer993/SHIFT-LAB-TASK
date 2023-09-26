package ru.zolotorevskii.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zolotorevskii.task.dto.SegmentDto;
import ru.zolotorevskii.task.entity.LetterEntity;
import ru.zolotorevskii.task.mapper.LetterMapper;
import ru.zolotorevskii.task.repositories.LettersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class LetterService implements IService<SegmentDto, String>{
    LetterMapper mapper;
    LettersRepository lettersRepository;

    @Override
    public void putAll(List<SegmentDto> intervals) {
        List<LetterEntity> entities = new ArrayList<>();
        for (SegmentDto interval:
                intervals) {
            entities.add(mapper.toEntity(interval));
        }
        lettersRepository.saveAllAndFlush(entities);
    }

    @Override
    public SegmentDto<String> getMin() {
        return mapper.toDto(lettersRepository.searchMin());
    }
}
