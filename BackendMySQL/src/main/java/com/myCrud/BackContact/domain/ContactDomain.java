package com.myCrud.BackContact.domain;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import java.io.Serializable;

/**
 * Este clase nos permite modelar nuestra base de datos MYSQL
 * Ya que nos permite relacionar los nombres de las columnas de nuestra base
 * de datos, para poder usarlos de manera mas comoda en Java ya que se usa
 * SnakeCase y en ususal usar CamelCase en java
 * @autor Juan Ramirez
 * @version 1.00.00 13/03/2022
 */
@Data
@Entity
@Table(name = "contact")
public class ContactDomain implements Serializable {
    private  static  final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Phone_Contact")
    private Long id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    /*@Column(name = "stateLogic")
    private String logicState;*/
}
