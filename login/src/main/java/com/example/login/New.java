package com.example.login;
//  IIT Student  Number =20221076
// RGU Student Number = 2313472
//Student Name = P.L.T Chandrasekara
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.Collections;


/* AID -> adding Items
DID -> Delete Items
 UID -> Update Items
 SID -> Save Items Details To Txt File
 SDD -> Selecting Four Dealers Randomly From a File
 VRL -> Display All The Details of The Randomly Selected Dealers
 LDI -> Display All The Items of The Given Dealer
 ESC -> Exit The Program
 */


public class New {
    private Stage stage;

    private Scene scene;

    static ArrayList<Item> itemList = new ArrayList<>();/*this has to be static otherwise there wont pass the same list to the other functions instance same value ekama thama yanne*/

    // Text Fields
    @FXML
    private TextField indexField; //Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField nameField;//Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField brandField;//Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField priceField;//Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField quantityField;//Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField categoryField;//Uses For AID, UID, DID, VID And SID
    @FXML
    private TextField purchDateField;//Uses For AID, UID, DID, VID And SID

    @FXML
    private TextField indexToDeleteField; //Uses For DID Part
    @FXML
    private TextField indexToUpdateField; //User For UID Part
    @FXML
    private TextField inputDealerNameField; //Uses For LID Part
    //Labels
    @FXML
    private Label validationLabel; //All The Error Messages Are Shows In These ValidationLabel
    @FXML
    private  Label validationLabel1; // Validations errors shows in here
    //Tables
    @FXML
    private TableView tableView; //For Show The Item Details In VID Part
    @FXML
    private TableView tableView1;//For Show The SDD Part

    @FXML
    private TableView tableView2;//Select For The VRL Part
    @FXML
    private TableView tableView3; //Select For The LDI Part
    @FXML
    private TableView tableView4;// To Show The Indexes Currently In The System In The UID Part
    // Table Columns
    @FXML
    private TableColumn<Item, Integer> indexColumn;//To insert the data into index column in UID part and Display Index in VID Part
    @FXML
    private TableColumn<Item,Integer>index1Column;//To display the Indexes in UID Part
    @FXML
    private TableColumn<Item, String> nameColumn;//To insert the data into name column in UID part and Display name in VID Part
    @FXML
    private TableColumn<Item, String> brandNameColumn;//To insert the data into Brand Name column in UID part and Display Brand Name in VID Part
    @FXML
    private TableColumn<Item, Float> priceColumn;//To insert the data into Item Price column in UID part and Display Item Price in VID Part
    @FXML
    private TableColumn<Item, Integer> quantityColumn;//To insert the data into index column in UID part and Display Index in VID Part
    @FXML
    private TableColumn<Item, String> categoryColumn;//To insert the data into index column in UID part and Display Index in VID Part
    @FXML
    private TableColumn<Item, Integer> purchasedDateColumn;//To insert the data into purchased Date column in UID part and Display purchased Date in VID Part
    @FXML
    private TableColumn<Dealer, String> dealerColumn;//When 4 Dealers Are Selected This Will Display The Dealer Name in SDD Part
    @FXML
    private TableColumn<Dealer, String> contactNoColumn;//When 4 Dealers Are Selected This Will Display The Contact No in SDD Part
    @FXML
    private TableColumn<Dealer, String> locationColumn;//When 4 Dealers Are Selected This Will Display The Location in SDD Part

    @FXML
    private TableColumn<Dealer, String> itemName1Column;//Display The Dealers First Item's Name in SDD Part
    @FXML
    private TableColumn<Dealer, String> itemName2Column;//Display The Dealers Second Item's Name in SDD Part
    @FXML
    private TableColumn<Dealer, String> itemName3Column;//Display The Dealers Third Item's Name in SDD Part
    @FXML
    private TableColumn<DealerItem, String> itemName4Column;//Display The DealerItems' Item Name in LDI Part

    @FXML
    private TableColumn<Dealer, String> itemBrand1Column; //Display The Dealers First Item's Brand Name in SDD Part
    @FXML
    private TableColumn<Dealer, String> itemBrand2Column;//Display The Dealers Second Item's Brand Name in SDD Part
    @FXML
    private TableColumn<Dealer, String> itemBrand3Column;//Display The Dealers Third Item's Brand Name in SDD Part
    @FXML
    private TableColumn<DealerItem, String> itemBrand4Column;//Display The DealerItems' Item Brand in LDI Part

