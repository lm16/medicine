$('#dg').datagrid({
    url: '/medicine-list.do',
    columns:[[
        {field:'mname', title:'药品名称', width:100},
        {field:'mmode', title:'药品模式', width:100},
        {field:'mefficacy', title:'药品功效', width:100},
    ]],
    fitColumns: true,
    singleSelect: true,
    rownumbers:true,
    title:"药品信息",
    toolbar:"#tb",
    pagination: true
});


var url;
function newBean(){
    $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增药品');
    $('#fm').form('clear');
    url='/medicine-create.do';
}
function saveUser(){
    $('#fm').form('submit',{
        url: url,
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
            var result = eval('('+result+')');
            if (result.errorMsg){
                $.messager.show({
                    title: 'Error',
                    msg: result.errorMsg
                });
            } else {
                $('#dlg').dialog('close');        // close the dialog
                $('#dg').datagrid('reload');    // reload the user data
            }
        }
    });
}

function editBean(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑店员');
        $('#fm').form('load', row);
        url = '/medicine-update?id='+row.id;
    }
}
function destroyBean(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('Confirm','您确定要删除这条记录吗',function(r){
            if (r){
                $.post('/medicine-delete.do',{id:row.id},function(result){
                    if (result.success){
                        $('#dg').datagrid('reload');    // reload the user data
                    } else {
                        $.messager.show({    // show error message
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    }
                },'json');
            }
        });
    }
}

function doSearch(){
    $('#tt').datagrid('load',{
        mname: $('#mname').val(),
        mmode: $('#mmode').val(),
        mefficacy: $('#mefficacy').val()
    });
}