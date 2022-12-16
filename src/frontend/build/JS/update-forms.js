import ItemsController from "./itemsController.js";

let updatedProduct = new ItemsController();
const form = document.getElementById("product-form");

function updateProduct(event) {
  event.preventDefault();
  console.log(form[0].value, form[1].value, form[2].value, form[3].value);
  const time = new Date();
  updatedProduct.update(
    Number(form[0].value),
    form[1].value,
    form[2].value,
    form[3].value,
    time
  );
  form[0].value = "";
  form[1].value = "";
  form[2].value = "";
  form[3].value = "";
}
form.addEventListener("submit", updateProduct);