    @FXML
    private TableColumn<Dealer, Float> itemPrice1Column; //Display The Dealers First Item's Price in SDD Part
    @FXML
    private TableColumn<Dealer, Float> itemPrice2Column;//Display The Dealers Second Item's Price in SDD Part
    @FXML
    private TableColumn<Dealer, Float> itemPrice3Column;//Display The Dealers Third Item's Price in SDD Part
    @FXML
    private TableColumn<DealerItem, Float> itemPrice4Column;// Display The DealerItems' Item Price in LDI Part

    @FXML
    private TableColumn<Dealer, Integer> itemQuantity1Column;//Display The Dealers First Item's Quantity in SDD Part
    @FXML
    private TableColumn<Dealer, Integer> itemQuantity2Column;//Display The Dealers Second Item's Quantity in SDD Part
    @FXML
    private TableColumn<Dealer, Integer> itemQuantity3Column;//Display The Dealers Third Item's Quantity in SDD Part
    @FXML
    private TableColumn<DealerItem, Integer> itemQuantity4Column;//Display The DealersItem' Quantity in SDD Part


    public void BacktoMain(ActionEvent event) throws IOException { // Creating an Action Event to go back to the main menu
        Parent root = FXMLLoader.load(getClass().getResource("menu.fxml"));//Load the menu.fxml file and stores the root node of the GUI in the variable Root
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();//Get the window of the program and store it in the variable "stage".
        stage.setTitle("Main Menu");//set the title of the page
        scene = new Scene(root);//create new scene with the root node as its content
        stage.setScene(scene);//set the created Scene as the scene to be displayed in the stage
        stage.show();//making the main menu visible
    }

    public Item findByindex(int index, ArrayList<Item> itemList) { //Method to find an item based on the index
        for (int i = 0; i < itemList.size(); i++) { //loop through each and every item in the itemList
            if (itemList.get(i).index == index) { //checks the current item index is equals to given index.
                return itemList.get(i);//return the item that found
            }
        }
        validationLabel.setText("Wrong Index");//if the given index is can't find in item list it will show this massage
        return null;//return null because this method is not void and needs to return a value.
    }

    public void AddItemToList(ActionEvent action) {
        Validations instance = new Validations(); // create an instances of the validations class to perform input validations
        int index = instance.int_validation(indexField, validationLabel1);// Perform integer validation form the indexField input, and store the value in the index variable.
        //System.out.println(index);
        String name = instance.naming_validation(nameField, validationLabel1);// Perform naming validation form the nameField input, and store the value in the name variable.
        //System.out.println(name);
        String brandName = instance.naming_validation(brandField, validationLabel1);// Perform naming_validation form the brandField input, and store the value in the brandName variable.
        //System.out.println(brandName);
        float price = instance.float_validation(priceField, validationLabel1);// Perform float validation form the priceField input, and store the value in the price variable.
        //System.out.println(price);
        int quantity = instance.int_validation(quantityField, validationLabel1);// Perform integer validation form the quantityField input, and store the value in the quantity variable.
        //System.out.println(quantity);
        String category = instance.string_validation(categoryField, validationLabel1);// Perform string validation form the categoryField input, and store the value in the category variable.
        //System.out.println(category);
        String purchasedDate = instance.date_string_validation(purchDateField, validationLabel1);// Perform date_string validation form the purchDateField input, and store the value in the purchasedDate variable.
        //System.out.println(purchasedDate);
        if ((index == 0 && name.equals("") && brandName.equals("") && price == 0 && quantity == 0 && category.equals("") && purchasedDate == null)){
            validationLabel1.setText("Enter Data to Add an Item"); //if the user entered with all the input fields empty it will display an error message
        }
        Boolean indexCheck = true; //boolean value to check the repeated index
        for (Item items : itemList) {//loop through itemlist to find the input index is exists in itemlist
            if (items.getIndex() == index) {
                indexCheck = false;//if the item exists then make indexCheck to False and display an error message
                validationLabel1.setText("Entered Index is In the List");
                break;
            }
        }   //checks the indexCheck is true and if all the fields are filled correctly
        if (indexCheck && !((index == 0 || name.equals("") || brandName.equals("") || price == 0 || quantity == 0 || category.equals("") || purchasedDate == null))) {
            validationLabel.setText("Details Added to the List!!!!");
            Item item = new Item(index, name, brandName, price, quantity, category, purchasedDate); //create a new Item
            itemList.add(item);//add created item to the itemList
            validationLabel1.setText("");
        } else {
            validationLabel.setText("There is An Error in Your Entered Data!!!!!"); //display the error message
        }
        //clear the Text Fields
        indexField.setText("");
        nameField.setText("");
        brandField.setText("");
        priceField.setText("");
        quantityField.setText("");
        categoryField.setText("");
        purchDateField.setText("");
    }

