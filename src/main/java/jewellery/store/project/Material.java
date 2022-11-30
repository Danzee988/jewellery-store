package jewellery.store.project;

public class Material {
    public int weight;
    public String materialType, materialDes, quality;

    public Material(String mT, String q, int w, String mD){
        this.materialType = mT;
        this.quality = q;
        this.weight = w;
        this.materialDes = mD;
    }

    //Getters-------------------------------------------------------
    public int getWeight() {
        return weight;
    }

    public String getMaterialType() {
        return materialType;
    }

    public String getMaterialDes() {
        return materialDes;
    }

    public String getQuality() {
        return quality;
    }

    //Setters----------------------------------------------------------
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public void setMaterialDes(String materialDes) {
        this.materialDes = materialDes;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    //Methods-----------------------------------------------------
    @Override
    public String toString() {
        return "Material Type: " + materialType
                + " || Material Quality: " + quality
                + " || Material Weight: " + weight
                + '\n' + "|| Material Description: " + materialDes + '\n';

    }

}
