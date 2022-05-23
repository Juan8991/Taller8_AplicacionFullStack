package com.myCrud.BackContact.service;

import com.myCrud.BackContact.dao.ContactDao;
import com.myCrud.BackContact.domain.ContactDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Esta clas eejecuta la logica de la aplicación y hace uso del repositorio que
 * en este caso es ContactDao
 * @autor Juan Ramirez
 * @version 1.00.00 13/03/2022
 */
@Service
public class ContactService implements IContactService {

    @Autowired // para inyectar contactDao
    private ContactDao contactDao;

    @Override
    @Transactional(readOnly = true)
    public List<ContactDomain> list() {
        return (List<ContactDomain>) contactDao.findAll();
    }

    @Override
    @Transactional
    public ContactDomain save(ContactDomain contact) {

        return contactDao.save(contact);
    }
    @Override
    @Transactional
    public void delete(ContactDomain contact) {
        contactDao.delete(contact);
    }

}
