function checkPassword() {
    var password, password2;
    password = actionForm2.password.value;
    password2 = actionForm2.password2.value;
    if (password2 == 0) {
        document.getElementById("s_password2").innerHTML = "请再次输入密码!";
        document.getElementById("s_password2").style.color='red';
        return false
    }
    if (password != password2) {
        document.getElementById("s_password2").innerHTML = "两次输入密码不一致!";
        document.getElementById("s_password2").style.color='red';
        return false;
    }
    document.getElementById("s_password2").innerHTML = "&nbsp";
}

function checkPasswordValid() {
    var password, password2;
    password = actionForm2.password.value;
    password2 = actionForm2.password2.value;
    if (password == 0) {
        document.getElementById("s_password").innerHTML = "请输入密码!";
        document.getElementById("s_password").style.color='red';
        return false
    }
    if (password.length < 6) {
        document.getElementById("s_password").innerHTML = "密码不能少于六位!";
        document.getElementById("s_password").style.color='red';
        return false;
    }
    if (password2 != "") {
        if (password != password2) {
            document.getElementById("s_password").innerHTML = "两次输入密码不一致!";
            document.getElementById("s_password").style.color='red';
            return false;
        }
    }
    document.getElementById("s_password").innerHTML = "&nbsp";
}

function check() {
    var username;
    username = actionForm2.username.value;
    if (username.length == 0) {
        alert('用户名不能为空');
        document.getElementById("s_username").innerHTML = "用户名不能为空";
        document.getElementById("s_username").style.color='red';
        return false;
    }
    var letters = '!#$%^&*()';
    for (var i = 0; i < username.length; i++) {
        var char = username[i];
        if (letters.indexOf(char) > -1) {
            document.getElementById("s_username").innerHTML = "用户名中有非法字符";
            document.getElementById("s_username").style.color='red';
            return false;
        }
    }
    document.getElementById("s_username").innerHTML = "&nbsp";
}
$(function() {
    $("#create").click(function() {
        check_register();
        return false;
    })
    $("#login").click(function() {
        check_login();
        return false;
    })
    $('.message a').click(function() {
        $('form').animate({
            height: 'toggle',
            opacity: 'toggle'
        }, 'slow');
    });
})

function isEmail() {
    var email = actionForm2.email.value;
    apos = email.indexOf("@")
    dotpos = email.lastIndexOf(".")
    if (apos < 1 || dotpos - apos < 2) {
        document.getElementById("s_email").innerHTML = "邮箱格式不正确";
        document.getElementById("s_email").style.color='red';
        return false
    } else {
        document.getElementById("s_email").innerHTML = "&nbsp";
        return true; }
}

$(function () {
    //为username绑定失去焦点事件
    $("#username").blur(function () {
        // //获取文本框内容
        var s_number = $(this).val();
        $.get("studentCheck",{s_number:s_number},function (data) {
            //获取要输出到页面位置
            // var span = $("#s_username");
            //判断是否有相应值
            if (data.studentExist){
                document.getElementById("s_username").innerHTML = "&nbsp";
            }else {
                // span.html("&nbsp");
                document.getElementById("s_username").innerHTML = "用户名不存在";
                document.getElementById("s_username").style.color='red';
            }
        },"json");
    });
});
