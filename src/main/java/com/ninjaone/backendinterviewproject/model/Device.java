package com.ninjaone.backendinterviewproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Device {

    @Id
    private Long id;

    private String systemName;

    private String type;

    private double price;
}
