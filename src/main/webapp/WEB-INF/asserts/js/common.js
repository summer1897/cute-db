
/**
 * Created by summer on 16/6/15.
 */
$(function() {

    /**
     * 判断元素是否为空
     * @param data
     * @returns {boolean}
     */
    function isNotEmpty(data){

        if(undefined === data || null == data)
            return false;

        return data.length > 0;
    }

    /**
     * 解析参数
     * @param params
     */
    function resolveParams(param,delimiter){
        var result = "";

        if(!isNotEmpty(param))
            return result;

        if(!isNotEmpty(delimiter))
            delimiter = ';';

        var params = param.split(delimiter);
        for(var i = 0; i < params.length - 1; ++i){
            result += getParam(params[i]) + '&';
        }

        var lastParam = getParam(params[params.length - 1]);
        if(isNotEmpty(lastParam)) {
            result += lastParam;
        }else{//若果最后个参数不存在,去掉最后的&符号
            var index = result.lastIndexOf("&");
            result = result.substr(0,index);
        }
        return result;
    }

    /**
     * 获取指定ID的参数值
     * @param param
     * @returns {*}
     */
    function getParam(param){
        var value = $(param).val();
        var paramName = $(param).attr('name');
        if(isNotEmpty(value) && isNotEmpty(paramName))
            return paramName + "=" + value;
        return "";
    }

    function normalizeTarget(target){
        var index = target.indexOf('#');
        if(-1 == index)
            return '#' + target;
        return target;
    }

    $(document).on('click',"a[data-asyn-load='true']",function(){
        var paramStr = resolveParams($(this).attr("data-params"));
        // encodeURIComponent(paramStr);
        // alert(paramStr);
        //转义空格字符
        paramStr = paramStr.replace(/\s/g,"%20");
        var requestURL  = $(this).attr("data-request-url");
        if(isNotEmpty(paramStr)){
            requestURL += "?" + paramStr;
        }
         // alert(requestURL);
        //alert(normalizeTarget($(this).attr("target")));
        $(normalizeTarget($(this).attr("target"))).load(requestURL);
    });

});
