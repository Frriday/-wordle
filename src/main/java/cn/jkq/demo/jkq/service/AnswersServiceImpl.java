package cn.jkq.demo.jkq.service;

import cn.jkq.demo.jkq.constant.RespMsg;
import cn.jkq.demo.jkq.exception.AnswerExistException;
import cn.jkq.demo.jkq.exception.NoAnswerException;
import cn.jkq.demo.jkq.mapper.AnswersMapper;
import cn.jkq.demo.jkq.poj.Answer;
import cn.jkq.demo.jkq.poj.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService {
    @Autowired
    AnswersMapper ansMapper;

    @Override
    public Result<Answer> getAnswerByDate(LocalDate date) {
        Answer answer = ansMapper.selectAnswerByDate(date);
        if (answer == null) {
            throw new NoAnswerException(RespMsg.NO_ANSWER);
        }
        return Result.success(answer);
    }

    @Override
    public Result<List<Answer>> getAllAnswers() {
        List<Answer> answers = ansMapper.selectAnswers();
        return Result.success(answers);
    }

    @Override
    public Result addAnswer(Answer answer) {
        Answer result = ansMapper.selectAnswerByDate(answer.getAnswerDate());
        if (result != null) {
            throw new AnswerExistException(RespMsg.DATE_HAVE_ANSWER);
        }
        ansMapper.insertAnswer(answer);
        return Result.success();
    }

    @Override
    public Result updateAnswer(Answer answer) {
        Answer result = ansMapper.selectAnswerByDate(answer.getAnswerDate());
        if (result == null) {
            throw new NoAnswerException(RespMsg.DATE_HAVE_ANSWER);
        }
        ansMapper.updateAnswer(answer);
        return Result.success();
    }

    @Override
    public Result deleteAnswer(LocalDate date) {
        Answer result = ansMapper.selectAnswerByDate(date);
        ansMapper.deleteAnswer(date);
        if (result != null) {
            throw new AnswerExistException(RespMsg.DATE_HAVE_ANSWER);
        }
        return Result.success();
    }
}
