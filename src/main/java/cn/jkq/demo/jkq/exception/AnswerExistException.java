package cn.jkq.demo.jkq.exception;

public class AnswerExistException extends RuntimeException {
    public AnswerExistException() {}
    public AnswerExistException(String message) {
        super(message);
    }
}
