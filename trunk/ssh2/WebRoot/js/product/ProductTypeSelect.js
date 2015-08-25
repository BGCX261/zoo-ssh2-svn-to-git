function sureType(){
	var objForm = document.forms[0];
	var form = opener.document.forms[0];
	if (form){
		form["type.id"].value = objForm.typeId.value;
		form["product.type.name"].value = objForm.typeName.value;
	}
	window.close();
}
function clickType(typeId,typeName){
	var objForm = document.forms[0];
	objForm.typeId.value = typeId;
	objForm.typeName.value = typeName;
}
function getTypeList(typeid){
		var typecontent = document.getElementById('typecontent');
		if(typecontent){
			typecontent.innerHTML= "数据正在加载...";
			send_request(function(value){typecontent.innerHTML=value}, '<html:rewrite action="/control/product/type/manage"/>?method=gettypelist&typeid='+ typeid, true);
		}
}