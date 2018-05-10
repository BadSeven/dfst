var url = "";
var newlist = ""
$(document).ready(function () {
    $.ajax({
        type: "POST",
        dataType: "json",
        contentType: "application/json",
        url: "/getallNewList",
        success: function (result) {
            console.log(result)
            var data = result.data;
            for (var i = 0; i < data.length; i++) {
                console.log(url);
                newlist += " <li>" +
                    "<a href='article_con?id="+data[i].id+"'>" +
                    "<div class=\"tim\" style=\"background-color: rgb(238, 238, 238);\"><p style=\"font-size: 46px; font-family: Arial; color: rgb(136, 136, 136);\">" + (i + 1) + "</p><p style=\"color: rgb(136, 136, 136);\">" + data[i].createtime.substring(0, 10) + "</p></div>" +
                    "    <div class=\"con\">" +
                    "    <p style=\"font-size: 14px; color: rgb(0, 102, 204);\">" + data[i].title + "</p>\n" +
                    "    <p style=\"color:#999; margin-top:9px; line-height:180%;\">" + data[i].content.substring(0, 100) + "</p>"
                "    </div>" +
                "      </a>" +
                "    </li>"
            }
            console.log(newlist);
            $("#newList").append(newlist);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            var resultJson = eval('(' + XMLHttpRequest.responseText + ')');

        }
    })


})