package ru.zolotorevskii.task.model;

import ru.zolotorevskii.task.dto.SegmentDto;

import java.util.List;

import static ru.zolotorevskii.task.Constants.DEBUG_WORK;

public class IntervalParse {
    public static <T extends Comparable<T>> void checkIntersections(List<SegmentDto> segments) {
        for (int i = 0; i < segments.size(); i++) {
            for (int j = 0; j < segments.size(); j++) {
                if (i == j) continue;
                var start = segments.get(i).getStart();
                if(start.compareTo(segments.get(j).getStart()) >= 0 &&
                        start.compareTo(segments.get(j).getEnd()) <= 0){
                    if(segments.get(i).getEnd().compareTo(segments.get(j).getEnd()) > 0){
                        segments.get(j).setEnd(segments.get(i).getEnd());
                    }
                    segments.remove(i);
                    i--;
                    break;
                }
            }
        }

        if(DEBUG_WORK){
            for (SegmentDto interval:
                    segments) {
                System.out.println(interval.getStart() + " " + interval.getEnd());
            }
            System.out.println("");
        }
    }
}
