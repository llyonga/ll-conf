package cn.llyong.conf.web.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2019/12/14
 * @time: 20:27
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 响应吗
     */
    private int code;
    /**
     * 响应消息
     */
    private String msg;
    /**
     * 总计
     */
    private int count;
    /**
     * 第几页
     */
    private Integer page;
    /**
     * 数据
     */
    private List<T> data;

    public PageResponse(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }
}
