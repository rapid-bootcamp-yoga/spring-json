package com.springjson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @TableGenerator(name = "address_id_generator", table = "json_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "address_id", initialValue = 0, allocationSize = 0)
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

    @Column(name = "customers_id", insertable = false, updatable = false)
    private Long customersId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false)
    private CustomerEntity customers;

    public AddressEntity(AddressModel model) {
        BeanUtils.copyProperties(model, this);
    }
}
