package com.springjson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springjson.model.SchoolsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "schools_tab")
public class SchoolsEntity {
    @Id
    @TableGenerator(name = "schools_id_generator", table = "json_tab",
                    pkColumnName = "gen_name", valueColumnName = "gen_value",
                    pkColumnValue = "schools_id", initialValue = 0, allocationSize = 0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "schools_id_generator")
    private Long id;

    @Column(name = "schools_title", length = 80, nullable = false)
    private String title;
    @Column(name = "schools_name", nullable = false)
    private String name;
    @Column(name = "schools_level", nullable = false)
    private String level;

    @Column(name = "customers_id",insertable = false, updatable = false )
    private Long customersId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customers_id", nullable = false )
    private CustomerEntity customers;

    public SchoolsEntity(SchoolsModel model){
        BeanUtils.copyProperties(model, this);
    }
}
