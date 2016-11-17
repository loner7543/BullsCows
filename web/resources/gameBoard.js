/**
 * Created by Александр on 17.11.2016.
 */

var sendUrl = "";
var validateRES = false;
function click(){
    alert('ewd');
}

function userAttempt(){
    var digitHTML = document.getElementById("userDigit");
    var text = digitHTML.value();
    validate(text);
    if(validateRES){
        var xhr = new XMLHttpRequest();
        xhr.open("POST",sendUrl);
        xhr.send(text);
    }


}

function validate(text){
    if(text.length!=4){
        alert("Введенное число должно быть четырехзначным");
    }
    else validateRES = true;
}
