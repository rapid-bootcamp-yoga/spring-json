package com.springjson.entity;

import com.springjson.model.AddressModel;
import com.springjson.model.CustomerModel;
import com.springjson.model.SchoolsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers_tab")
public class CustomerEntity {
    @Id
    @TableGenerator(name = "customers_id_generator", table = "json_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue = "customers_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "customers_id_generator")
    private Long id;
    @Column(name = "customer_fullName", nullable = false)
    private String fullName;
    @Column(name = "customer_gender", nullable = false)
    private String gender;
    @Column(name = "customer_dateOfBirth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "customer_placeOfBirth", nullable = false)
    private String placeOfBirth;

    @OneToMany(mappedBy = "customers")
    private Set<AddressEntity> address = new HashSet<>();

    @OneToMany(mappedBy = "customers")
    private Set<SchoolsEntity> schools = new HashSet<>();

    public CustomerEntity(CustomerModel model){
        BeanUtils.copyProperties(model , this);
    }

    //nambah address
    public void addDetailAddress(AddressEntity detailaddressEntity){
        this.address.add(detailaddressEntity);
        detailaddressEntity.setCustomers(this);
    }

    public void addDetailListAddress(List<AddressModel> detailsAddress){
        for(AddressModel item: detailsAddress){
            AddressEntity detailsAddressEntity = new AddressEntity(item);
            addDetailAddress(detailsAddressEntity);
        }
    }
}
