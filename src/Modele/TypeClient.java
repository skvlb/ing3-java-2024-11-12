package modele;

public class TypeClient {
    private int id;
    private String description;
    private double reduction;

    public TypeClient(int id, String description, double reduction) {
        this.id = id;
        this.description = description;
        this.reduction = reduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }
}
