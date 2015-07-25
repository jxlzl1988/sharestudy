<#assign ctx=request.contextPath>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>文件详情</title>
    <#include "/mis/common/static.ftl">    
  </head>
<body>
    <#include "/mis/common/header.ftl">
    <div class="container-fluid container-main">
      <div class="row-fluid">
        <#include "/mis/common/left.ftl">
        <div class="span10">
          <div class="hero-unit">
              <h2 class="border-none p0">
                <a class="select" href="${ctx}/mis/article.html?categoryId=${article.categoryid}">返回文章列表</a>
              </h2>
          </div>
          <div class="hero-unit">
            <h2>${article.title}</h2>
                <div class="form-horizontal">
                	<input type="hidden" name="id" value="${article.id}">
                    <div class="control-group">
                    	<label class="control-label">文章内容</label>
                    	<div class="controls h-controls">
                            <textarea class="span10" name="descri" rows="20" cols="300">${article.content}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                    	<label class="control-label">文章摘要</label>
                    	<div class="controls h-controls">
                            <textarea class="span10" name="digest" rows="1" cols="300">${article.digest!""}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                    	<label class="control-label">文章关键字</label>
                    	<div class="controls h-controls">
                            <textarea class="span10" name="keywords" rows="1" cols="300">${article.keywords!""}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">百度分享内容</label>
                    	<div class="controls h-controls">
                    	<textarea class="span10" name="bdtext" rows="1" cols="300">${article.bdtext!""}</textarea>

                    	</div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">百度分享摘要</label>
                    	<div class="controls h-controls">
                    	    <textarea class="span10" name="bddesc" rows="1" cols="300">${article.bddesc!""}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">百度分享url</label>
                    	<div class="controls h-controls">
                    	    <textarea class="span10" name="bdurl" rows="1" cols="300">${article.bdurl!""}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">百度分享图片</label>
                    	<div class="controls h-controls">
                    	    <textarea class="span10" name="bdpic" rows="1" cols="300">${article.bdpic!""}</textarea>
                    	</div>
                    </div>
                    <div class="control-group">
                    	<label class="control-label">阅读次数</label>
                    	<div class="controls h-controls">
                    		<input type="text" value="${article.readnum}" disabled>
                    	</div>
                        <label class="control-label">创建时间</label>
                    	<div class="controls h-controls">
                    		<input type="text" value="${article.createtime?string("yyyy-MM-dd hh:mm:ss")}" disabled>
                    	</div>
                    	<label class="control-label">修改时间</label>
                    	<div class="controls h-controls">
                    		<input type="text" value="${article.updatetime?string("yyyy-MM-dd hh:mm:ss")}" disabled>
                    	</div>
                    </div>
                    <div class="hero-unit">
                      <div class="control-group">
                          <dl class="dl-horizontal">
                            <div class="control-group">
                              <div class="row-fluid">
                                <ul class="thumbnails">
                                  <li class="span10 templete" style="display:none;">
                                    <div class="thumbnail clearfix">
                                      <div class="controls h-controls">
                                          <img alt="300x200" style="width: 300px; height: 200px;" src="">
                                      </div>
                                      <div class="controls h-controls">
                                            <label class="control-label">访问标签：</label>
                                            <div class="controls h-controls">
                                              <input type="text">
                                            </div> 
                                            <a class="btn btn-danger ml-10" href="#">删除</a>
                                      </div>
                                    </div>
                                  </li>
                                  <#list images as image>
	                                  <li class="span10">
	                                    <div class="thumbnail clearfix">
	                                      <div class="controls h-controls">
	                                          <img alt="300x200" style="width: 300px; height: 200px;" src="${image.imageurl}">
	                                      </div>
	                                      <div class="controls h-controls">
	                                            <label class="control-label">访问标签：</label>
	                                            <div class="controls h-controls">
	                                              <input type="text" value="${image.url}">
	                                            </div> 
	                                            <a class="btn btn-danger ml-10" href="#" imageid="${image.id}">删除</a>
	                                      </div>
	                                    </div>
	                                  </li>
                                  </#list>
                                </ul>
                                <div class="d-row-pd1540">
                                	<form id="update_image_action"  action="${ctx}/mis/image/upload"  method="post" enctype="multipart/form-data">
									   <input type="file" name="uploadFile" id="upload_image_input" style="display:none;">
									   <input type="hidden" name="targetid" value="${article.id}">
                       				   <input type="hidden" name="type" value="1">
									</form>
                                   <button type="button" id="upload_image" class="btn btn-info">选择上传图片</button>
                                </div> 
                              </div>
                            </div>
                         </dl>
                      </div>
                    </div>
                </div>
                <div class="control-group">
                  <p class="button">
                    <button class="btn btn-primary" onclick="update()" type="button">保存</button>
                  </p>
                  <p class="button">
                    <a class="btn btn-primary" target="blank" href="${ctx}/article-${article.id}.html">预览</a>
                  </p>
                </div>
          </div>
          
          </div>
        </div>
      </div>
      <hr>
      <#include "/mis/common/footer.ftl">
    </div>
  </body>
</html>
<script type="text/javascript">
function update(){
	var id = $("input[name='id']").val();
	var descri = $("textarea[name='descri']").val() ;
	var digest = $("textarea[name='digest']").val() ;
	var keywords = $("textarea[name='keywords']").val() ;
	
	var bdtext = $("textarea[name='bdtext']").val() ;
	var bddesc = $("textarea[name='bddesc']").val() ;
	var bdurl = $("textarea[name='bdurl']").val() ;
	var bdpic = $("textarea[name='bdpic']").val() ;
	
	$.ajax({
		type:"post",
		url: "${ctx}/mis/save_article.do",
		data:{descri: descri,id:id,digest:digest,keywords:keywords
		,bdtext:bdtext,bddesc:bddesc,bdurl:bdurl,bdpic:bdpic} ,
		success: function(msg) {
			if(msg == 1) {
				alert("修改成功") ;
			} else {
				alert("修改失败") ;
			}
		}
	}) ;
}
$(function(){
    $("#upload_image").click(function(){
		$("#upload_image_input").click() ;
	}) ;
	
	$("#upload_image_input").change(function(){
		$("#update_image_action").ajaxSubmit({
			success: function(data) {
				var templete = $(".templete").clone().show().removeClass("templete") ;
				$(".templete").after(templete);
			
			    $(templete).find("img").attr("src",data.imageurl) ;
			    $(templete).find("input").val(data.tag) ;
			},
			error: function(XmlHttpRequest, textStatus, errorThrown){  
				alert("图片上传失败！") ;
           }  
		});
	}) ;
});
</script>
