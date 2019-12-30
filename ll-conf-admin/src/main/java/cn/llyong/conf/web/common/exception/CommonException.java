package cn.llyong.conf.web.common.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-10
 * @time: 8:00 下午
 * @version: 1.0
 */
public class CommonException extends RuntimeException {

    public CommonException() {

    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

}
