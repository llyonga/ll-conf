

$(function() {
    var setting = {
        callback: {
            onClick: zTreeOnClick
        },
        data : {
            key : {
                name: "title",
                level: "level"
            },
            simpleData : {
                enable: true,
                idKey: "menuId",
                pIdKey: "parentId",
                rootPId: 0
            }
        },
        //页面上的显示效果
        view: {
            addHoverDom: addHoverDom, //当鼠标移动到节点上时，显示用户自定义控件
            removeHoverDom: removeHoverDom //离开节点时的操作
        },
        edit: {
            // enable: true, //单独设置为true时，可加载修改、删除图标
            editNameSelectAll: true
            // showRemoveBtn: showRemoveBtn,
            // showRenameBtn: showRenameBtn
        }
    };
    var treeNodes;
    $.ajax({
        type : "post",
        url : '/menu/getMenuTree',
        success : function(data) {
            treeNodes = data;
            $.fn.zTree.init($("#menuTree"), setting, treeNodes);
            var treeObj = $.fn.zTree.getZTreeObj("menuTree");
            // treeObj.expandAll(true);
            var nodes = treeObj.getNodes();
            if (nodes && nodes.length>0) {
                treeObj.expandNode(nodes[0], true, false, false);//默认展开第一级节点
            }

            //加载菜单下拉选
            var menu_str = '';
            for (var i = 0; i < data.length ; i++) {
                menu_str += '<option value="'+ data[i].menuId +'">'+ data[i].title +'</option>';
            }
            $('#parentId').append(menu_str);
            layui.form.render();
        },
        error : function() {
            layer.msg('加载失败', { icon: 7, time: 3000, shade: [0.3, '#000', true] });
        }
    });

    //加载层级下拉选
    $.ajax({
        url:'/dict/code/getCodeList?type=' + "level",
        type:'get',
        dataType:'json',
        success:function(data){
            var str = '';
            for (var i = 0; i < data.length ; i++) {
                str += '<option value="'+ data[i].code +'">'+ data[i].text +'</option>';
            }
            $('#level').append(str);
            layui.form.render();
        }
    });


});

//菜单树点击事件
function zTreeOnClick(event, treeId, treeNode) {
    if (treeNode.level == 0) {
        layer.msg('禁止修改根节点', { icon: 0, time: 3000, shade: [0.3, '#000', true] });
        return;
    }
    if (!treeNode.menuId) {
        // $("#permission-form")[0].reset();
        // layui.form.render();
        restForm();
        layui.form.val('permission-form', {
            "parentId": treeNode.parentId
            ,"level": Number(treeNode.level) + 1
        });
        // $("#parentId").val(treeNode.parentId);
        return;
    }
    $.ajax({
        type : "post",
        data: {
            "permissionId" : treeNode.menuId
        },
        url : '/menu/getMenuOne',
        success : function(d) {
            restForm();
            layui.form.val('permission-form', {
                "id": d.id
                ,"permissionId": d.permissionId
                ,"permissionName": d.permissionName
                // ,"type": d.type
                ,"title": d.title
                ,"parentId": d.parentId
                ,"href": d.href
                ,"level": d.level
                ,"icon": d.icon
                ,"seq": d.seq
                ,"status": d.status == 'Y' ? true : false
            });
            loadButtons(d.permissionId);
        },
        error : function() {
            layer.msg('请求失败', { icon: 7, time: 5000, shade: [0.6, '#000', true] });
        }
    });
}

function restForm() {
    layui.form.val('permission-form', {
        "id": ''
        ,"permissionId": ''
        ,"permissionName": ''
        // ,"type": ''
        ,"title": ''
        ,"parentId": ''
        ,"href": ''
        ,"level": ''
        ,"icon": ''
        ,"seq": ''
        ,"status": true
    });
}

//鼠标移入显示“+”按钮
function addHoverDom(treeId, treeNode) {
    var sObj = $("#" + treeNode.tId + "_span"); //获取节点信息
    if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;

    var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>"; //定义添加按钮
    sObj.after(addStr); //加载添加按钮
    var btn = $("#addBtn_"+treeNode.tId);

    //绑定添加事件，并定义添加操作
    if (btn) {
        btn.bind("click", function(){
            var zTree = $.fn.zTree.getZTreeObj("menuTree");
            var newNode = zTree.addNodes(treeNode, {menuId:'', parentId:treeNode.menuId, title: '新增节点'}); //页面上添加节点
            zTree.selectNode(newNode); //让新添加的节点处于选中状态
        });
    }
};
//鼠标移出，移除“+”按钮
function removeHoverDom(treeId, treeNode) {
    $("#addBtn_"+treeNode.tId).unbind().remove();
};


/**
 * 刷新当前节点
 */
function refreshNode() {
    /*根据 treeId 获取 zTree 对象*/
    var zTree = $.fn.zTree.getZTreeObj("menuTree"),
    type = "refresh",
    silent = false,
    /*获取 zTree 当前被选中的节点数据集合*/
    nodes = zTree.getSelectedNodes();
    /*强行异步加载父节点的子节点。[setting.async.enable = true 时有效]*/
    zTree.reAsyncChildNodes(nodes[0], type, silent);
}

var button_op_str = '<div class="layui-form" lay-filter="button-form" id="button-form" style="padding: 20px 0 0 0;">\n' +
    '        <div class="layui-form-item">\n' +
    '            <label class="layui-form-label">标题</label>\n' +
    '            <div class="layui-input-inline">\n' +
    '                <input type="hidden" name="parentId" placeholder="" lay-verify="required" autocomplete="off" class="layui-input">\n' +
    '                <input type="hidden" name="type">\n' +
    '                <input type="text" name="title" placeholder="标题" lay-verify="required" autocomplete="off" class="layui-input">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="layui-form-item">\n' +
    '            <label class="layui-form-label">名称</label>\n' +
    '            <div class="layui-input-inline">\n' +
    '                <input type="text" name="permissionName" placeholder="名称" lay-verify="required" autocomplete="off" class="layui-input">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="layui-form-item">\n' +
    '            <label class="layui-form-label">序号</label>\n' +
    '            <div class="layui-input-inline">\n' +
    '                <input type="text" name="seq" placeholder="序号" autocomplete="off" class="layui-input" lay-verify="required|number">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="layui-form-item">\n' +
    '            <label class="layui-form-label">URL</label>\n' +
    '            <div class="layui-input-inline" style="width:260px;">\n' +
    '                <input type="text" name="href" placeholder="URL" autocomplete="off" class="layui-input" >\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="layui-form-item">\n' +
    '            <label class="layui-form-label">状态</label>\n' +
    '            <div class="layui-input-block">\n' +
    '                <input type="checkbox" checked="true" name="status" lay-skin="switch" lay-text="启用|禁用">\n' +
    '            </div>\n'+
    '        </div>\n' +
    '    </div>';


