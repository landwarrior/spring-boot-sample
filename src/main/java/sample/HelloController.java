package sample;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController アノテーションがついているので thymeleaf は使わない
 * 返している文字列がそのまま http のボディに入るんじゃないかな
 */
@RestController
public class HelloController {

    /**
     * コンテキストパスそのまま
     */
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    /**
     * コンテキストパスでパラメータを受け付ける書き方
     */
    @GetMapping("/hello/{num}")
    public String variableHello(@PathVariable int num) {
        return "Hello, Variable! " + Integer.toString(num);
    }
}
