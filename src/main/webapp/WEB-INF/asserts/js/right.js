$(function(){

    /**
     * 查看表结构
     */
    $("a[data-action='show-create-table']").on('click',function () {
        var _this = $(this);
        var tableName = _this.attr('data-table');
        var request_url = _this.attr("data-request-url");
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

    /**
     * SQL查询排序
     */
    $("span[data-order='true']").on('click',function(){
        var _this = $(this);
        var _target = _this.attr("data-target");
        var _sql = $(_target).attr("data-sql");
        var _field = _this.attr("data-field-name");
        var _order = _this.attr("data-order-name");
        var _requestURL = _this.attr("data-request-url");
        $.ajax({
            type : 'get',
            url : _requestURL,
            data : {'sql' : _sql,'field' : _field,'order' : _order},
            dataType : 'json',
            success : function(data){
                var html = "";
                var _result = data.result.result;
                var _result_len = $(_result).length;
                if(_result_len > 0){
                    for(var i = 0; i < _result_len; ++i){
                        html += "<tr>";
                        var _db_fields = _result[i].dbFieldVoList;
                        var _db_fields_len = $(_db_fields).length;
                        if(_db_fields_len > 0){
                            for(var j = 0; j < _db_fields_len; ++j){
                                html += "<td align='center'>" +
                                    _db_fields[j].value + "</td>";
                            }
                        }

                        html += "</tr>";
                    }
                }
//					alert(html);
                $(_target).find("tbody").html(html);
            }
        });
    });

    /**
     * SQL查询异步请求处理
     */
    $('#sql-query-btn').on('click',function(){
        var _this = $(this);
        var request_url = _this.attr('data-request-url');
        var _sql = $('#sql').val();
        var _target = _this.attr('target');
        var _base_path = _this.attr("data-base-path");
        $.ajax({
            type : 'get',
            url : request_url,
            data : {'sql' : _sql,'pageIndex' : 1, 'pageSize' : 10},
            dataType : 'json',
            success : function(data){
                if(0 == data.code){
                    var _result = data.result;
                    if($(_result).length > 0){
                        var html = "<table class='table table-striped'>";

                        var _table_names = _result.tableNames;
                        var _table_names_len = $(_table_names).length;
                        if(_table_names_len > 0){
                            html += "<caption>";
                            for(var i = 0; i < _table_names_len; ++i){
                                html += "<span class='badge badge-add' style='margin:0px 5px;'>" +
                                        "<a href='javascript:void(0);' data-action='show-create-table' data-table='" +
                                        _table_names[i] + "'data-request-url='" + _base_path + "/json/common/showCreateTable.json'>" +
                                        _table_names[i] + "</a></span>";
                            }
                            html += "</caption>";
                        }

                        html += "<thead><tr>";

                        var _fieldNames = _result.fieldNames;
                        var fieldNameLen = $(_fieldNames).length
                        if(fieldNameLen > 0){
                            for(var i = 0; i < fieldNameLen; ++i){
                                html += "<td align='center' style='color:green;'>" + _fieldNames[i] + "</td>";
                            }
                            html += "</tr></thead>";
                        }
                        html += "<tbody>";
                        var _db_records = _result.dbRecords.result;
                        var _db_records_len = $(_db_records).length;
                        if(_db_records_len > 0){
                            for(var j = 0; j < _db_records_len; ++j){
                                html += "<tr>";
                                var _db_fields = _db_records[j].dbFieldVoList;
                                var _db_fields_len = $(_db_fields).length;
                                if(_db_fields_len > 0){
                                    for(var f = 0; f < _db_fields_len; ++f){
                                        html += "<td align='center'>" + _db_fields[f].value + "</td>";
                                    }
                                }
                                html += "</tr>";
                            }
                        }
                        html += "<tbody></table>";
//                                alert(html);
                        $(_target).html(html);
                    }

                }
            }
        });
    });

});