    public void deleteObject(ActionEvent event) {
        Validations instance = new Validations();// create instance to perform input validations
        int indexToDelete = instance.int_validation(indexToDeleteField, validationLabel1); //validate the indexToDeleteField and store the value in indexToDelete variable
        Object deleteObject = findByindex(indexToDelete, itemList);//calling findByindex to find the object within given  index
        System.out.println(deleteObject);

        if (!(deleteObject==null)) { //check if there is an object to that index if there is no object then display an error message
            itemList.remove(deleteObject);
            validationLabel.setText("Item was delete Successfully");
        } else {
            validationLabel.setText("Item not Found");
        }

    }

    private Item updateObject; //Creating an item object to hold the  updateObject

    public void setUpdateObject(Item updateObject) { // Method to set the updateObject Variable with the provided item object
        this.updateObject = updateObject;// Set the value of the updateObject to the provided item variable
        //System.out.println(updateObject);
    }

    public Item updateItem(ActionEvent event) {
        Validations instance = new Validations();
        int indexToUpdate = instance.int_validation(indexToUpdateField, validationLabel1);
        if(indexToUpdate== 0){

            validationLabel1.setText("Enter an Index to Update");
        }
        updateObject = findByindex(indexToUpdate, itemList); //find the item in the itemlist based on the index
        //System.out.println(updateObject);
        if (updateObject != null) { //check if the item was found
            indexField.setText(String.valueOf(updateObject.index)); //if the item was found , set Textfield with the item's information
            nameField.setText(String.valueOf(updateObject.name));
            brandField.setText((updateObject.brandName));
            priceField.setText(String.valueOf(updateObject.price));
            quantityField.setText(String.valueOf(updateObject.quantity));
            categoryField.setText(updateObject.category);
            purchDateField.setText(updateObject.purchasedDate);
            //return updateObject;
        } else {
            validationLabel.setText("Entered Index Not In The List"); //if the item was not found,update the validationLabel and clear the fields
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            quantityField.setText("");
            categoryField.setText("");
            purchDateField.setText("");
        }

        return null; //return null if the item was not found
    }

