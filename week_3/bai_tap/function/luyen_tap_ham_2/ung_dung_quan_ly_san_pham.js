let productList = ["Samsung S23", "Xiaomi", "Redmi Pro", "Nokia", "Iphone13 ProMax "];

function showListProduct() {
    let text = "";
    productList.forEach((item, index) => {

        text += "<tr>";
        text += "<td>";
        text += index + 1;
        text += "</td>";

        text += "<td>";
        text += item;

        text += "</td>";
        text += "<td>";
        text += `<button class="btn-delete" onclick="deleteProduct(${index})"> Delete</button>`;
        text += "</td>";
        text += "<td>";
        text += `<button class="btn-update" onclick="updateProduct(${index})"> Update</button>`;


        text += "</td>";
        text += "</tr>";

    })
    document.getElementById("list-product").innerHTML = text;
}

showListProduct();

function addProduct() {

    let nameProduct = document.getElementById("name-product").value;
    if (nameProduct) {
        productList.push(nameProduct);
        showListProduct();
        document.getElementById("name-product").value = "";
    } else {
        alert("Thêm nameProduct vào");
    }
}

function deleteProduct(index) {

    if(confirm("Are you sure you want to delete")){
        productList.splice(index,1);
        showListProduct();
    }
}

function updateProduct(index) {

    let product = productList[index];

    document.getElementById("name-product").value = product;

    document.getElementById("id-product").value = index;

}

function editProduct() {

    let index = document.getElementById("id-product").value;

   let nameProduct = document.getElementById("name-product").value;
   productList[index] = nameProduct;

    showListProduct();

}
