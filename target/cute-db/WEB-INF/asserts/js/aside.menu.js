$(function(){
	var rightPageHeight = $(".right").height();
	var windowHeight = $(window).height();
	if(windowHeight >= rightPageHeight){
		$(".left").css("height",windowHeight+"px");
	}else{
		$(".left").css("height",rightPageHeight+"px");
	}
	$(".left").css("maxHeight",windowHeight+"px");
	$(".right").css("maxHeight",windowHeight+"px");

	$(".aside-menu").find(".list-item").each(function(){
		$(this).find("a").mouseover(function(){
			// alert("hehe");
			$(this).addClass("list-item-high");
		}).mouseout(function(){
			$(this).removeClass("list-item-high");
		});
	});

});