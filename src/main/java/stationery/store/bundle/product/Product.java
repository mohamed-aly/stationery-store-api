package stationery.store.bundle.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;
import stationery.store.bundle.abstractAndInterfaces.BaseEntity;
import stationery.store.bundle.cartItem.CartItem;
import stationery.store.bundle.category.Category;
import stationery.store.bundle.offer.Offer;
import stationery.store.bundle.orderItem.OrderItem;
import stationery.store.bundle.packages.Package;
import stationery.store.bundle.productImage.ProductImage;
import stationery.store.bundle.productPatch.ProductPatch;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NamedEntityGraph(name = "Product.imageUrl",
        attributeNodes = @NamedAttributeNode("imageUrl")
)
public class Product extends BaseEntity {

    @NotEmpty
    private String name;

    private String description;

    private int minStock;

    @Min(1)
    private int price;

    private int inStock;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate created;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference(value="category-product")
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "orderItem-product")
    private Set<OrderItem> orders;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value="productImage-product")
    private Set<ProductImage> imageUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference(value="cartItem-product")
    private Set<CartItem> cartItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    @JsonManagedReference(value="productPatch-product")
    @OrderBy("dateIn")
    private Set<ProductPatch> patches;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonManagedReference(value="offer-product")
    @OrderBy("endDate desc")
    @Where(clause = "end_date > sysdate()")
    private Set<Offer> offers;

    @OneToMany(mappedBy = "product",
            cascade = CascadeType.ALL)
    @JsonManagedReference(value="package-product")
    private Set<Package> packages;

}
