// $('#nav').tree({
// 	data:[
// 		{text: "药品信息", "iconCls":"icon-blank"},
// 		{text: "顾客信息", "iconCls":"icon-blank"},
// 		{text: "经办人信息", "iconCls":"icon-blank"}
// 	],
// 	onClick: function(node){
// 		if(node.attributes){
// 			Open(node.text, node.attributes.url, node.iconCls);
// 		}
// 	}
// });


function tabAdd(text,url) {
	if ($("#tabs").tabs('exists', text)) {
		$("#tabs").tabs('select', text);
	} else {
		var content = "<iframe style='width:100%;height:100%' src="+ url+ "></iframe>";   
		
		$("#tabs").tabs('add', {   //生成新的选项卡，
			title : text,
			closable : true,
			content :content
		});
	}
}