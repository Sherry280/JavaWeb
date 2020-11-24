function load() {
        alert('OK');
}
$(function () {
        alert("Ok");
        let data={
                username:"abc",
                password:"123"
        }
        $.ajax({
                type: "POST",//请求的方法
                url: "data/login.json",//请求的路径
                contentType:"application/json",//请求的数据类型
                data: JSON.stringify(data),//请求的数据，如果类型是json，需要将json转为字符串
                success: function(r){
                        alert(JSON.stringify(r) );
                },
                error:function (XMLHttpRequest, textStatus, errorThrown) {
                        // 通常 textStatus 和 errorThrown 之中
                        // 只有一个会包含信息
                        this; // 调用本次AJAX请求时传递的options参数
                }
        });

});