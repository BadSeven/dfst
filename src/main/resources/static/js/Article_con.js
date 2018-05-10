var id = GetQueryString('id');
$(document).ready(function () {
    $.ajax({
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        url: "/getNewById?id=" + id,
        success: function (result) {
            console.log(result)
            var data = result.data;
            $("#title").html(data.title);
            $("#p1").html(Format("发布时间:"+new Date(data.createtime),"yyyy-MM-dd hh:mm:ss"));
            $("#content").html(data.content);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            var resultJson = eval('(' + XMLHttpRequest.responseText + ')');

        }
    })


})

function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

