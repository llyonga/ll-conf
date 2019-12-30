package cn.llyong.conf.web.common.enums;

/**
 * @description:
 * @author: llyong
 * @date: 2019/12/17
 * @time: 22:28
 * @version: 1.0
 */
public enum StatusEnum {

    Y_ENUM("Y", "启用"),
    N_ENUM("N", "禁用"),
    ;

    private String type;
    private String text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    StatusEnum(String type, String text) {
        this.type = type;
        this.text = text;
    }
}
