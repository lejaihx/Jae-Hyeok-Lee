package kr.ac.hufs.demo2.controller;

import kr.ac.hufs.demo2.dto.SearchDto;
import kr.ac.hufs.demo2.naver.dto.SearchLocalRes;
import kr.ac.hufs.demo2.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/local")
    public SearchLocalRes searchLocal(@RequestParam String query) {
        return searchService.searchLocal(query);
    }
}
