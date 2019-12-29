

layui.table.render({
    elem: '#LAY-type-table'
    ,url: '/dict/type/getPageList' //数据接口
    ,cols: [
        [
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'type', title: '类型', sort: true, width:100, minWidth: 80}
            ,{field: 'name', title: '名称', width:100, minWidth: 80}
            ,{field: 'status', title: '状态', width:100, minWidth: 80, templet: '#switchTpl', unresize: true}
            ,{field: 'creator', title: '创建人', width:80, minWidth: 80}
            ,{field: 'createTime', title: '创建时间', templet:'<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>', width:230, sort: true, minWidth: 80}
            ,{field: 'remark', title: '备注', minWidth: 80}
            ,{title: '操作', width: 150, align:'center', fixed: 'right', toolbar: '#type-table'}
        ]
    ]
    ,page: true
    ,limit: 30
    ,height: 'full-220'
    ,text: '对不起，加载出现异常！'
});


//监听工具条
layui.table.on('tool(LAY-type-table)', function(obj){
    var line_data = obj.data;
    if(obj.event === 'del'){

        layer.confirm('真的删除行么', function(index){
            //提交 Ajax 成功后，更新表格中的数据
            layui.$.ajax({
                url:'/dict/type/del'
                ,type:'post'
                ,contentType:'application/json;charset=utf-8'
                ,dataType:'json'
                ,data: JSON.stringify({"id" : line_data.id, "type" : line_data.type})
                ,success:function(data){
                    //执行成功
                    if (data.code == 0 ) {
                        layer.msg(data.msg, {icon: 1});
                        layui.table.reload('LAY-type-table'); //数据刷新
                        layer.close(index); //关闭弹层
                    } else {
                        layer.msg(data.msg, { icon: 7, time: 5000, shade: [0.6, '#000', true] });
                    }
                }
            });
        });
    } else if(obj.event === 'edit'){
        // var tr = $(obj.tr);

        layer.open({
            type: 2
            ,title: '修改'
            ,content: '/dict/type/turn/add?id=' + line_data.id
            ,shade: 0.3
            // ,maxmin: true
            ,area: ['500px', '450px']
            ,btn: ['确定', '取消']
            ,yes: function(index, layero){
                var iframeWindow = window['layui-layer-iframe'+ index]
                    ,submitID = 'LAY-type-front-submit'
                    ,submit = layero.find('iframe').contents().find('#'+ submitID);

                //监听提交
                iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
                    var field = data.field; //获取提交的字段

                    //提交 Ajax 成功后，更新表格中的数据
                    layui.$.ajax({
                        url:'/dict/type/save'
                        ,type:'post'
                        ,contentType:'application/json;charset=utf-8'
                        ,dataType:'json'
                        ,data: JSON.stringify(field)
                        ,success:function(data){
                            //执行成功
                            if (data.code == 0 ) {
                                layer.msg(data.msg, {icon: 1});
                                layui.table.reload('LAY-type-table'); //数据刷新
                                layer.close(index); //关闭弹层
                            } else {
                                layer.msg(data.msg, { icon: 7, time: 5000, shade: [0.6, '#000', true] });
                            }
                        }
                    });
                });

                submit.trigger('click');
            }
            ,success: function(layero, index){

            }
        });
    }
});