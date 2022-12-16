//import addItemCard from "./items.js";
export default class ItemsController {
  constructor(currentId = 0) {
    this.items = [];
    this.currentId = currentId;
    this.localStorageItems = [];
  }

  addItem(name, description, img, createdAt) {
    this.currentId++;
    const newItem = {
      id: 0,
      itemName: "",
      description: "",
      productUrl: "",
      createdAt: "",
    };
    newItem.id = this.currentId;
    newItem.itemName = name;
    newItem.description = description;
    newItem.productUrl = img;
    newItem.createdAt = createdAt;
    this.items.push(newItem);
    localStorage.setItem("items", JSON.stringify(this.items));
    this.save(newItem.itemName, newItem.description, newItem.productUrl);
  }

  loadItemsFromLocalStorage() {
    const storageItems = localStorage.getItem("items");
    console.log("Storage items: " + storageItems);
    if (storageItems) {
      const gen = JSON.parse(storageItems);

      console.log(gen);
      //TODO load the items into the local items structure (this.items)
      for (let i = 0; i < gen.length; i++) {
        const shirt = gen[i];
        console.log(shirt);
        this.localStorageItems.push(shirt);
      }
      console.log(this.localStorageItems);
    }
  }

  //Add a new item
  save(itemName, description, productUrl) {
    const data = { itemName, description, productUrl };

    fetch("http://localhost:8080/item", {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Success:", data);
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  }

  async update(itemID, itemName, description, productUrl) {
    try {
      const data = { itemName, description, productUrl };
      const response = await fetch(`http://localhost:8080/item/${itemID}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });
      const updatedItem = await response.json();
      return updatedItem;
      throw new Error("Request failed.");
    } catch (e) {
      console.log(e);
    }
  }

  async findById(itemId) {
    try {
      const response = await fetch(`http://localhost:8080/item/${itemId}`);
      if (response.ok) {
        const foundItem = await response.json();
        return foundItem;
      }
      throw new Error("Request failed.");
    } catch (e) {
      console.log(e);
    }
  }

  //Display all items from the DB
  async getItem() {
    try {
      const response = await fetch("http://localhost:8080/item/all");
      if (response.ok) {
        const itemsArr = await response.json();
        return itemsArr;
      }
      throw new Error("Request failed");
    } catch (error) {
      console.log(error);
    }
  }

  //Delete the item
  async delete(itemId) {
    try {
      const response = await fetch(`http://localhost:8080/item/${itemId}`, {
        method: "DELETE",
      });
      const deletedItem = await response.json();
      return deletedItem;
      throw new Error("Request failed.");
    } catch (e) {
      console.log(e);
    }
  }
}
