$('#dg').datagrid({
    url: '/agency-list.do',
    columns:[[
        {field:'aname', title:'姓名', width:100},
        {field:'asex', title:'性别', width:100},
        {field:'aphone', title:'电话', width:100},
        {field:'aremark', title:'备注', width:100}
    ]],
    fitColumns: true,
    singleSelect: true,
    title:"店员信息",
    toolbar:"#tb",
    rownumbers:true,
    pagination: true
});


var url;
function newBean(){
    $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增店员');
    $('#fm').form('clear');
    url = '/agency-create.do';
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
        url = '/agency-update?id='+row.id;
    }
}

function destroyBean(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('Confirm','您确定要删除这条记录吗',function(r){
            if (r){
                $.post('/agency-delete.do', {id:row.id}, function(result){
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
    $('#dg').datagrid('load',{
        aname: $('#aname').val(),
        asex: $('#asex').val(),
        aphone: $('#aphone').val(),
        aremark: $('#aremark').val(),
    });
}

