$(function(){
    $("#table-name").keyup(function(){
        var _this = $(this);
        var tableName = _this.val();
        var request_url = _this.attr("data-request-url");
        $.ajax({
            type : 'get',
            url : request_url,
            data : {'tableName' : tableName},
            dataType : 'json',
            success : function (data) {
//					alert(data);
                var html = "";
                for(var i = 0; i < data.length; ++i){
                    html += "<li class='list-item'>" +
                        "<a href='javascript:void' data-request-url='${basePath}/common/right.html?tableName="+data[i]+"'" +
                        "data-asyn-load='true' target='#table-info'>" + data[i] + "</a></li>";
                }
                $('#tables-list').html(html);
            }
        });
    });
});