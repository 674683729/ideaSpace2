$(function () {
    $.ajaxSetup({
        beforeSend:function(xhr) {
            var v_token = $.cookie("fh_token");
            xhr.setRequestHeader("x-token",v_token);
        },
    })
});

//设置cookie
function setCookie(value){
    document.cookie = "key" + "=" + value;
    //escape方法的作用是进行编码，主要防止value中有特殊字符
}

//获取cookie
function getCookie(name){
    var reg = RegExp(name+'=([^;]+)');
    var arr = document.cookie.match(reg);
    if(arr){
        return unescape(arr[1]);
    }else{
        return '';
    }
}