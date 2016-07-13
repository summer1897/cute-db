$(function () {
    $('#show-create-table').on('click',function () {
        var _this = $(this);
        var tableName = _this.attr('data');
        var request_url = _this.attr("data-request-url");
        // alert(request_url);
        $.ajax({
            type : 'get',
            url : request_url,
            data : {'tableName' : tableName},
            dataType : 'json',
            success : function(data){
                var html = "<div class='table-info-style'>";
                for(var i = 0; i < data.length; ++i)
                    html += "<span>"+data[i]+"</span><br>";
                html += "</div>";
                layer.open({
                    //area : ['600px','800px'],
                    type: 1,
                    shade: false,
                    title: false, //不显示标题
                    content: html, //捕获的元素
                    cancel: function(index){
                        layer.close(index);
                        this.content.show();
                        //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
                    }
                });
            }
        });
    });
});