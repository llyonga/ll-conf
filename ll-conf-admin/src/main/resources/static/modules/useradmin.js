/**

 @Name：layuiAdmin 用户管理 管理员管理 角色管理
 @Author：star1029
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */

var $ = layui.$
    ,table = layui.table
    ,form = layui.form;

//用户管理
table.render({
  elem: '#LAY-user-table'
  ,url: '/user/getUserList' //模拟接口
  ,cols: [
      [
    {type: 'checkbox', fixed: 'left'}
    ,{field: 'userId', width: 100, title: '用户ID', sort: true}
    ,{field: 'username', title: '用户名', minWidth: 100}
    ,{field: 'deptName', title: '所属部门', minWidth: 100}
    ,{field: 'mobile', title: '手机'}
    ,{field: 'email', title: '邮箱'}
    ,{field: 'sex', width: 80, title: '性别'}
    ,{field: 'status', title: '状态'}
    // ,{field: 'picture', title: '头像', width: 100, templet: '#imgTpl'}
    ,{field: 'lastLoginTime', title: '最后登录时间', templet:'<div>{{ layui.util.toDateString(d.lastLoginTime, "yyyy-MM-dd HH:mm:ss") }}</div>', sort: true}
    ,{field: 'createTime', title: '创建时间', templet:'<div>{{ layui.util.toDateString(d.createTime, "yyyy-MM-dd HH:mm:ss") }}</div>', sort: true}
    ,{title: '操作', width: 150, align:'center', fixed: 'right', toolbar: '#user-table'}
    ]
  ]
  ,page: true
  ,limit: 30
  ,height: 'full-220'
  ,text: '对不起，加载出现异常！'
});

//监听工具条
table.on('tool(LAY-user-table)', function(obj){
  var line_data = obj.data;
  if(obj.event === 'del'){

    layer.confirm('真的删除行么', function(index){
      //提交 Ajax 成功后，更新表格中的数据
      layui.$.ajax({
        url:'/user/del'
        ,type:'post'
        ,contentType:'application/json;charset=utf-8'
        ,dataType:'json'
        ,data: JSON.stringify({"id" : line_data.id, "type" : line_data.type})
        ,success:function(data){
          //执行成功
          if (data.code == 0 ) {
            layer.msg(data.msg, {icon: 1});
            layui.table.reload('LAY-user-table'); //数据刷新
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
      ,content: '/user/turn/add?id=' + line_data.id
      ,shade: 0.3
      // ,maxmin: true
      ,area: ['500px', '450px']
      ,btn: ['确定', '取消']
      ,yes: function(index, layero){
        var iframeWindow = window['layui-layer-iframe'+ index]
            ,submitID = 'LAY-user-front-submit'
            ,submit = layero.find('iframe').contents().find('#'+ submitID);

        //监听提交
        iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
          var field = data.field; //获取提交的字段

          //提交 Ajax 成功后，更新表格中的数据
          layui.$.ajax({
            url:'/user/save'
            ,type:'post'
            ,contentType:'application/json;charset=utf-8'
            ,dataType:'json'
            ,data: JSON.stringify(field)
            ,success:function(data){
              //执行成功
              if (data.code == 0 ) {
                layer.msg(data.msg, {icon: 1});
                layui.table.reload('LAY-user-table'); //数据刷新
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

// //管理员管理
// table.render({
//   elem: '#LAY-user-back-manage'
//   ,url: layui.setter.base + 'json/useradmin/mangadmin.js' //模拟接口
//   ,cols: [[
//     {type: 'checkbox', fixed: 'left'}
//     ,{field: 'id', width: 80, title: 'ID', sort: true}
//     ,{field: 'loginname', title: '登录名'}
//     ,{field: 'telphone', title: '手机'}
//     ,{field: 'email', title: '邮箱'}
//     ,{field: 'role', title: '角色'}
//     ,{field: 'jointime', title: '加入时间', sort: true}
//     ,{field: 'check', title:'审核状态', templet: '#buttonTpl', minWidth: 80, align: 'center'}
//     ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
//   ]]
//   ,text: '对不起，加载出现异常！'
// });
//
// //监听工具条
// table.on('tool(LAY-user-back-manage)', function(obj){
//   var data = obj.data;
//   if(obj.event === 'del'){
//     layer.prompt({
//       formType: 1
//       ,title: '敏感操作，请验证口令'
//     }, function(value, index){
//       layer.close(index);
//       layer.confirm('确定删除此管理员？', function(index){
//         console.log(obj)
//         obj.del();
//         layer.close(index);
//       });
//     });
//   }else if(obj.event === 'edit'){
//     var tr = $(obj.tr);
//
//     layer.open({
//       type: 2
//       ,title: '编辑管理员'
//       ,content: '../../../views/user/administrators/adminform.html'
//       ,area: ['420px', '420px']
//       ,btn: ['确定', '取消']
//       ,yes: function(index, layero){
//         var iframeWindow = window['layui-layer-iframe'+ index]
//             ,submitID = 'LAY-user-back-submit'
//             ,submit = layero.find('iframe').contents().find('#'+ submitID);
//
//         //监听提交
//         iframeWindow.layui.form.on('submit('+ submitID +')', function(data){
//           var field = data.field; //获取提交的字段
//
//           //提交 Ajax 成功后，静态更新表格中的数据
//           //$.ajax({});
//           table.reload('LAY-user-front-submit'); //数据刷新
//           layer.close(index); //关闭弹层
//         });
//
//         submit.trigger('click');
//       }
//       ,success: function(layero, index){
//
//       }
//     })
//   }
// });
//
// //角色管理
// table.render({
//   elem: '#LAY-user-back-role'
//   ,url: layui.setter.base + 'json/useradmin/role.js' //模拟接口
//   ,cols: [[
//     {type: 'checkbox', fixed: 'left'}
//     ,{field: 'id', width: 80, title: 'ID', sort: true}
//     ,{field: 'rolename', title: '角色名'}
//     ,{field: 'limits', title: '拥有权限'}
//     ,{field: 'descr', title: '具体描述'}
//     ,{title: '操作', width: 150, align: 'center', fixed: 'right', toolbar: '#table-useradmin-admin'}
//   ]]
//   ,text: '对不起，加载出现异常！'
// });
//
// //监听工具条
// table.on('tool(LAY-user-back-role)', function(obj){
//   var data = obj.data;
//   if(obj.event === 'del'){
//     layer.confirm('确定删除此角色？', function(index){
//       obj.del();
//       layer.close(index);
//     });
//   }else if(obj.event === 'edit'){
//     var tr = $(obj.tr);
//
//     layer.open({
//       type: 2
//       ,title: '编辑角色'
//       ,content: '../../../views/user/administrators/roleform.html'
//       ,area: ['500px', '480px']
//       ,btn: ['确定', '取消']
//       ,yes: function(index, layero){
//         var iframeWindow = window['layui-layer-iframe'+ index]
//             ,submit = layero.find('iframe').contents().find("#LAY-user-role-submit");
//
//         //监听提交
//         iframeWindow.layui.form.on('submit(LAY-user-role-submit)', function(data){
//           var field = data.field; //获取提交的字段
//
//           //提交 Ajax 成功后，静态更新表格中的数据
//           //$.ajax({});
//           table.reload('LAY-user-back-role'); //数据刷新
//           layer.close(index); //关闭弹层
//         });
//
//         submit.trigger('click');
//       }
//       ,success: function(layero, index){
//
//       }
//     })
//   }
// });