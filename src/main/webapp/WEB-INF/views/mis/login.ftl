<#assign ctx=request.contextPath>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>分享系统MIS</title>
    <#include "/mis/common/static.ftl">   
  </head>
<body>
	<#include "/mis/common/header.ftl">
	<div class="mis-login">
        <div class="login-wrap">
          <h3 class="pop-h3">用户登录</h3>
          <div class="row pop-row mis-box">
              <div class="input-prepend block">
                <span class="add-on login-span user"></span>
                <input type="text" placeholder="账号" name="username" id="username" class="span4 login-input">
              </div>
              <div class="input-prepend block">
                <span class="add-on login-span psw"></span>
                <input type="password" name="password" placeholder="密码" id="password" class="span4 login-input">
              </div>
              <div class="pull-right">
                  <button class="btn btn-large btn-primary" onclick="login();" type="button">登录</button>
              </div>  
          </div>
       </div>
      <#include "/mis/common/footer.ftl">
    </div>
  </body>
</html>
<script type="text/javascript">
    function login(){
    	var username=$("#username").val();
		var password=$("#password").val();
		if(username =='' || password == ''){
			return;
		}
		var data="username="+encodeURIComponent(username)+"&password="+encodeURIComponent(password);
		$.ajax({
			type:"POST",
			url:"${ctx}/mis/login.do" ,
			data:data,
			dataType:"json",
			success:function(msg){
				if(msg == 0) {
					alert("用户名或者密码错误！") ;
				} else {
					location.href = "${ctx}/mis/categorys.html" ;
				}
			},error:function(msg){
				alert(error);
			}
		});
    }
</script>
