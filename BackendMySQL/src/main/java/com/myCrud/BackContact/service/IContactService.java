package com.myCrud.BackContact.service;

import com.myCrud.BackContact.domain.ContactDomain;

import java.util.List;

/**
 * Crea la directriz por al cual se debe regir los metodos que llevara ContactService
 * @autor Juan Ramirez
 * @version 1.00.00 13/03/2022
 */
public interface IContactService {

    public ContactDomain save(ContactDomain contact);
    public List<ContactDomain> list();
    public void delete(ContactDomain contact);


}
