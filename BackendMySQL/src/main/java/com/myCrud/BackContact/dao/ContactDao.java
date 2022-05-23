package com.myCrud.BackContact.dao;

import com.myCrud.BackContact.domain.ContactDomain;
import org.springframework.data.repository.CrudRepository;

/**
 * Crea las conecciones entre el modelo de la base de datos ContactDomain y
 * y el Repositorio
 * @autor Juan Ramirez
 * @version 1.00.00 13/03/2022
 */
public interface ContactDao extends CrudRepository<ContactDomain, Long> {

}
