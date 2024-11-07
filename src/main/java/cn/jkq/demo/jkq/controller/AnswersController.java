package cn.jkq.demo.jkq.controller;

import cn.jkq.demo.jkq.poj.Answer;
import cn.jkq.demo.jkq.poj.Result;
import cn.jkq.demo.jkq.service.AnswersService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/api/wordle")
@RestController
public class AnswersController {
    @Autowired
    AnswersService ansService;

    @GetMapping("/{date}")
    Result<Answer> getAnswer(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        log.info("getAnswer date={}", date);
        return ansService.getAnswerByDate(date);
    }

    @GetMapping
    Result<List<Answer>> getAnswers() {
        return ansService.getAllAnswers();
    }

    @PostMapping
    Result addAnswer(@RequestBody Answer answer) {
        log.info("addAnswer answer={}", answer);
        return ansService.addAnswer(answer);
    }

    @PutMapping("/{date}")
    Result updateAnswer(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @RequestBody Answer answer) {
        log.info("updateAnswer date={}", date);
        log.info("updateAnswer answer={}", answer);
        answer.setAnswerDate(date);
        return ansService.updateAnswer(answer);
    }

    @DeleteMapping("/{date}")
    Result deleteAnswer(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                        HttpServletResponse resp) {
        log.info("deleteAnswer date={}", date);
        Result result = ansService.deleteAnswer(date);
        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return result;
    }
}
