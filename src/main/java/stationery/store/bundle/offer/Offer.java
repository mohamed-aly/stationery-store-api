package stationery.store.bundle.offer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import stationery.store.bundle.abstractAndInterfaces.BaseEntity;
import stationery.store.bundle.product.Product;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "offers")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Offer extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference(value="offer-product")
    private Product product;

    @Column(name = "discount")
    private double discount;

    @Column(name = "start_date")
    private Date startDate = new Date();


    @Column(name = "end_date")
    private Date endDate;

}
