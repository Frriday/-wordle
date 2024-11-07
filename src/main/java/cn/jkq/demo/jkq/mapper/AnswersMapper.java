package cn.jkq.demo.jkq.mapper;

import cn.jkq.demo.jkq.poj.Answer;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AnswersMapper {
    Answer selectAnswerByDate(LocalDate date);

    List<Answer> selectAnswers();

    void insertAnswer(Answer answer);

    void deleteAnswer(LocalDate date);

    void updateAnswer(Answer answer);
}
