public class Bread {
    private String BreadName;
    private int BreadQuantity;

    public Bread(String BreadName, int BreadQuantity){
        this.BreadName=BreadName;
        this.BreadQuantity=BreadQuantity;
    }
    public String getBreadName() {
        return BreadName;
    }

    public void setBreadName(String BreadName) {
        this.BreadName = BreadName;
    }

    public int getBreadQuantity() {
        return BreadQuantity;
    }

    public void setBreadQuantity(int BreadQuantity) {
        this.BreadQuantity = BreadQuantity;
    }
}