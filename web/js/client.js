$('#dg').datagrid({
    url: '/client-list.do',
    columns:[[
        {field:'cname', title:'姓名', width:100},
        {field:'csex', title:'性别', width:100},
        {field:'cage', title:'年龄', width:100},
        {field:'caddress', title:'地址', width:100},
        {field:'cphone', title:'电话', width:100},
        {field:'csymptom', title:'症状', width:100},
        {field:'mno', title:'药品编号', width:100},
        {field:'ano', title:'经办人编号', width:100},
        {field:'cdate', title:'访店日期', width:100},
        {field:'cremark', title:'备注', width:100}
    ]],
    fitColumns: true,
    singleSelect: true,
    title:"顾客信息",
    toolbar:"#tb",
    rownumbers:true,
    pagination: true
});


var url;
function newBean(){
    $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增顾客');
    $('#fm').form('clear');
    url='/client-create.do';
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
        url = '/client-update?id='+row.id;
    }
}

function destroyBean(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('Confirm','您确定要删除这条记录吗',function(r){
            if (r){
                $.post('/client-delete.do',{id:row.id},function(result){
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
        cname: $('#cname').val(),
        csex: $('#csex').val(),
        cage: $('#cage').val(),
        caddress: $('#caddress').val(),
        cphone: $('#cphone').val(),
        csymptom: $('#csymptom').val(),
        mno: $('#mno').val(),
        ano: $('#ano').val(),
        cdate: $('#cdate').val(),
        cremark: $('#cremark').val(),
    });
}