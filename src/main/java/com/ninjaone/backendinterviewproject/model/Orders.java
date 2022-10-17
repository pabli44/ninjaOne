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
public class Orders {

    @Id
    private Long id;

    private String deviceItems;

    private Integer devices;
}
