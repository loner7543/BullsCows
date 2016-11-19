/**
 * Created by sss on 19.11.16.
 */
var  Url = "registration"
function SendData(){
    var  userName = document.getElementById("userName").value;
    var  password = document.getElementById("userPassword").value;
    var  retypePassword = document.getElementById("retypePassword").value;
    if(password!=retypePassword){}
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
                //location.reload();
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }

        });
    }

}

function onClear(){}