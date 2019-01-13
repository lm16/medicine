$(function(){
	$('#submit').click(function(){
		return post();
	});
});

function post(){
    $.ajax({
        url: "/validate.do",
        type: "POST",

        data: JSON.stringify({"usern":$('#usern').val().trim(), "passwd":$('#passwd').val().trim(), "type":$('input:radio:checked').val()}),
        contentType : "application/json;charset=UTF-8",

        success: function(data) {
            if (data == "success") {
                 window.location.href = '/home.html';
            } else {
                $.messager.alert('登陆失败', '请检查帐号、密码与用户类型', 'warning');
            }

        }
    });

    return false;
}