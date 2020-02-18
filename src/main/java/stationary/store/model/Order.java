package stationary.store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @Column(name = "submit_date")
    private Date sumbitDate;

    @Column(name = "estimated_days")
    private int estDelieveryDays;

    @Column(name = "delivery_date")
    private Date delieveryDate;

    @Column(name = "last_status_update_date")
    private Date lastUpdateDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "shipper_id")
    private Shipper shipper;


    public Order() {

    }

    public Date getSumbitDate() {
        return sumbitDate;
    }

    public void setSumbitDate(Date sumbitDate) {
        this.sumbitDate = sumbitDate;
    }

    public int getEstDelieveryDays() {
        return estDelieveryDays;
    }

    public void setEstDelieveryDays(int estDelieveryDays) {
        this.estDelieveryDays = estDelieveryDays;
    }

    public Date getDelieveryDate() {
        return delieveryDate;
    }

    public void setDelieveryDate(Date delieveryDate) {
        this.delieveryDate = delieveryDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }
}
