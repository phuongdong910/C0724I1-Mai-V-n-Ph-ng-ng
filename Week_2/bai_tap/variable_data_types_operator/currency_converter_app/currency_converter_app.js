function ChangeMoney() {
    let Amount = document.getElementById("Amount").value;
    let From = document.getElementById("From").value;
    let To = document.getElementById("To").value;
    let Result;


    if (From === "USD" && To === "VND") {
        Result = "Result: " + (Amount * 25000) + " Đ";
    }
        else if (From === "VND"&& To === "USD"){
        Result = "Result: "+ (Amount / 25000) + " $";
    }
                 else if (From === "VND") {
                 Result = "Result: " + Amount + " Đ"
    }
                       else {
                          Result = "Result: " + Amount + " $"
    }

    document.getElementById("Result").innerHTML = Result;
}
