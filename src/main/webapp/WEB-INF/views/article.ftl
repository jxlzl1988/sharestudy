<#assign ctx=request.contextPath>
<!DOCTYPE html>
  <head>
    <meta charset="gbk">
    <title>${ac.title}--分享学习</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="keywords" content="${ac.keywords!'分享学习 设计模式 数据库 sql java'}">
    <meta name="author" content="分享学习">
    <meta name="description" content="${ac.digest!''}" />
	<meta name="baidu-site-verification" content="2cbbbcb70a5c784a13f0d381b05507dc"/>
	<meta name="baidu-site-verification" content="JHg2HYeQZL" />
    <meta name="robots" content="index,follow">
    <#include "common/static.ftl"/>
  </head>
  <script>
	var url = document.domain ;
	window._bd_share_config = {
		common : {
			bdText : '${ac.bdtext!''}',	
			bdDesc : '${ac.bddesc!''}',	
			bdUrl : '${ac.bdurl!''}', 	
			bdPic : '${ac.bdpic!''}'
		},
		share : [{
			"bdSize" : 24
		}],
		slide : [{	   
			bdImg : 0,
			bdPos : "right",
			bdTop : 100
		}],
		image : [{
			viewType : 'list',
			viewPos : 'top',
			viewColor : 'black',
			viewSize : '24',
			viewList : ['qzone','tsina','huaban','tqq','renren']
		}],
		selectShare : [{
			"bdselectMiniList" : ['qzone','tqq','kaixin001','bdxc','tqf']
		}]
	}
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
  </script>
  <body>
    <section>
		<#include "common/header.ftl"/>
		<div id="content_main">
			<div id="content_up"> 
				<section id="lift">
				  <ul class="lift_tree">
				  	<#list acs as a>
				  		<#if a.eshow==1>
				  			<li><a <#if a.id==ac.id>class="lift_tree_selected"</#if> href="${ctx}/article-${a.id}.html">${a.title}</a></li>
				  		</#if>
				  	</#list>
				  </ul>
				</section>
				<section id="docs" class="page">
				  <h1>${ac.title}</h1>
				  <div class="content">
${ac.content}	
					<div class="bdsharebuttonbox" data-tag="share_1">
						<a class="bds_mshare" data-cmd="mshare"></a>
						<a class="bds_qzone" data-cmd="qzone" href="#"></a>
						<a class="bds_tsina" data-cmd="tsina"></a>
						<a class="bds_baidu" data-cmd="baidu"></a>
						<a class="bds_renren" data-cmd="renren"></a>
						<a class="bds_tqq" data-cmd="tqq"></a>
						<a class="bds_more" data-cmd="more">更多</a>
						<a class="bds_count" data-cmd="count"></a>
					</div>	     
				  </div>
				</section>
				<#include "common/right.ftl"/>
			</div>
			<div style="clear: both"></div>
		</div>
		<#include "common/footer.ftl"/>
    </section>
    <script src="${ctx}/static/js/hiless.js"></script>
    <script src="http://cdn.bootcss.com/jquery/1.9.1/jquery.min.js"></script>
  </body>
</html>