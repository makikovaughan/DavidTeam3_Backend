import ItemsController from "./itemsController.js";

let idProduct = new ItemsController();
let form = document.getElementById("product-form");

async function findByIdProduct(event) {
  event.preventDefault();
  const returnedValue = await idProduct.findById(Number(form[0].value));
  console.log(returnedValue);
  form[0].value = returnedValue.id;
  form[1].value = returnedValue.itemName;
  form[2].value = returnedValue.description;
  form[3].value = returnedValue.productUrl;
}

form.addEventListener("submit", findByIdProduct);
