package ru.zolotorevskii.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.zolotorevskii.task.dto.SegmentDto;
import ru.zolotorevskii.task.model.Parser;
import ru.zolotorevskii.task.model.IntervalParse;
import ru.zolotorevskii.task.service.DigitService;
import ru.zolotorevskii.task.service.LetterService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/intervals")
@AllArgsConstructor
public class Controller {
    LetterService letterService;
    DigitService digitService;

    @GetMapping(value = "/min", produces = APPLICATION_JSON_VALUE)
    public String getMin(@RequestParam("kind") String kind) {
        if(kind.equals("digits")){
            return Arrays.toString(Parser.parseListToArrayDigit(digitService.getMin()));
        } else if (kind.equals("letters")) {
            return Arrays.toString(Parser.parseListToArrayLetter(letterService.getMin()));
        }
        return "null";
    }

    @PostMapping("/merge")
    public void postInterval(@RequestParam("kind") String kind, @RequestBody String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();

        if(kind.equals("digits")){
            int[][] array;
            try {
                array = objectMapper.readValue(jsonStr, int[][].class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            List<SegmentDto> segments = null;
            try {
                segments = Parser.parseArrayToListDigit(array);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            IntervalParse.checkIntersections(segments);

            digitService.putAll(segments);
        } else if (kind.equals("letters")) {
            char[][] array;
            try {
                array = objectMapper.readValue(jsonStr, char[][].class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            List<SegmentDto> segments = null;
            try {
                segments = Parser.parseArrayToListLetter(array);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
            IntervalParse.checkIntersections(segments);

            letterService.putAll(segments);
        }
    }
}
