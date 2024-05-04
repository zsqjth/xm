package pojo;

public class Product {
    private Integer id;
    private String productname;
    private Double price;
    private Integer quantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product(Integer id, String productname, Double price, Integer quantity) {
        this.id = id;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
    }
}
