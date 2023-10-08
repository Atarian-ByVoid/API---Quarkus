package com.example.entitys;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
public class User extends PanacheEntity {
    public String name;
    public Long age;
    public String username;
}
