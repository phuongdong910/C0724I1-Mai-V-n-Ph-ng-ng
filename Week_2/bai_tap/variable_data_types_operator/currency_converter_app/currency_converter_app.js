function changeMoney() {
    let amount = document.getElementById("amount").value;
    let from = document.getElementById("from").value;
    let to = document.getElementById("to").value;
    let result;


    if (from === "USD" && to === "VND") {
        result = "Result: " + (amount * 25000) + " Đ";
    } else if (from === "VND" && to === "USD") {
        result = "Result: " + (amount / 25000) + " $";
    } else if (from === "VND") {
        result = "Result: " + amount + " Đ"
    } else {
        result = "Result: " + amount + " $"
    }

    document.getElementById("result").innerHTML = result;
}
