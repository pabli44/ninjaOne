package com.ninjaone.backendinterviewproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Order {

    private Long id;
    private Integer devices;
    private String deviceItems;
}
