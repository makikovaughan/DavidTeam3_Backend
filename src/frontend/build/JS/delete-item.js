import ItemsController from "./itemsController.js";

const form = document.getElementById("product-form");

let deletedProduct = new ItemsController();

function deleteProduct(event) {
  event.preventDefault();
  deletedProduct.delete(Number(form[0].value));
  form[0].value = "";
}
form.addEventListener("submit", deleteProduct);
