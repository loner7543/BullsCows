/**
 * Created by sss on 19.11.16.
 */
var  Url = "registration"
function SendData(){
    var f = 5;
    var  userName = document.getElementById("userName").value;
    var  password = document.getElementById("userPassword").value;
    var  retypePassword = document.getElementById("retypePassword").value;
    if(password!=retypePassword){
        alert("Пароли не совпадают");
    }
    else {
        var data = {
            login: userName,
            pass:password
        };
        $.ajax({
            url: Url,
            data: JSON.stringify(data),
            type: 'POST',
            //dataType: "json",
            contentType: 'application/json', //charset=utf-8,
            success: function (data, textStatus, jqXHR) {
                console.log(data);
                if(jqXHR.status==200)
                {
                    window.location = "http://localhost:8081/show"
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }

        });
    }

}

function onClear(){}