    public void updateToList(ActionEvent event) { // method to update the item in the item list with the updated values
        Validations instance = new Validations();
        int upIndex = instance.int_validation(indexField, validationLabel1); //perform validations on the Text Fields and store the data in related variables
        //System.out.println(upIndex);
        String upName = instance.naming_validation(nameField, validationLabel1);
        //System.out.println(upName);
        String upBrandName = instance.string_validation(brandField, validationLabel1);
        //System.out.println(upBrandName);
        float upPrice = instance.float_validation(priceField, validationLabel1);
        //System.out.println(upPrice);
        int upQuantity = instance.int_validation(quantityField, validationLabel1);
        //System.out.println(upQuantity);
        String upCategory = instance.string_validation(categoryField, validationLabel1);
        //System.out.println(upCategory);
        String upPurchDate = instance.date_string_validation(purchDateField, validationLabel1);
        //System.out.println(upPurchDate);


        if (updateObject != null && !((upIndex == 0 || upName.equals("") || upBrandName.equals("") || upPrice == 0 || upQuantity == 0 || upCategory.equals("") || upPurchDate == null))) { //  check if updateobject is not null
            updateObject.index = upIndex; //Update the values of the selected item with data
            updateObject.name = upName;
            updateObject.brandName = upBrandName;
            updateObject.price = upPrice;
            updateObject.quantity = upQuantity;
            updateObject.category = upCategory;
            updateObject.purchasedDate = upPurchDate;
            //System.out.println("This is the Updated Version" + updateObject);
            //clear the Text fields and update validation tabel
            indexField.setText("");
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            quantityField.setText("");
            categoryField.setText("");
            purchDateField.setText("");
            validationLabel.setText("Item Updated Successfully!!!");
            validationLabel1.setText("");

        } else { //if updateObject is null (no item selected for updating), update the validationLabel and clear the fields
            validationLabel.setText("Entered Data Type is Wrong");
            indexField.setText("");
            nameField.setText("");
            brandField.setText("");
            priceField.setText("");
            quantityField.setText("");
            categoryField.setText("");
            purchDateField.setText("");
        }
    }
    public void displayIndexes(ActionEvent event){ //method to display the indexes of the items in a Tableview
        if(!(itemList==null)) {  // check if itemList is not null and contains items
            //set up the tableview4 to display the indexes of the items in the list
            index1Column.setCellValueFactory(new PropertyValueFactory<Item, Integer>("index"));
            ObservableList<Item> items = FXCollections.observableArrayList(itemList);
            tableView4.setItems(items);
            tableView4.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } else {
            // if itemList is empty or null, update the validationLabel to indicate that an item should be added first
            validationLabel.setText("First Enter An Item To Update!!!");
        }

    }
    private static void sortByIndex(ArrayList<Item> items) { // sort the itemList items based on their index in ascending order
        int lengthItems = items.size(); //Get the number of elements in the list
        for (int i = 0; i < lengthItems - 1; i++) { // loop to iterate from the first elements to the second-to- last element
            for (int j = 0; j < lengthItems - i - 1; j++) { // iterate from the first element to the last unsorted element
                if (items.get(j).getIndex() > items.get(j + 1).getIndex()) { // compare the current element (j) with the index of the next element(j+1), if the index of the j is greater than the index of the next element , then the elements are not in the ascending order
                    //swap the elements to sort them in ascending order based on index
                    Item temp = items.get(j); //store the current element (j) in a temporary variable 'temp'
                    items.set(j, items.get(j + 1)); //set the current element (j) with next element (j+1) (swaps the values)
                    items.set(j + 1, temp); // set the next element (j+1) with the value stored in "temp"
                }
            }
        }
    }


    public void viewItemsDetails(ActionEvent event) { //method to view item details in a TableView,sorted by index

        sortByIndex(itemList);//sort the itemList by index in ascending order
        if (!(itemList.isEmpty())) { //checks itemList is not empty
            //Set cell value factories for each column to retrieve data from the Item object properties
            indexColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("index"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
            brandNameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("brandName"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Item, Float>("price"));
            quantityColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("quantity"));
            categoryColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("category"));
            purchasedDateColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("purchasedDate"));

