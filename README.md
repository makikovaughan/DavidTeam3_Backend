# DavidTeam3_Backend

This is the backend of GenTee Project.

## Overview

### Front-End
#### src/frontend/build
index.html: Main page <br>
item-form.html: Add a new item form <br>
itemById.html: Search based on the ID.<br>
product.html: Displays all products dynamically from the DB. <br>
update-form.html: Update the product information. <br>
delete.html: Delete the product.<br>
about.html: Explains about us. <br>
contact.html: Contact form. <br>

#### src/frontend/build/JS
index.js: Main JS file<br>
delete-item.js: Called when the delete button is clicked. <br>
item-form.js: Called when the submit button is clicked. <br>
itemById.js: Called when the search button is clicked.<br>
item.js: Declares all instances.<br>
update-forms.js: Called when update button is clicked. <br>
itemController.js: Manage all CRUD operations.<br>

### Back-End
controller/dto/ItemDto.java - This class is for the Data Transfer Objects used to map the JSON data structure sent and received by the REST controller.

controller/ItemController.java - This class is responsible for processing incoming REST API requests, preparing a model, and returning the view to be rendered as a response.

control/ItemModelAssembler.java - This class provides methods to convert a domain object into a RepresentationModel.

repository.entity/item.class - This class is the entity of table, item. 

repository.entity/ItemRepository - This class determines how to use the model to interact with the database.

service/ItemNotFoundException.java - This class is for an exception used to indicate when an item is looked up but not found.

service/ItemNotFoundAdvise.java - When an EmployeeNotFoundException is thrown, this extra tidbit of Spring MVC configuration is used to render an HTTP 404.

service/ItemService.java - This class is for putting in designated areas of adding business functionalities.

resources/application.properties - Added the setup of the DB.


## Description
The backend is used Java and Spring Boot to manipulate data and MySQL.


