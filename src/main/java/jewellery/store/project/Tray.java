package jewellery.store.project;

public class Tray {
    public LinkedList<Jewellery> items = new LinkedList<>();


    public Node head;
    public int trayNumber = 0;
    public int cost = 0;
    public String  size;
    public char id;
    public String colour;

    public Tray(String size, String colour, char id, int trayNumber ){

        this.size = size;
        this.colour = colour;
        this.id = id;
        this.trayNumber = trayNumber;

    }

    //Getters----------------------------------------------
    public int getTrayNumber() {
        return trayNumber;
    }

    public String getSize() {

        return size;
    }

    public String getColour() {
        return colour;
    }

    public char getId() {
        return id;
    }

    public LinkedList<Jewellery> getItems() {
        return items;
    }

    //Setters------------------------------------------------
    public void setTrayNumber(int trayNumber) {
        this.trayNumber = trayNumber;
    }


    public void setSize(String size) {

        this.size = size;
    }

    public void setId(char id) {

        this.id = id;
    }

    public void setColour(String colour) {

        this.colour = colour;
    }

    public void setItems(LinkedList<Jewellery> items) {
        this.items = items;
    }

    //Methods-----------------------------------------------------------
    public void addItem(Jewellery it){ items.add(it); }

    public Object getItem(int index){
        return items.get(index);}

    public String identifier(){
        String str = id + "" + trayNumber;
        return str;
    }

    public void  costDown   (int price){cost -= price;}

    public String fullList(){
        return  "Tray : " + identifier() +
                " || Tray Colour: " + colour +
                " || Tray Dimensions: " + size + '\n'+
                '\n' + items.listAll() +'\n';
    }

    @Override
    public String toString() {
        return  "Tray : " + identifier() +
                " || Tray Colour: " + colour +
                " || Tray Dimensions: " + size + '\n'; //+
                //'\n' + items.listAll() +'\n';
    }


}
