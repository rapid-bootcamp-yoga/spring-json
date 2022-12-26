package com.springjson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springjson.model.AddressModel;
import com.springjson.model.CustomerModel;
import com.springjson.model.SchoolsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.util.*;

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
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "customer_dateOfBirth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "customer_placeOfBirth")
    private String placeOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private List<AddressEntity> address = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private List<SchoolsEntity> schools = new ArrayList<>();

    public CustomerEntity(CustomerModel model){
        BeanUtils.copyProperties(model , this);
    }

    public CustomerEntity(Long id, String fullName, String gender) {
        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
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

    //nambah Schools
    public void addDetailListSchools(List<SchoolsModel> detailsSchools){
        for (SchoolsModel nameSchool: detailsSchools) {
            SchoolsEntity detailsSchoolsEntity = new SchoolsEntity(nameSchool);
            addSchools(detailsSchoolsEntity);
        }
    }

    public void addSchools(SchoolsEntity detailsSchoolsEntity ){
        this.schools.add(detailsSchoolsEntity);
        detailsSchoolsEntity.setCustomers(this);
    }
}
