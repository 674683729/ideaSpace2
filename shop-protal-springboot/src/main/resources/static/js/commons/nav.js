var loginStatus = false;//登录状态

//导航条
var v_nav = '<nav class="navbar navbar-inverse">\n' +
    '    <div class="container-fluid">\n' +
    '        <!-- Brand and toggle get grouped for better mobile display -->\n' +
    '        <div class="navbar-header">\n' +
    '            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">\n' +
    '                <span class="sr-only">Toggle navigation</span>\n' +
    '                <span class="icon-bar"></span>\n' +
    '                <span class="icon-bar"></span>\n' +
    '                <span class="icon-bar"></span>\n' +
    '            </button>\n' +
    '            <a class="navbar-brand" href="/">欢乐购-全球第一购物平台</a>\n' +
    '        </div>\n' +
    '\n' +

    '        <!-- Collect the nav links, forms, and other content for toggling -->\n' +
    '        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">\n' +
    '            ' +
    '           <ul class="nav navbar-nav">\n' +
    '                <li><a href="/">首页</a></li>\n' +
    '            </ul>\n' +
    '           <ul class="nav navbar-nav navbar-right" id="memberInfo">\n' +
    '                <li><a href="#" onclick="login()">登录</a></li>\n' +
    '                <li><a href=/registerMember.html>注册</a></li>\n' +
    '            </ul>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</nav>';


$("#nav_html").html(v_nav);


var v_loginBootbox = '<div type="centen">\n' +
    '    <!-- Nav tabs -->\n' +
    '    <ul class="nav nav-tabs" role="tablist">\n' +
    '        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">会员账号登陆</a></li>\n' +
    '        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">手机免密登陆</a></li>\n' +
    '    </ul>\n' +
    '\n' +
    '    <!-- Tab panes -->\n' +
    '    <div class="tab-content">\n' +
    '        <div role="tabpanel" class="tab-pane active" id="home">\n' +
    '           <form  class="form-horizontal" >\n' +
    '               <div class="form-group">\n' +
    '                   <label class="col-sm-2 control-label">会员名</label>\n' +
    '                   <div class="col-sm-5">\n' +
        '                   <input type="text" class="form-control" id="memberName" placeholder="请输入会员名...">\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '               <div class="form-group">\n' +
    '                   <label class="col-sm-2 control-label">密码</label>\n' +
    '                   <div class="col-sm-5">\n' +
    '                       <input type="password" class="form-control" id="password" placeholder="请输入密码...">\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '               <div class="form-group">\n' +
    '                   <div class="col-sm-offset-2 col-sm-10">\n' +
    '                       <button class="btn btn-primary" type="button" onclick="memberLogin()"><i class="glyphicon glyphicon-user"></i>登录</button>\n' +
    '                       <button type="reset" class="btn btn-primary"><i class="glyphicon glyphicon-erase"></i>重置</button>\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '            </form>\n' +
    '        </div>\n' +
    '        <div role="tabpanel" class="tab-pane" id="profile">\n' +
    '           <form id="add_form" class="form-horizontal" role="form">\n' +
    '               <div class="form-group">\n' +
    '                   <label class="col-sm-2 control-label">手机号</label>\n' +
    '                   <div class="col-sm-6">\n' +
    '                       <div class="input-group">\n' +
    '                           <input type="text" class="form-control" onchange="checkPhone()" id="phone" placeholder="请输入手机号...">\n' +
    '                           <span class="input-group-btn">\n' +
    '                           <button class="btn btn-info" onclick="postPhoneCode()" id="postSMSBtn"  type="button">发送验证码</button>\n' +
    '                           </span>\n' +
    '                       </div>\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '               <div class="form-group">\n' +
    '                   <label class="col-sm-2 control-label">验证码</label>\n' +
    '                   <div class="col-sm-4">\n' +
    '                       <input type="password" class="form-control" id="smsCode" placeholder="请输入验证码...">\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '                   <div class="form-group">\n' +
    '                   <div class="col-sm-offset-2 col-sm-10">\n' +
    '                       <button class="btn btn-primary" type="button" onclick="phoneLogin()"><i class="glyphicon glyphicon-phone"></i>登录</button>\n' +
    '                       <button type="reset" class="btn btn-primary"><i class="glyphicon glyphicon-erase"></i>重置</button>\n' +
    '                   </div>\n' +
    '                </div>\n' +
    '            </form>\n' +
    '        </div>\n' +
    '    </div>\n' +
    '</div>';


/*
var v_loginHtml = '<!-- 登陆form表单 -->\n' +
    '    <form id="add_form" class="form-horizontal" role="form">\n' +
    '        <div class="form-group">\n' +
    '            <label class="col-sm-2 control-label">会员名</label>\n' +
    '            <div class="col-sm-4">\n' +
    '                <input type="text" class="form-control" id="memberName" placeholder="请输入会员名...">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '        <div class="form-group">\n' +
    '            <label class="col-sm-2 control-label">密码</label>\n' +
    '            <div class="col-sm-4">\n' +
    '                <input type="password" class="form-control" id="password" placeholder="请输入密码..">\n' +
    '            </div>\n' +
    '        </div>\n' +
    '    </form>'
*/



/*全局ajax 传头部信息*/
$.ajaxSetup({
    beforeSend:function(xhr) {
        var v_token = $.cookie("fh_token");
        xhr.setRequestHeader("x-token",v_token);
        /*var token = $.cookie("token");
        xhr.setRequestHeader("token",token);*/
    },
})


