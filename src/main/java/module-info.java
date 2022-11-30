module jewellery.store.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires xstream;


    opens jewellery.store.project to javafx.fxml, xstream;
    exports jewellery.store.project;
    //opens Resources to xstream;
    //exports models to xstream;
}