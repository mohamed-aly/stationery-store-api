package stationary.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "min_stock")
    private int minStock;

    @OneToMany(mappedBy = "product",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private List<OrderItem> orders;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL)
    private List<ProductImage> imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductPatch> patches;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL)
    private List<Offer> offers;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    private List<ClassifiedProduct> packages;

    public Product() {

    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<OrderItem> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderItem> orders) {
        this.orders = orders;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<ClassifiedProduct> getPackages() {
        return packages;
    }

    public void setPackages(List<ClassifiedProduct> packages) {
        this.packages = packages;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public List<ProductPatch> getPatches() {
        return patches;
    }

    public void setPatches(List<ProductPatch> patches) {
        this.patches = patches;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<ProductImage> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<ProductImage> imageUrl) {
        this.imageUrl = imageUrl;
    }
}
