package jewellery.store.project;


public class Case {
    public LinkedList<Tray> displayTrays = new LinkedList<>();


    Node head;
    int displayNumber, idNum;
    char identifier;
    String type, lighting;


    public Case(String t, String l, int displayNumber){
        this.type = t;
        this.lighting = l;
        this.displayNumber = displayNumber;
    }


    //Getters------------------------------------

    public String getType() {
        return type;
    }

    public String getLighting() {
        return lighting;
    }

    public int getDisplayNumber() {
        return displayNumber;
    }


    //Setters---------------------------------------------------

    public void setType(String type) {
        this.type = type;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public void setDisplayNumber(int displayNumber) {
        this.displayNumber = displayNumber;
    }

    //Methods-----------------------------------------------------------
    public String display(){
        String temp = String.valueOf(displayNumber);
        return temp;
    }

    public void addTray(Tray dt){
        displayTrays.add(dt);
    }

    public Object getTray(int index) {
        return displayTrays.get(index);
    }

    public String fullList(){
        return  "Case number: " + displayNumber +
                " || Case type: " + type +
                " || Case lighting: " + lighting + '\n' + '\n'
                + displayTrays.listAll() + '\n';
    }


    @Override
    public String toString() {
        return  "Case number: " + displayNumber +
                " || Case type: " + type +
                " || Case lighting: " + lighting + '\n'; //+ '\n'
                //+ displayTrays.listAll() + '\n';
    }
}
