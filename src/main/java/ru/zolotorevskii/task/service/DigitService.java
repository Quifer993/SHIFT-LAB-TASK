package ru.zolotorevskii.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.zolotorevskii.task.dto.SegmentDto;
import ru.zolotorevskii.task.entity.DigitEntity;
import ru.zolotorevskii.task.mapper.DigitMapper;
import ru.zolotorevskii.task.repositories.DigitsRepository;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class DigitService implements IService<SegmentDto, Integer>{
    DigitMapper mapper;
    DigitsRepository digitsRepository;
    @Override
    public void putAll(List<SegmentDto> intervals) {
        List<DigitEntity> entities = new ArrayList<>();
        for (SegmentDto interval:
                intervals) {
            entities.add(mapper.toEntity(interval));
        }
        digitsRepository.saveAllAndFlush(entities);
    }

    @Override
    public SegmentDto getMin() {
        return mapper.toDto(digitsRepository.searchMin());
    }
}
