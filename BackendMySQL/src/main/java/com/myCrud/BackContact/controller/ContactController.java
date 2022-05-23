package com.myCrud.BackContact.controller;

import com.myCrud.BackContact.domain.ContactDomain;
import com.myCrud.BackContact.service.ContactService;
import com.myCrud.BackContact.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * La clase controlador nos permite recibir las peticiones web, y procesarlas mediante la
 * implementacion de ContactService que a su vez esta implementando IContactService
 * @autor Juan Ramirez
 * @version 1.00.00 13/03/2022
 */
@Slf4j
@RestController
@RequestMapping("/contacts")
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactService contactService;
    private Response response = new Response();

    /**
     * Este metodo utiliza el metodo de solicitud HTTP GET y hace uso de la clase ContactDao y sus metodos
     * para devolver la lista de contactos
     * @return la lista de contactos.
     * @autor Juan Ramirez
     * @version 1.00.00 13/03/2022
     */
    @GetMapping("/getAll")
    public List<ContactDomain> list(){
        return contactService.list();
    }
    /**
     * Este metodo utiliza el metodo de solicitud HTTP POST y hace uso de la clase ContactDao y sus metodos
     * para un anuevo contacto a la lista de contactos
     * @return un mensaje de que ha sido guardado el nuevo contacto
     * @autor Juan Ramirez
     * @version 1.00.00 13/03/2022
     */
    @PostMapping("/add")
    public String add(@RequestBody ContactDomain contact){
        contactService.save(contact);
        return "New student is added";
    }
    /**
     * Este metodo utiliza el metodo de solicitud HTTP DELETE y hace uso de la clase ContactDao y sus metodos
     * para un anuevo contacto a la lista de contactos
     * @return un mensaje de que ha sido guardado el nuevo contacto
     * @autor Juan Ramirez
     * @version 1.00.00 13/03/2022
     */
    @DeleteMapping(path="/delete/{id}")
    public ResponseEntity<ContactDomain> deleteContact( ContactDomain contact){
        contactService.delete(contact);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

}
