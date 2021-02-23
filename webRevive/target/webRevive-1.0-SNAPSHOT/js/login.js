function login(form) {
    //校验用户密码，如果不通过，提示
    if(form.oninvalid){
        //alert("用户名为空");
        return false;
    }
$.ajax({
    url:"../data/login.ok.json",
    type:"POST",
    success:function (r) {
        if(r.ok){
            alert("登陆成功，跳转页面")
        }else {//提示错误码和错误消息
            alert("错误码："+r.code+"\n错误消息："+r.msg)
            $("#login_error").html(r.msg)

        }


    }
})

//     //校验通过，表单提交
//     var xhr = new XMLHttpRequest();
//
//     xhr.onload = function () {
//         // 输出接收到的文字数据
//         alert(xhr.responseText)
//         //ocument.getElementById("demo").innerHTML=xhr.responseText;
//     }
//
//     xhr.onerror = function () {
//         alert("请求出错")
//         //document.getElementById("demo").innerHTML="请求出错";
//     }
//
//
// // 发送异步POST 请求,第三个参数async:是否发起异步请求
//     xhr.open("POST", "../data/login.ok1.json", true);
//     xhr.send();
    return  false;
}