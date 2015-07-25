<#assign ctx=request.contextPath>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>类目管理</title>
    <#include "/mis/common/static.ftl">    
  </head>
<body>
    <#include "/mis/common/header.ftl">
    <div class="container-fluid container-main">
      <div class="row-fluid">
        <#include "/mis/common/left.ftl">
        <div class="span10">
          <div class="hero-unit">
            <h2>类目列表</h2>
                <div class="hero-unit">
                  <table class="table table-hover othertable">
                     <thead>
                          <tr>
                            <th>名称</th>
                            <th>文章数</th>
                            <th>排序</th>
                            <th>操作</th>
                          </tr>
                    </thead>
                    <tbody>
	                    <#list categories as c>
		                    <tr>
		                        <td style="text-align:left; padding:0 20px;width:400px;">
		                        	${c.title}
		                        </td>
		                        <td style="width:100px;">
		                        	${c.articlecount}
		                        </td>                                                                     
		                        <td style="width:100px;">
		                        	${c.sort}
		                        </td>                                                                     
		                        <td style="width:200px;">
		                            <a href="javascript:void(0)" onclick="updateCategory(${c.id})" class="btn btn-primary">编辑</a>
		                            <a href="${ctx}/mis/article.html?categoryId=${c.id}">文章列表</a>
		                        </td>
		                    </tr>
						</#list>
                    </tbody>
                </table>
             </div>
             <div class="control-group">
                  <p class="button">
                  	<a href="javascript:void(0)" onclick="addCategory();" class="btn btn-large ml-10">新添类目</a>
                  </p>
             </div>
          </div>
        </div>
      </div>
      <hr>
      <#include "/mis/common/footer.ftl">
    </div>
    <div id="add_category" style="display:none; padding:85px 45px;">
        <span>类目名称：</span><input type="text" id="new_name"/><br/>
        <span>类目排序：</span><input type="text" id="new_sort"/><br/>
      	<input type="button" onclick="addCategoryDo();" class="btn btn-primary" value="保存"/>
    </div>
    <div id="update_category" style="display:none;padding:85px 45px;">
    	<input type="hidden" id="update_id"/>
    	<span>类目名称：</span><input type="text" id="update_name"/><br/>
    	<span>类目排序：</span><input type="text" id="update_sort"/><br/>
    	<input type="button" onclick="updateCategoryDo();" class="btn btn-primary" value="保存"/>
    </div>
  </body>
</html>
<script>
var i ;
function addCategory() {
	i = $.layer({
    type : 1,
    title : false,
    fix : false,
    shadeClose: true,
    offset:['50px' , ''],
    area : ['415px','315px'],
    page : {dom : '#add_category'}
  });
}
function addCategoryDo() {
	var title = $("#new_name").val();
	var sort = $("#new_sort").val() ;
	$.ajax({
		type:"get",
		url:"${ctx}/mis/add_category.do",
		data:{title:title,sort:sort},
		success:function(msg){
			layer.alert("添加成功！") ;
			layer.close(i);
			location.reload();
		} 
	});
}
function updateCategory(categoryId) {
	$.ajax({
		type:"get",
		url:"${ctx}/mis/category.do",
		data:{categoryId:categoryId},
		success:function(msg){
			if(msg.length != 0) {
				var obj = msg ;
				$("#update_id").val(obj.id) ;
				$("#update_name").val(obj.title) ;
				$("#update_sort").val(obj.sort) ;
				i = $.layer({
				    type : 1,
				    title : false,
				    shadeClose: true,
				    fix : false,
				    offset:['50px' , ''],
				    area : ['415px','315px'],
				    page : {dom : '#update_category'}
				  });
			} else {
				alert("修改失败") ;
			}
		}
		
	});
}
function updateCategoryDo() {
	var id = $("#update_id").val();
	var title = $("#update_name").val();
	var sort = $("#update_sort").val() ;
	$.ajax({
		type:"get",
		url:"${ctx}/mis/update_category.do",
		data:{title:title,sort:sort, id:id},
		success:function(msg){
			layer.alert("修改成功！") ;
			layer.close(i);
			location.reload();
		} 
	});
}

</script>
