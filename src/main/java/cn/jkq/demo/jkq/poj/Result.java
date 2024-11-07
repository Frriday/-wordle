package cn.jkq.demo.jkq.poj;

import lombok.Data;

@Data
public class Result <E>{
    private int code;
    private String msg;
    private E data;

    public Result(int code, String message, E data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public static <E> Result<E> success() {
        return new Result<E>(1, "", null);
    }

    public static <E> Result<E> success(E data) {
        return new Result<E>(1, "", data);
    }

    public static <E> Result<E> success(String message, E data) {
        return new Result<E>(1, message, data);
    }

    public static <E> Result<E> error(String message) {
        return new Result<E>(0, message, null);
    }

}
