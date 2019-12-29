/**

 @Name：layui.tool 工具
 @Author：llyong
 */


layui.define('jquery', function(exports){
    "use strict";

    var $ = layui.$

        //外部接口
        ,tool = {
            toText: function(type, code){
                $.ajax({
                    url:'/dict/code/getCodeList?type=' + type,
                    type:'get',
                    dataType:'json',
                    success:function(data){
                        var str = '';
                        for (var i = 0; i < data.length ; i++) {
                            if (data[i].code == code) {
                                return data[i].text;
                            }
                        }
                    }
                });
            }
        }

    //暴露接口
    exports('tool', tool);
});