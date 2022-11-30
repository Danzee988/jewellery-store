package jewellery.store.project;

public class Jewellery {
    public LinkedList<Material> materials = new LinkedList<>();

    public Node head;
    public int price;
    public String itemDetail, itemType, gender;

    public Jewellery(String t, int p, String g, String d){
        this.itemType = t;
        this.price = p;
        this.gender = g;
        this.itemDetail = d;
    }

    //Getters---------------------------------------------------------
    public String getItemDetail() {
        return itemDetail;
    }

    public int getPrice() {
        return price;
    }

    public String getItemType() {
        return itemType;
    }

    public String getGender() {
        return gender;
    }

    public LinkedList<Material> getMaterials() {
        return materials;
    }

    //Setters-------------------------------------------------------------
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMaterials(LinkedList<Material> materials) {
        this.materials = materials;
    }

    //Methods-----------------------------------------------------------

    public void addMaterial(Material m){ materials.add(m); }

    public Object getMaterial(int index){return materials.get(index);}


    @Override
    public String toString() {
        return "Item: " + itemType + " || Target Gender: " + gender
                + " || Item Price: " + price + '\n'
                + " || Item Description: " + itemDetail + '\n';
                //+ '\n' + materials.listAll() + '\n';

    }
}
