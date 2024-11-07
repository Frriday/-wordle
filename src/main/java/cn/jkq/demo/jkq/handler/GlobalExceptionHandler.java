package cn.jkq.demo.jkq.handler;

import cn.jkq.demo.jkq.constant.RespMsg;
import cn.jkq.demo.jkq.exception.AnswerExistException;
import cn.jkq.demo.jkq.exception.NoAnswerException;
import cn.jkq.demo.jkq.poj.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DateTimeParseException.class)
    public Result ex(DateTimeParseException e, HttpServletResponse resp) {
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        return Result.error(RespMsg.INVALID_DATE_FORMAT);
    }

    @ExceptionHandler(NoAnswerException.class)
    public Result ex(NoAnswerException e, HttpServletResponse resp) {
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return Result.error(RespMsg.NO_ANSWER);
    }

    @ExceptionHandler(AnswerExistException.class)
    public Result ex(AnswerExistException e, HttpServletResponse resp) {
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_CONFLICT);
        return Result.error(RespMsg.DATE_HAVE_ANSWER);
    }
}
