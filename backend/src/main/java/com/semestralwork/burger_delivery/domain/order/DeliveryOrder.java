package com.semestralwork.burger_delivery.domain.order;

import com.semestralwork.burger_delivery.domain.adress.Adress;
import com.semestralwork.burger_delivery.domain.burger.Burger;
import com.semestralwork.burger_delivery.enums.ORDERSTATE;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column
    @CreationTimestamp
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private ORDERSTATE orderstate;

    @Column
    private BigDecimal totalPrice;

    @ManyToOne(targetEntity = Adress.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "adress_fk", referencedColumnName = "adressId")
    private Adress adress;

    @OneToMany(targetEntity = Burger.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_fk", referencedColumnName = "orderId")
    private List<Burger> burgers;

    public DeliveryOrder() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public ORDERSTATE getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(ORDERSTATE orderstate) {
        this.orderstate = orderstate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(List<Burger> burgers) {
        this.burgers = burgers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryOrder)) return false;
        DeliveryOrder that = (DeliveryOrder) o;
        return Objects.equals(getOrderId(), that.getOrderId()) &&
                Objects.equals(getCreated(), that.getCreated()) &&
                getOrderstate() == that.getOrderstate() &&
                Objects.equals(getTotalPrice(), that.getTotalPrice()) &&
                Objects.equals(getAdress(), that.getAdress()) &&
                Objects.equals(getBurgers(), that.getBurgers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getCreated(), getOrderstate(), getTotalPrice(), getAdress(), getBurgers());
    }
}
