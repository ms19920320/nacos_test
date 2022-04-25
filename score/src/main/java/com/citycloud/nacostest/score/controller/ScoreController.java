package com.citycloud.nacostest.score.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孟帅
 * @since 2022/4/25
 */
@RestController
@RequestMapping("/scoreController")
public class ScoreController {
    @GetMapping("/test")
    public String test() {
        return "score test";
    }
}
