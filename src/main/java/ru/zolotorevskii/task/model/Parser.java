package ru.zolotorevskii.task.model;

import ru.zolotorevskii.task.dto.SegmentDto;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<SegmentDto> parseArrayToListDigit(int[][] arr) {
        List<SegmentDto> segments = new ArrayList<>();
        for (int[] array : arr) {
            segments.add(new SegmentDto<>(array[0], array[1]));
        }
        return segments;
    }

    public static List<SegmentDto> parseArrayToListLetter(char[][] arr) {
        List<SegmentDto> segments = new ArrayList<>();
        for (char[] array : arr) {
            segments.add(new SegmentDto<>(Character.toString(array[0]), Character.toString(array[1])));
        }
        return segments;
    }

    public static int[] parseListToArrayDigit(SegmentDto<Integer> segment) {
        int[] newArr = new int[2];
        newArr[0] = segment.getStart();
        newArr[1] = segment.getEnd();
        return newArr;
    }
    public static char[] parseListToArrayLetter(SegmentDto<String> segment) {
        char[] newArr = new char[2];
        newArr[0] = segment.getStart().toCharArray()[0];
        newArr[1] = segment.getEnd().toCharArray()[0];
        return newArr;
    }
}