package sample;

public class NewsLink {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public NewsLink(String address, String title) {
        this.address = address;
        this.title = title;
    }
}
