import ItemsController from "./itemsController.js";
function addItemCard(items) {
  const pro1 = document.getElementById("list-items");

  console.log(items.length);

  let innerhtml = "";
  for (let item of items) {
    innerhtml += `<div class="col-4 mt-1 "> <div class="card" style="width: 18rem;">
        <img src="${item.productUrl}" class="card-img-top" alt="...">
        <div class="card-body">
          <h5 class="card-title">ID: ${item.id} ${item.description}</h5>

          <a href="#" class="btn btn-primary">Add</a>
        </div>
      </div></div>`;
  }
  console.log(innerhtml);
  pro1.innerHTML = innerhtml;
}

const productItems = new ItemsController();

//Sample data
// pro1.addItem("White T-shirt", "Classic White T-shirt $24.50", "./resources/images/White T-shirt.png", "2022-2-2")
// pro1.addItem("Blue T-shirt", "Women Navy Blue T-shirt $22.99","./resources/images/Blue T-shirt.png", "2022-2-2" );
// pro1.addItem("Grey T-shirt", "Women Light Grey T-shirt $22.99","./resources/images/Grey T-shirt.png", "2022-2-2" );
// pro1.addItem("Red T-shirt", "Men Slim-Fit Red T-shirt $24.50","./resources/images/Red T-shirt.png", "2022-2-2" );
// pro1.addItem("Pink T-shirt", "Children Cotton Pink T-shirt $15.99","./resources/images/Pink T-shirt.png", "2022-2-2" );

async function loadItems() {
  try {
    const newController = await productItems.getItem();
    console.log(newController);
    await addItemCard(newController);
  } catch (e) {
    console.log(e);
  }
}

loadItems();