$(function () {
    findMemberInfo();//登陆后展示的会员信息
});

function phoneLogin() {
    var phone = $('#phone').val();
    var smsCode = $('#smsCode').val();
    $.ajax({
        url:"http://localhost:8081/members/smsLogin",
        type:"post",
        data:{"phone":phone,"smsCode":smsCode},
        success:function (res) {
            if (res.code == 200) {
                //登陆成功
                loginStatus = true;
                var data = res.data;
                $.cookie("fh_token",data);
                if(buyProductId){
                    //加入购物车 跳到购物车
                    addCart(buyProductId);
                }else{
                    location.reload();
                }
            }else {
                /*bootbox.alert({
                    message:"失败:"+res.msg,
                    size:"small",
                })*/
                alert(res.msg)
            }
        },
        error:function (res) {
            alert("请求失败");
        }
    })

}

//手机短信验证
function postPhoneCode() {
    var v_phone = $("#phone").val();
    if (v_phone.length != 11) {
        alert("请输入正确手机号")
        return  ;
    }
    $.ajax({
        url:"http://localhost:8081/sms?phone="+v_phone,
        type:"get",
        success:function (res) {
            if (res.code == 200) {
                //发送成功
                btnDisabled();
            }else {
                /*bootbox.alert({
                    message:"失败:"+res.msg,
                    size:"small",
                })*/
                alert(res.msg)
            }
        },
        error:function (res) {
            alert("请求失败");
        }
    })
}

//手机号验证
function checkPhone() {
    var phone = $("#phone").val();
    if(phone.length > 10){
        $.ajax({
            url:"http://localhost:8081/members/phone",
            type:"get",
            data:{"phone":phone},
            success:function (res) {
                if (res.code != 200) {
                    $("#postSMSBtn").text("手机未注册");
                    $("#postSMSBtn").attr("onclick","null");//按钮失效
                } else{
                    //手机未注册
                    $("#postSMSBtn").text("发送短信");
                    $("#postSMSBtn").attr("onclick","null");//按钮有效
                }
            }

        })
    }

}

//发送短信按钮失效
var i = 60;
function btnDisabled() {
    $("#postSMSBtn").attr("onclick","null");//按钮失效
    $("#postSMSBtn").text(--i+"秒后重新发送");
    var timeout = setTimeout(function(){btnDisabled()},1000);
    if (i == 0) {
        $("#postSMSBtn").attr("onclick","postPhoneCode()");//按钮生效
        $("#postSMSBtn").text("发送验证码");
        i=60;
        clearInterval(timeout);//清除定时器
    }
}

//会员账户登陆
function memberLogin() {
    var memberName = $("#memberName",login_dialog).val();
    var password = $("#password",login_dialog).val();
    $.ajax({
        url: "http://localhost:8081/members/login",
        data:{memberName:memberName, password:password},
        type:"post",
        backdrop:false,
        success: function (res) {
            if(res.code==200){
                loginStatus = true;
                var data = res.data;
                $.cookie("fh_token",data);
                if(buyProductId){
                    //加入购物车 跳到购物车
                    addCart(buyProductId);
                }else{
                    location.reload();
                }
            }else{
                bootbox.alert({
                    message:res.msg,
                    size:"small",
                    backdrop:false,
                })
            }
        }
    })
}

//登陆后展示的会员信息
var navHtml = '';
function findMemberInfo() {
    $.ajax({
        url:"http://localhost:8081/members/findMember",
        type:"get",
        async:false,
        success:function (res) {
            if (res.code == 200) {
                navHtml += '<li><a>欢迎'+res.data+'登录</a></li>';
                navHtml += '<li><a href="javaScript:to()">个人中心</a></li>';
                navHtml += '<li><a href="cart.html">我的购物车</a></li>';
                navHtml += '<li><a href="javaScript:logout()">退出</a></li>';
                $("#memberInfo").html(navHtml);
                //代表登陆
                loginStatus=true;
            }else{
                //无用户登录
                navHtml += '<li><a href="javaScript:login()">登录</a></li>';
                navHtml += '<li><a href="registerMember.html">注册</a></li>';
                navHtml += '<li><a href="cart.html">我的购物车</a></li>';
                $("#memberInfo").html(navHtml);
            }
        },
    })
}


//退出
function logout() {
    bootbox.confirm({
        message: "确定退出！",
        size:"small",
        backdrop:false,
        buttons: {
            confirm: {
                label: '取消',
                className: 'btn-success'
            },
            cancel: {
                label: '确定',
                className: 'btn-danger'
            }
        },
        callback:function (res) {
            if (!res) {
                $.ajax({
                    url:"http://localhost:8081/members/logout",
                    type:"post",
                    success:function (res) {
                        if (res.code == 200) {
                            $.removeCookie("fh_token");
                            location.reload();
                        }
                    },
                    error:function (res) {
                        alert("退出请求失败");
                    }
                })
            }
        }
    })
}

//登陆的ajax
var login_dialog;
var buyProductId;
function login(id) {
    buyProductId=id;
    login_dialog = bootbox.dialog({
        title:"会员登录",
        message:v_loginBootbox,
        backdrop:false,
        /*buttons:{
            cancel:{
                label:"<i class='glyphicon glyphicon-remove'>取消</i>",
                className:"btn-info"
            },
            add:{
                label:"<i class='glyphicon glyphicon-plus'>登陆</i>",
                className:"btn-danger",
                callback:function (result) {

                }
            },
        }*/
    });


}

