/**
 * Created by sss on 20.11.16.
 */
Url="check-user"

function signIn() {
    var name = document.getElementById("name").value;
    var pass =document.getElementById("pass").value;
    var data = {
        login: name,
        password: pass
    };
    $.ajax({
        url: Url,
        data: JSON.stringify(data),
        type: 'POST',
        dataType: "json",
        contentType: 'application/json', //charset=utf-8,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            //location.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            if(jqXHR.status==200)
            {
                window.location = "http://localhost:8081/show"
            }
            else{
                window.location = "http://localhost:8081/showRegistrationFom"
            }
        }

    });
}

