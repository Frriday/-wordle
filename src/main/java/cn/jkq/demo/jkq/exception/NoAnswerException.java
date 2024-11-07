package cn.jkq.demo.jkq.exception;

public class NoAnswerException extends RuntimeException {
    public NoAnswerException() {}
    public NoAnswerException(String message) {
        super(message);
    }
}
