package cn.llyong.conf.web.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-10
 * @time: 8:02 下午
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private T data;

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
