package cn.jkq.demo.jkq.service;

import cn.jkq.demo.jkq.poj.Answer;
import cn.jkq.demo.jkq.poj.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface AnswersService {

    Result<Answer> getAnswerByDate(LocalDate date);

    Result<List<Answer>> getAllAnswers();

    Result addAnswer(Answer answer);

    Result updateAnswer(Answer answer);

    Result deleteAnswer(LocalDate date);
}
