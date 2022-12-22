package com.springjson.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address_tab")

public class AddressEntity {
    @Id

    private Long id;
    @Column(name = "address_name", nullable = false)
    private String name;
    private String address;
    private String village;
    private String district;
    private String city;
    private String province;
}
