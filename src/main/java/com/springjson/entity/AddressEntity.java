package com.springjson.entity;

import com.springjson.model.AddressModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_tab")
public class AddressEntity {
    @Id
    @TableGenerator(name = "address_id")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "address_id_generator")
    private Long id;
    @Column(name = "address_name", length = 100, nullable = false)
    private String name;
    @Column(name = "address_village", nullable = false)
    private String village;
    @Column(name = "address_district", nullable = false)
    private String district;
    @Column(name = "address_city", length = 100, nullable = false)
    private String city;
    @Column(name = "address_address ", nullable = false)
    private String province;

    @Column(name = "customers_id", nullable = false)
    private Long customersId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customers_id", insertable = false, updatable = false)
    private CustomerEntity customers;

    public AddressEntity(AddressModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
