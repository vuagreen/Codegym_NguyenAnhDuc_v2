package phone;

public class Phone extends Product {
    private String camera;

    public String getCamera() {
        return camera;
    }

    public Phone(int id, String price, String url, String camera) {
        super(id, price, url);
        this.camera = camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Phone() {

    }
}
