$(function(){
	//日期选择	
	$('.js-Wdate').click(function(){
		WdatePicker();
	});
	$('.alterOrder').on('click',function(){
		var popage = $.layer({
			shade : false,
			shade : [0.5 , '#000' , true],
			type : 1,
			area : ['593','auto'],
			title : false,
			fix : false,
			border : [0],
			page : {dom : '#AlterOrder'},
			close : function(index){
				layer.close(index);
				$('#AlterOrder').show();
			}
		});
		$('.clickcancel').on('click',function(){
			layer.close(popage);
		});
		return false;
	});
	//房源管理，结算管理全选
	$("input[type='checkbox'].js-checkall").click(function(){
      if($(this).prop('checked')){
        $(".hero-unit table").find(":checkbox").prop('checked',true);
      }else{
        $(".hero-unit table").find(":checkbox").prop('checked',false);
      }            
	});
 	$('input[name="checkone"]').unbind('click');
	$('input[name="checkone"]').on('click', function() {
		var d = document;
		var items = d.getElementsByName("checkone");
		var itemall = d.getElementById("checkall");
		var ite = 0;
		for ( var i = 0; i < items.length; i++) {
			if (items[i].checked) {
				ite++;
			}
		}
		if (ite == items.length - 1 && itemall.checked) {
			itemall.checked = false;
		}
		if (ite == items.length && !itemall.checked) {
			itemall.checked = true;
		}
	});
});

