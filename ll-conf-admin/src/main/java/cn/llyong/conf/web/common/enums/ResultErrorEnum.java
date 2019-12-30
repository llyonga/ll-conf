package cn.llyong.conf.web.common.enums;

/**
 * Created with IntelliJ IDEA.
 *
 * @description:
 * @author: lvyong
 * @date: 2019-12-18
 * @time: 7:13 下午
 * @version: 1.0
 */
public enum ResultErrorEnum {

    RESULT_ERROR_ENUM_0(0, "保存成功"),
    ;

    private int errorCode;
    private String errorMsg;

    ResultErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
