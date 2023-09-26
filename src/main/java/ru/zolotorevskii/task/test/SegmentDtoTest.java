package ru.zolotorevskii.task.test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class SegmentDtoTest {
    public static void main(String[] args) {
        testInt();
        testChar();

    }
    private static void testInt(){
        int[][] arr = {{15, 22},
                {3, 8},
                {1, 4},
                {2, 14},
                {20, 40}};
//        int[][] arr = {{1, 3},
//                {1, 4},
//                {5, 8},
//                {4, 7},
//                {9, 10}};

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<int[][]> requestEntity = new HttpEntity<>(arr, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/v1/intervals/merge?kind=digits",
                HttpMethod.POST,
                requestEntity,
                String.class);
    }

    private static void testChar(){
        char[][] arr = { {'b', 'd'},
                {'j', 'z'},
                {'e', 'g'},
                {'f', 'g'},
                {'a', 'c'}
                };
//        char[][] arr = {{'j', 'z'},
//                {'f', 'g'},
//                {'e', 'g'},
//                {'a', 'c'},
//                {'b', 'd'}};

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<char[][]> requestEntity = new HttpEntity<>(arr, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/v1/intervals/merge?kind=letters",
                HttpMethod.POST,
                requestEntity,
                String.class);
    }

}