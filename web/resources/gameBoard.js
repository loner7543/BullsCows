/**
 * Created by Александр on 17.11.2016.
 */

var sendUrl = "Attempt";
var validateRES = false;

function userAttempt(){
    var digitHTML = document.getElementById("userDigit");
    var text = digitHTML.value;
    validate(text);


}

function validate(text){
    if(text.length!=4){
        alert("Введенное число должно быть четырехзначным");
        validateRES = false;
    }
    else {validateRES = true;
        Send(text);
    }
}

function Send(text) {
    var data = {
        userDigit: text
    };
    $.ajax({
        url: sendUrl,
        data: JSON.stringify(data),
        type: 'POST',
        //dataType: "json",
        contentType: 'application/json', //charset=utf-8,
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            location.reload();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(errorThrown);
        }

    });
}
