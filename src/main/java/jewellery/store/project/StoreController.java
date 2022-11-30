package jewellery.store.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class StoreController implements Initializable {
    public int caseNumber = 1;
    public int trayNumber = 1;
    public char id = 'A';
    public static LinkedList<Case> list = new LinkedList<>();
    private int stockValue, index;


    //GUI-------------------------------------------------------------
    //CASE============================================================
    @FXML
    private ListView<String> caseList;

    @FXML
    private ListView<String> showCase;

    @FXML
    private ChoiceBox<String> caseType;

    @FXML
    private ChoiceBox<String> caseLighting;

    @FXML
    private TextField pickCase;

    @FXML
    private ListView<String> caseValue;

    //TRAY====================================================
    @FXML
    private ListView<String> trayList;

    @FXML
    private ListView<String> fullTrayList;

    @FXML
    private ChoiceBox<String> trayColour;

    @FXML
    private ChoiceBox<String> traySize;

    @FXML
    private ChoiceBox<String> caseID;

    @FXML
    private ChoiceBox<String> trayID;

    @FXML
    private ListView<String> trayValue;



    //ITEM==================================================
    @FXML
    private ListView<String> listOfItems;

    @FXML
    private ChoiceBox<Case> caseItemID;

    @FXML
    private ChoiceBox<Tray> trayItemID;

    @FXML
    private ChoiceBox<String > itemType;

    @FXML
    private TextField price;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    private TextArea itemDescription;

    @FXML
    private ChoiceBox<Tray> removeFrom;

    @FXML
    private ChoiceBox<Jewellery> removeItem;

    //MATERIAL=====================================================
    @FXML
    private TextArea materialDescription;

    @FXML
    private ChoiceBox<String > materialType;

    @FXML
    private ChoiceBox<String> quality;

    @FXML
    private TextField weight;

    @FXML
    private ChoiceBox<Jewellery> itemID;

    @FXML
    private ListView<String> itemList;

    //STOCK=======================================================
//    @FXML
//    private ListView<String> stockInfo;

    @FXML
    private ListView<String> stockCost;

    @FXML
    private TreeView<String> stockInfo;

    @FXML
    private TextField searchBar;

    @FXML
    private ListView<String> itemSearch;

    @FXML
    private ListView<Material> materialList;


    //list's----------------------------------------------------------


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        caseType.getItems().addAll("Wall-mounted", "Freestanding");
        caseLighting.getItems().addAll("Lit", "Unlit");
        trayColour.getItems().addAll("White", "Ocean Blue", "red");
        traySize.getItems().addAll("10cm x 10cm", "10cm x 15cm", "20cm x 15cm");
        itemType.getItems().addAll("Ring", "Watch", "Necklace");
        gender.getItems().addAll("Male", "Female");
        materialType.getItems().addAll("Gold", "Silver", "Platinum", "Diamond", "Emerald");
        quality.getItems().addAll("14K", "16K", "20K");

    }

    @FXML
    void addCase(MouseEvent event) {
        System.out.println(caseNumber);
        String cT = caseType.getSelectionModel().getSelectedItem();
        String cL = caseLighting.getSelectionModel().getSelectedItem();
        String cN = String.valueOf(caseNumber);

        //adds the new case to the linked list------------------------------------------------
        list.add(new Case(cT, cL, caseNumber));
        //Populates choice box in Tray Tab
        caseID.getItems().add(String.valueOf(list.get(caseNumber - 1)));
        //Populates choice box in Jewellery Tab
        caseItemID.getItems().add((Case) list.get(caseNumber - 1));

        //populates the list in Case Tab---------------------------------------------------------
        caseList.getItems().addAll(cN + " || Case type: " + cT + " || Case lighting type: " + cL);
        caseNumber++;
    }

    @FXML
    //Shows the case at the given index--------------------------------------------------------------
    void showCase(MouseEvent event) {
        index = Integer.parseInt(pickCase.getText());
        System.out.println(index + " INDEX");

        //First clears the list then populates the bottom list in Case Tab
        showCase.getItems().clear();
        showCase.getItems().addAll(String.valueOf(list.get(index - 1)));
        //loops through the cases
        for (int i = 0; i < list.size(); i++){
            Case c = (Case) list.get(i);
            if (c.displayNumber == index) {
                //loops through the trays
                for (int j = 0; j < c.displayTrays.size(); j++) {
                    Tray trays = (Tray) c.displayTrays.get(j);
                    showCase.getItems().addAll("   " + trays);
                    int caseCost = 0;
                    //loops through the items
                    for (int l = 0; l < trays.items.size(); l++){
                        Jewellery items = (Jewellery) trays.items.get(l);
                        showCase.getItems().addAll("     " + items);
                        //Generates the total value of selected case
                        int value = items.getPrice();
                        caseCost += value;
                        System.out.println(caseCost + " CASE");
                        caseValue.getItems().clear();
                        caseValue.getItems().add("€" + caseCost);
                    }
                }
            }
        }
    }



    @FXML
    //adds a tray to the selected case-------------------------------------------------------------
    void addTray(MouseEvent event) {
        String tC = trayColour.getSelectionModel().getSelectedItem();
        String tS = traySize.getSelectionModel().getSelectedItem();
        String str = "";
        removeFrom.getItems().clear();
        //loops through the cases to find the required caseID
        for (int i = 0; i < list.size(); i++){
            Case c = (Case) list.get(i);
            //if ID matches then the tray gets added
            if (caseID.getSelectionModel().getSelectedItem().contains(((Case) list.get(i)).display())){
                ((Case) list.get(i)).addTray(new Tray(tS, tC, id, trayNumber));
                str += "Tray: " + id + "" + trayNumber + " || Tray Size: " + tS + " || Tray Colour: " + tC;
                trayList.getItems().addAll(str);
                String temp = id + "" + trayNumber;
                trayID.getItems().addAll(temp);
                ++trayNumber;
                id++;
                //loops through the items in selected tray to add them to choice box
                for (int j = 0; j < c.displayTrays.size(); j++){
                    Tray tray = (Tray) c.displayTrays.get(j);
                    removeFrom.getItems().addAll(tray);
                }
            }
        }
        caseID.getItems().clear();
        for (int i = 0; i < list.actualSize; i++){
            caseID.getItems().addAll(String.valueOf(list.get(i)));
        }
    }

    @FXML
    void showTray(MouseEvent event) {
        //lists all the cases with the corresponding trays
        fullTrayList.getItems().clear();

        //loops through all the cases------------------------------------------------
        for (int i = 0; i < list.size() ; i++){
            Case c = (Case) list.get(i);
            ////loops through all the trays------------------------------------------
            for (int j = 0; j < c.displayTrays.size(); j++){
                Tray tray = (Tray) c.displayTrays.get(j);
                if (c.displayTrays.get(j).toString().contains(trayID.getValue())) {
                    fullTrayList.getItems().addAll("" + tray);
                    System.out.println(tray);
                    int trayCost = 0;
                    ////loops through all the items---------------------------------
                    for (int k = 0; k < tray.items.size(); k++){
                        Jewellery item = (Jewellery) tray.items.get(k);
                        fullTrayList.getItems().addAll("  " + item);
                        System.out.println(item);

                        //Generates the total value of selected tray
                        int value = item.getPrice();
                        trayCost += value;
                        System.out.println(trayCost + " TRAY");
                        trayValue.getItems().clear();
                        trayValue.getItems().add("€" + trayCost);
                    }
                }
            }
        }
    }


    @FXML
    //As the mouse moves over the choice box the relevant trays get added to it
    void setTrayContent(MouseEvent event) {
        trayItemID.getItems().clear();
        //loops through the cases
        for(int i = 0; i<list.size();i++) {
            Case root = (Case) list.get(i);
            //loops through the trays
            if (caseItemID.getValue().fullList().contains(root.displayTrays.listAll())){
                for (int j = 0; j < root.displayTrays.size(); j++) {
                    Tray tray = (Tray) root.getTray(j);
                    trayItemID.getItems().add(tray);

                }
            }
        }
    }

    @FXML
    void addJewellery(MouseEvent event) {
        String it = itemType.getSelectionModel().getSelectedItem();
        int p = Integer.parseInt(price.getText());
        String g = gender.getSelectionModel().getSelectedItem();
        String id = itemDescription.getText();


        Tray tray = trayItemID.getSelectionModel().getSelectedItem();
        Jewellery item = new Jewellery(it, p, g, id);
        tray.addItem(item);

        listOfItems.getItems().addAll(tray.getItems().listOne());
        itemID.getItems().add(item);

        stockValue += p;
        String str = String.valueOf(stockValue);
        stockCost.getItems().clear();
        stockCost.getItems().add(str);
    }

    @FXML
    void setItemContent(MouseEvent event) {
        removeItem.getItems().clear();
        //loops through the cases
        for(int i = 0; i < list.size();i++) {
            Case root = (Case) list.get(i);
            //loops through the trays
            //if (caseItemID.getValue().fullList().contains(root.displayTrays.listAll())){
            for (int j = 0; j < root.displayTrays.size(); j++) {
                Tray tray = (Tray) root.getTray(j);
                //checks if selected try has any items
                if (removeFrom.getValue().fullList().contains(tray.items.listAll())){
                    //loops through the items and then adds them to the choice box
                    for (int l = 0; l < tray.items.size(); l++){
                            Jewellery item = (Jewellery) tray.getItem(l);
                            removeItem.getItems().add(item);
                    }
                }

            }
        }
    }

    @FXML
    void deleteItem(MouseEvent event) {
        removeItem.getSelectionModel().getSelectedItem();
        int index = removeItem.getSelectionModel().getSelectedIndex();
        Tray tray = removeFrom.getSelectionModel().getSelectedItem();
        int p = removeItem.getSelectionModel().getSelectedItem().getPrice();
        stockValue -= p; //reduces the stock value by the cost of deleted item
        tray.items.deleteNode(index);//deletes the item node at the selected index
        itemID.getItems().remove(index);
        tray.costDown(p);
    }

    @FXML
    void smartAdd(MouseEvent event) {
        boolean product = false;
        int iPrice = Integer.parseInt(price.getText());
        Jewellery smartItem = new Jewellery(itemType.getValue(), iPrice, gender.getValue(), itemDescription.getText());

        //if product is true starts the loop
        if (!product){
            //loops through cases
            for (int i = 0; i < list.size(); i++) {
                Case c = (Case) list.get(i);
                if (!product) {
                    //loops through trays
                    for (int j = 0; j < c.displayTrays.size(); j++) {
                        Tray tray = (Tray) c.displayTrays.get(j);
                        if (c.displayTrays.size() == 1) {
                            tray.items.add(smartItem);
                            stockValue += iPrice;
                            String str = String.valueOf(stockValue);
                            stockCost.getItems().clear();
                            stockCost.getItems().add(str);
                            product = true;
                            listOfItems.getItems().add(smartItem + " Smart ADD");
                        }
                        if (product == false) {
                            for (int k = 0; k < tray.items.size(); k++) {
                                Jewellery item = (Jewellery) tray.items.get(k);
                                if (product == false) {
                                    String temp = itemType.getValue() + "";
                                    if (item.getItemType().equals(temp)) {
                                        tray.items.add(smartItem);
                                        stockValue += iPrice;
                                        String str = String.valueOf(stockValue);
                                        stockCost.getItems().clear();
                                        stockCost.getItems().add(str);
                                        product = true;
                                        listOfItems.getItems().add(smartItem + " Smart ADD");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(product == false) {
            for (int i = 0; i < list.size(); i++) {
                Case c = (Case) list.get(i);
                for (int j = 0; j < c.displayTrays.size(); j++) {
                    if(product == false) {
                        Tray tray = (Tray) c.displayTrays.get(j);
                        tray.items.add(smartItem);
                        stockValue += iPrice;
                        String str = String.valueOf(stockValue);
                        stockCost.getItems().clear();
                        stockCost.getItems().add(str);
                        product = true;
                        listOfItems.getItems().add(smartItem + " Smart ADD");
                    }
                }
            }
        }
    }

    @FXML
    void addMaterial(MouseEvent event) {
        itemList.getItems().clear();
        String mT = materialType.getValue();
        String q = quality.getValue();
        int w = Integer.parseInt(weight.getText());
        String mD = materialDescription.getText();

        Jewellery item = itemID.getSelectionModel().getSelectedItem();
        item.addMaterial(new Material(mT, q, w, mD));

        for (int i = 0; i < item.materials.size(); i++){
            itemList.getItems().add(item.materials.get(i) + "");
        }
    }

    @FXML
    void showAll(MouseEvent event) {
        TreeItem<String> rooItem = new TreeItem<>("Stock");
        stockInfo.setRoot(rooItem);

        //loops through cases then adds each to tree
        for (int i = 0; i < list.size(); i++){
            Case root = (Case) list.get(i);
            TreeItem treeCase = new TreeItem(root);
            rooItem.getChildren().add(treeCase);
            //loops through trays then adds each to tree
            for (int j = 0; j < root.displayTrays.size(); j++){
                Tray tray = (Tray) root.displayTrays.get(j);
                TreeItem treeTray = new TreeItem(tray);
                treeCase.getChildren().add(treeTray);
                //loops through items then adds each to tree
                for (int k = 0; k < tray.items.size(); k++){
                    Jewellery item = (Jewellery) tray.items.get(k);
                    TreeItem treeItem = new TreeItem(item);
                    treeTray.getChildren().add(treeItem);
                    //loops through materials then adds each to tree
                    for (int l = 0; l < item.materials.size(); l++){
                        Material material = (Material) item.materials.get(l);
                        TreeItem treeMaterial = new TreeItem(material);
                        treeItem.getChildren().add(treeMaterial);
                    }
                }
            }
        }
    }

    @FXML
    void search(MouseEvent event) {
        String sB = searchBar.getText();
        itemSearch.getItems().clear();
        //Loops through the cases--------------------------------------------
        for (int i = 0; i < list.size(); i++){
            Case c = (Case) list.get(i);
                //Loops through the trays------------------------------------
                for (int j = 0; j < c.displayTrays.size(); j++){
                    Tray trays = (Tray) c.getTray(j);
                        //Loops through the items----------------------------
                        for (int k = 0; k < trays.items.size(); k++){
                            Jewellery item = (Jewellery) trays.getItem(k);
                            String temp = item.toString();
                            String temp1 = sB;

                            if (temp.contains(temp1)){
                                //adds the item to the list view-------------
                               String cL = "" + c;
                               String tL = "  " + trays;
                               itemSearch.getItems().add(cL);
                               itemSearch.getItems().add(tL);
                               itemSearch.getItems().add("     " + item);
                               String n = '\n' + "";
                               itemSearch.getItems().add(n);
                            }
                        }
                }
        }
    }

    @FXML
    void displayMaterial(MouseEvent event) {
        materialList.getItems().clear();
        //if something is chosen begins loop
        if (itemSearch.getSelectionModel().getSelectedItem() != null) {
            //loops through cases
            for (int i = 0; i < list.size(); i++) {
                Case c = (Case) list.get(i);
                //loops through trays
                for (int j = 0; j < c.displayTrays.size(); j++) {
                    Tray trays = (Tray) c.displayTrays.get(j);
                    //loops through items
                    for (int k = 0; k < trays.items.size(); k++) {
                        Jewellery items = (Jewellery) trays.items.get(k);
                        String temp = itemSearch.getSelectionModel().getSelectedItem();
                        String temp1 = items + "";

                        //if the chosen item in itemSearch is the item currently that the loop is at
                        if (temp.contains(temp1)) {
                            //loops through materials and adds them to materialList
                            for (int l = 0; l < items.materials.size(); l++) {
                                Material material = (Material) items.materials.get(l);
                                materialList.getItems().add(material);
                            }
                        }
                    }

                }
            }
        }
    }

    @FXML
    void reset(MouseEvent event){
        //changing the heads to null
        list.delAll();

        //clearing all choice boxes and lists
        //Case tab---------------------------------------------------
        caseList.getItems().clear();
        showCase.getItems().clear();

        //Tray tab---------------------------------------------------
        caseID.getItems().clear();
        fullTrayList.getItems().clear();
        trayList.getItems().clear();

        //Items tab-------------------------------------------------
        caseItemID.getItems().clear();
        trayItemID.getItems().clear();
        listOfItems.getItems().clear();

        //Components tab--------------------------------------------
        itemID.getItems().clear();
        itemList.getItems().clear();

        stockValue = 0;
    }

    @FXML
    void saveSystem(MouseEvent event) throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("Jewellery_Store.xml"));
        LinkedList<Case> list1 = list;
        out.writeObject(list1);
        out.close();
    }

    @FXML
    void loadSystem(MouseEvent event) throws Exception {
        Class<?>[] classes = new Class[]{Case.class, Jewellery.class, Material.class,
                Tray.class, LinkedList.class, Node.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("Jewellery_Store.xml"));
        list = (LinkedList<Case>) in.readObject();
        in.close();

    }
}