            if (!(tableView == null)) { //check if the table view is not null
                ObservableList<Item> items = FXCollections.observableArrayList(itemList); //create an observableList from the itemList
                tableView.setItems(items); //set the items to be displayed in the tableview
                //System.out.println(itemList.size());
            }
            // set the column resize policy to CONSTRAINED_RESIZE_POLICY to prevent column resizing issues
            tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } else {
            validationLabel.setText("First Enter Data To The Program"); // if the user click view item button without entering data this message will display in the validationLabel
        }
    }

    public void saveItemsToFile(ActionEvent event) { // Method to save item details from the itemList to a file
        //System.out.println(itemList.size());
        try {
            if ((itemList.size() > 0)) { // check if the itemList contains items
                FileOutputStream fileOutputStream = new FileOutputStream("itemsDetails.txt");// create new FileOutputStream for "itemDetails.txt" file
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); // create an ObjectOutputStream for "itemDetails.txt" file

                objectOutputStream.writeObject(itemList); //write the itemList to the file as a serialized object

                //close the ObjectOutputStream and FileOutputStream after writing
                objectOutputStream.close();
                fileOutputStream.close();
                validationLabel.setText("Data written to  Text file successfully."); //set validationLabel to indicate successful data writing
            }else {
                //if the itemList is empty, set validationLabel to indicate no data to save
                validationLabel.setText("There Are No Data In ItemList!!");
            }
        } catch (IOException e) {
            validationLabel.setText("Error in Print data to Text File");
        }
    }

    public static List<Dealer> readDealerDetailsFromTextFile(String FilePath) { //Method to read and parse dealer details from a text file and return a List of Dealer objects
        List<Dealer> dealerList =new ArrayList<>(); //create an empty ArrayList to store the Dealer objects read from the file
        Dealer currentDealer = null; // Variable to hold the currentDealer object being processed
        try {
            BufferedReader reader = new BufferedReader(new FileReader("dealer_list.txt")); //Create a BufferedReader to read from the text file specified by "dealer_list.txt"
            String line;
            //Loop through each Line in the txt file until end of file is reached
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("dealer_name:")) { //Check if the line starts with "dealer_name:"
                    if (currentDealer != null) { // if currentDealer is not null, add it to the dealerList
                        dealerList.add(currentDealer);
                    }
                    currentDealer = new Dealer(); //Create a new Dealer object
                    currentDealer.setDealerName(line.trim().substring(13)); //set its dealerName property using the substring of the line


                } else if (line.startsWith("contact_no:")) {
                    currentDealer.setContactNo(line.trim().substring(11)); // set the contactNo property of the currentDealer using the substring of the line
                } else if (line.startsWith("location:")) {
                    currentDealer.setLocation(line.trim().substring(10)); //Set the location property of the currentDealer using the substring of the line
                } else if (!line.trim().isEmpty()) { // if the line is not empty , split it by "," to extract the dealer item details
                    String[] dealeritems = line.split(",");
                    String itemName = dealeritems[0].trim();
                    //Extract the itemName,brand,itemPrice and quantity  from the line
                    //System.out.println(itemName);
                    String brand = dealeritems[1].trim();
                    //System.out.println(brand);
                    float itemPrice = Float.parseFloat(dealeritems[2].trim().substring(1));
                    //System.out.println(itemPrice);
                    int quantity = Integer.parseInt(dealeritems[3].trim());
                    //System.out.println(quantity);

                    //Create a new DealerItem object with the extracted details
                    DealerItem dealerItem = new DealerItem(itemName, brand, itemPrice, quantity);
                    //Add the dealerItem to the currentDealer's dealeritems list
                    currentDealer.addDealerItem(dealerItem);
                    //System.out.println("this is ;  " + dealerItem);
                    //System.out.println(currentDealer);
                    //System.out.println(dealerList);

                } else {

                    if (currentDealer.dealeritems.size() == 3) { // If the line is empty and the currentDealer's dealeritems list size is 3,
                        dealerList.add(currentDealer); //add the currentDealer to the dealerList
                        currentDealer = null;//Rest currentDealer for the next dealer entry in the file
                    }
                }

            }
        reader.close(); //Close the BufferedReader after reading the file
        } catch (Exception e) {
            //If and exception occurs, print the stack trace for debugging
            e.printStackTrace();
        }
        return dealerList; // Return the List of Dealer objects that containing the read dealer details
    }

    public void selectRandomDealers(ActionEvent event) { // Method to select and display 4  random dealers with their associated items in a Table View

        List<Dealer> dealerList = readDealerDetailsFromTextFile("dealer_list.txt"); // Read dealer details from the txt file and store them in the dealerList
        // Check if there are less than 4 dealers in the List
        if (dealerList.size() < 4) {
            validationLabel.setText("Can't Select 4 Random Dealers"); // if there are less than 4 dealers , set the validationLabel to inform the user
        }
        Collections.shuffle(dealerList);// Shuffle the dealerList to randomize the order of dealers
        List<Dealer> randomDealers = new ArrayList<>();// Create a new ArrayList to store 4 randomly selected dealers

        for (int i = 0; i < 4; i++) { // Add the first 4 dealers that shuffle from dealerList to the randomDealers list
            randomDealers.add(dealerList.get(i));
        }
        //System.out.println("These Are Random" + randomDealers);

        // Set cell value factories for columns to display dealer information in the Table View
        dealerColumn.setCellValueFactory(new PropertyValueFactory<>("dealerName"));
        contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        //Set cell value factories for the columns to display dealer item information in the TableView
        itemName1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(0).getItemName()));
        itemName2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(1).getItemName()));
        itemName3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(2).getItemName()));

        itemBrand1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(0).getBrand()));
        itemBrand2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(1).getBrand()));
        itemBrand3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(2).getBrand()));

        itemPrice1Column.setCellValueFactory(data -> {
            float price1Item = data.getValue().getDealeritems().get(0).getItemPrice();
            return Bindings.createFloatBinding(() -> price1Item).asObject();
        });
        itemPrice2Column.setCellValueFactory(data -> {
            float price2Item = data.getValue().getDealeritems().get(1).getItemPrice();
            return Bindings.createFloatBinding(() -> price2Item).asObject();
        });
        itemPrice3Column.setCellValueFactory(data -> {
            float price3Item = data.getValue().getDealeritems().get(2).getItemPrice();
            return Bindings.createFloatBinding(() -> price3Item).asObject();
        });

        itemQuantity1Column.setCellValueFactory(data -> {
            int quantity1Item = data.getValue().getDealeritems().get(0).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity1Item).asObject();
        });
        itemQuantity2Column.setCellValueFactory(data -> {
            int quantity2Item = data.getValue().getDealeritems().get(1).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity2Item).asObject();
        });
        itemQuantity3Column.setCellValueFactory(data -> {
            int quantity3Item = data.getValue().getDealeritems().get(2).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity3Item).asObject();
        });

        // Check if the tableView1 is not null
        if (!(tableView1 == null)) {
            //Create an ObservableList from the randomDealers and set it as the items to be displayed in tableView1
            ObservableList<Dealer> items = FXCollections.observableArrayList(randomDealers);
            tableView1.setItems(items);

        } else {
            // If tableView1 is null, update the validationLabel to set that the TableView is empty
            validationLabel.setText("Table View Is Empty!!");
        }
        tableView1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    private static List<Dealer> sortByLocation(List<Dealer> dealers) { // Method to sort a List of dealers based on their location in ascending order
        // Get the number of dealers in the List
        int lengthDealers= dealers.size();
            //System.out.println(lengthDealers);

            for(int i =0; i<lengthDealers;i++){ //Iterate from the first dealer to the second-to-last dealer
                for(int j =0;j < lengthDealers-i-1;j++){
                    //Compare the location of the current dealer (j) with the location of the next dealer (j+1)
                    //If the location of the current dealer is greater than the location of the next dealer, so it means the dealers are not in the ascending order
                    if(dealers.get(j).getLocation().compareTo(dealers.get(j+1).getLocation()) > 0){
                       //Store the current dealer (j) in a temporary variable 'temp'
                        Dealer temp =dealers.get(j);
                        //System.out.println(temp);
                        dealers.set(j,dealers.get(j+1));//Set the current dealer (j) with the next dealer(j+1)
                        dealers.set(j+1,temp); // Set the next dealer (j+1) with the value stored in 'temp'
                    }
                }
            }
            return dealers; //Returns the Sorted list of dealers
    }

    public  void sortDealersByLocation(ActionEvent event){ // Method to sort dealers by location and display them in a TableView
        List<Dealer> dealerList=readDealerDetailsFromTextFile("dealer_list.txt"); // Read dealer details from the text file and store them in dealerList
        List<Dealer> dealers =sortByLocation(dealerList); // sort the dealerList by location in ascending order

        //Set the set value factories for columns to display dealer information in the TableView
        dealerColumn.setCellValueFactory(new PropertyValueFactory<>("dealerName"));
        contactNoColumn.setCellValueFactory(new PropertyValueFactory<>("contactNo"));
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));

        //Set cell value factories for columns to display dealer item information in the TableView
        itemName1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(0).getItemName()));
        itemName2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(1).getItemName()));
        itemName3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(2).getItemName()));

        itemBrand1Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(0).getBrand()));
        itemBrand2Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(1).getBrand()));
        itemBrand3Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDealeritems().get(2).getBrand()));

        itemPrice1Column.setCellValueFactory(data -> {
            float price1Item = data.getValue().getDealeritems().get(0).getItemPrice();
            return Bindings.createFloatBinding(() -> price1Item).asObject();
        });
        itemPrice2Column.setCellValueFactory(data -> {
            float price2Item = data.getValue().getDealeritems().get(1).getItemPrice();
            return Bindings.createFloatBinding(() -> price2Item).asObject();
        });
        itemPrice3Column.setCellValueFactory(data -> {
            float price3Item = data.getValue().getDealeritems().get(2).getItemPrice();
            return Bindings.createFloatBinding(() -> price3Item).asObject();
        });

        itemQuantity1Column.setCellValueFactory(data -> {
            int quantity1Item = data.getValue().getDealeritems().get(0).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity1Item).asObject();
        });
        itemQuantity2Column.setCellValueFactory(data -> {
            int quantity2Item = data.getValue().getDealeritems().get(1).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity2Item).asObject();
        });
        itemQuantity3Column.setCellValueFactory(data -> {
            int quantity3Item = data.getValue().getDealeritems().get(2).getItemQuantity();
            return Bindings.createIntegerBinding(() -> quantity3Item).asObject();
        });

        // Check if tableView3 is not null
        if (!(tableView3 == null)) {
            //Create an ObserableList from the sorted dealers list (dealers) and set it as the items to be dispalyed in tableview3
            ObservableList<Dealer> items = FXCollections.observableArrayList(dealers);
            tableView3.setItems(items);
        }else {
            validationLabel.setText("Table is Empty!!");// If tableView3 is null,set the validationLabel to tableView is empty
        }
        tableView3.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        }
    public void showDealerDetails(ActionEvent event) {// Method to show the details of a selected dealer in a TableView
        // Get the dealer name from the inputDealerNameField
        String dealerName = inputDealerNameField.getText();
        System.out.println(dealerName);
        //Read dealer details from the txt file and store them in dealerList
        List<Dealer> dealerList = readDealerDetailsFromTextFile("dealer_list.txt");
        System.out.println(dealerList);
        Dealer selectedDealer = null; //Initialize a variable to store the selected dealer

        for (int i = 0; i < dealerList.size(); i++) { //Loop through each dealer in the dealerList to find the selected dealer
            if (dealerList.get(i).getDealerName().equals(dealerName)) {
                // If the dealer name matches the input dealer name, store it in selectedDealer
                selectedDealer = dealerList.get(i);
                //Clear the validationLabel , as the selected dealer is valid
                validationLabel.setText("");
                //Break the loop as the selectedDealer is found
            }
        }
        if (selectedDealer == null) {
            validationLabel.setText("You Entered Dealer is Not in The Dealer List!!!");  //If the dealer name doesn't match the input dealer name, set the validationLabel display error message
        }
        if (dealerName.isEmpty()) {      //Check if the input dealer name is empty
                validationLabel.setText("Please Enter a Dealer Name!!"); //If the input dealer name is empt, set the validationLabel to set message
            } else {
                //If the input dealer name is  not empty
                if (!(tableView2 == null)) {

                    //Set cell value factories for columns to display dealer item information in the TableView
                    itemName4Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));
                    itemBrand4Column.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getBrand()));
                    itemPrice4Column.setCellValueFactory(data -> {
                        float price1Item = data.getValue().getItemPrice();
                        return Bindings.createFloatBinding(() -> price1Item).asObject();
                    });

                    itemQuantity4Column.setCellValueFactory(data -> {
                        int quantity1Item = data.getValue().getItemQuantity();
                        return Bindings.createIntegerBinding(() -> quantity1Item).asObject();

                    });

                    //Create an ObservableList from the dealer items of the selected dealer and set it as the items to be displayed in tableView2
                    ObservableList<DealerItem> listItems = FXCollections.observableArrayList(selectedDealer.getDealeritems());
                    tableView2.setItems(listItems);

                } else {
                    // If tableView2 is null, set the validationLabel to display error message
                    validationLabel.setText("Error in Table View");
                }
                tableView2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            }

    }


        public static void main (String[]args){




    }
}







