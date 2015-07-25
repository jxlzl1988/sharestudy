<#assign ctx=request.contextPath>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>文章管理</title>
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
                <a class="select" href="${ctx}/mis/categorys.html">返回类目</a>
              </h2>
          </div>
          <div class="hero-unit">
            <h2>${category.title}</h2>
                <div class="hero-unit">
                  <table class="table table-hover othertable">
                     <thead>
                          <tr>
                            <th>文章名称</th>
                            <th>排序</th>
                            <th>显示</th>
                            <th>操作</th>
                          </tr>
                    </thead>
                    <tbody>
                    <#list articles as c >
                    <tr>
						<td style="text-align:left; padding:0 20px;width:400px;">
							<a target="blank" href="${ctx}/article-${c.id}.html">${c.title}</a> 
						</td>
						<td style="width:100px;">
							${c.sort} 
						</td>
						<td style="width:100px;">
							<#if c.eshow==1>
								是
							<#else>
								否
							</#if>
						</td>
						<td style="width:100px;">
							<a href="javascript:void(0)" onclick="updateArticle(${c.id})" class="btn btn-primary">修改</a>
							<a href="${ctx}/mis/article_detail.html?articleId=${c.id}">详情</a>
						</td>
					</tr>
					</#list>
                    </tbody>
                </table>
             </div>
             <div class="control-group">
                  <p class="button">
                  	<a href="javascript:void(0)" onclick="addArticle(${category.id})"  class="btn btn-primary">新添文章</a>
                  </p>
             </div>
          </div>
        </div>
      </div>
      <hr>
      <#include "/mis/common/footer.ftl">
    </div>
    <div id="add_article" style="display:none; padding:85px 45px;">
    	<input type="hidden" id="new_categoryid"/>
        <span>文章名称：</span><input type="text" id="new_name"/><br/>
        <span>文章排序：</span><input type="text" id="new_sort"/><br/>
        <span>文章显示：</span>
        <select id="new_show">
        	<option value="2">否</option>
        	<option value="1">是</option>
        </select>
        <br/>
      	<input type="button" onclick="addArticleDo();" class="btn btn-primary" value="添加"/>
    </div>
    <div id="update_article" style="display:none;padding:85px 45px;">
    	<input type="hidden" id="update_id"/>
        <span>文章名称：</span><input type="text" id="name"/><br/>
        <span>文章排序：</span><input type="text" id="sort"/><br/>
        <span>文章显示：</span>
        <select id="show">
        	<option value="2">否</option>
        	<option value="1">是</option>
        </select>
        <br/>
      	<input type="button" onclick="updateArticleDo();" class="btn btn-primary" value="保存"/>
    </div>
  </body>
</html>
<script>
var i ;
function addArticle(categoryid) {
	$("#new_categoryid").val(categoryid) ;
	i = $.layer({
    type : 1,
    title : false,
    fix : false,
    shadeClose: true,
    offset:['50px' , ''],
    area : ['415px','315px'],
    page : {dom : '#add_article'}
  });
}
function addArticleDo() {
	var title = $("#new_name").val();
	var sort = $("#new_sort").val() ;
	var show = $("#new_show").val() ;
	var categoryid = $("#new_categoryid").val() ;
	$.ajax({
		type:"get",
		url:"${ctx}/mis/add_article.do",
		data:{title:title,sort:sort,show:show,categoryid:categoryid},
		success:function(msg){
			if(msg == 1) {
				layer.alert("添加成功！") ;
				layer.close(i);
				location.reload();
			} else {
				layer.alert("添加失败！") ;
			}
		} 
	});
}
function updateArticle(id) {
	$.ajax({
		type:"get",
		url:"${ctx}/mis/get_article.do",
		data:{id:id},
		success:function(msg){
			if(msg.length != 0) {
				var obj = msg ;
				$("#update_id").val(obj.id) ;
				$("#name").val(obj.title) ;
				$("#sort").val(obj.sort) ;
				$("#show").val(obj.eshow) ;
				i = $.layer({
				    type : 1,
				    title : false,
				    shadeClose: true,
				    fix : false,
				    offset:['50px' , ''],
				    area : ['415px','315px'],
				    page : {dom : '#update_article'}
				  });
			} else {
				alert("修改失败") ;
			}
		}
		
	});
}
function updateArticleDo() {
	var id = $("#update_id").val();
	var title = $("#name").val();
	var sort = $("#sort").val() ;
	var show = $("#show").val() ;
	$.ajax({
		type:"get",
		url:"${ctx}/mis/update_article.do",
		data:{title:title,sort:sort, id:id,show:show},
		success:function(msg){
			if(msg == 1) {
				layer.alert("修改成功！") ;
				layer.close(i);
				location.reload();
			} else {
				layer.alert("修改失败！") ;
			}
		} 
	});
}
</script>