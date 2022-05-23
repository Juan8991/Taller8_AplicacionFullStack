/**
 * Se importan los archivos necesarios para usar react y material-ui
 */
import React, { useEffect, useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import { Container, Paper, Button } from '@material-ui/core';

/**
 * Se establece uel estilo para la interfaz
 */
const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
    },
  },
}));
/**
 * Estación permite visualizar la lista de contacto guardada en la base de datos MYSQL;
 * ademas, permite interactuar con la base de datos como por ejemplo agregar un nuevo contacto
 * a la lista de contactos y eliminar un contacto de la lista de contactos
 */
export default function Contact() {
  /**
   * Crea una hoja de estilos
   */
  const paperStyle = { padding: '50px 20px', width: 600, margin: "20px auto" }
  /**
   * La funcion useState nos permite crear internamente una variable 
   * donde podremos almacenar el estado de nuestro componente. 
   * Acepta un valor inicial para esa variable y devuelve un array con
   *  dos elementos, el valor de la variable y la función para modificarla.
   */
  const [name, setName] = useState('')
  const [phoneNumber, setPhoneNumber] = useState('')
  const [email, setEmail] = useState('')
  const [dateOfBirth, setDateOfBirth] = useState('')
  const [idContact, deleteContact] = useState('')
  const [contacts, setContacts] = useState([])
  const classes = useStyles();
  /**
   * esta funcion es la que permite agregar un nuevo 
   * contacto a la lista de contactos, mediante el uso 
   * de fetch
   */
  const handleClick = (e) => {
    e.preventDefault()
    const contact = { name, phoneNumber, email, dateOfBirth }
    console.log(contact)
    fetch("http://localhost:8080/contacts/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      mode: 'cors',
      cache: 'default',
      body: JSON.stringify(contact)

    }).then(() => {
      console.log("New Contact added")
    })
  }
  /**
   * Esta funcion es la que permite mostrar todos los 
   * contactos almacenados en la base de datos MYSQL
   */
  useEffect(() => {
    fetch("http://localhost:8080/contacts/getAll")
      .then(res => res.json())
      .then((result) => {
        setContacts(result);
        console.log(result)
      }
      )
  }, [])
  /**
   * Esta funcion es la que permite eliminar un contacto 
   * por medio de su ID
   */
  const deleteClick = (e) => {
    e.preventDefault()
    const idDelete = idContact
    console.log(idDelete)
    fetch("http://localhost:8080/contacts/delete/" + idDelete, {
      method: "DELETE",
      headers: { "Content-Type": "application/json" },
      mode: 'cors',
      cache: 'default',
      body: JSON.stringify(idDelete)

    }).then(() => {
      console.log("Contact Deleted")
    })

  }

  return (
    /**
     * Elementos creados mediante material-ui
     * y react
     */
    <Container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "black" }}>Add Contact</h1>
        <h3>Reaload the page to see the changes</h3>
        <form className={classes.root} noValidate autoComplete="off">

          <TextField id="outlined-basic" label="Contact Name" variant="outlined" fullWidth
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
          <TextField id="outlined-basic" label="Contact Phone" variant="outlined" fullWidth
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
          />
          <TextField id="outlined-basic" label="Contact email" variant="outlined" fullWidth
            value={email}
            onChange={(e) => setEmail(e.target.value)}
          />
          <TextField id="outlined-basic" label="Contact Birthday" variant="outlined" fullWidth
            value={dateOfBirth}
            onChange={(e) => setDateOfBirth(e.target.value)}
          />

          <Button variant="contained" color="primary" onClick={handleClick}>
            Submit
          </Button>
        </form>

      </Paper>


      <Paper elevation={3} style={paperStyle}>
        <format className={classes.root} noValidate autoComplete="off">
          <h1>Delete Contact</h1>
          <h3>Reaload the page to see the changes</h3>
          <TextField id="outlined-basic" label="ID to Delete" variant="outlined"
            value={idContact}
            onChange={(e) => deleteContact(e.target.value)}
          /><br />
          <Button variant="contained" color="secondary" onClick={deleteClick}>
            Delete
          </Button></format>
      </Paper>
      <h1>Contacts List</h1>
      <h3>Reaload the page to see the changes</h3>
      <Paper elevation={3} style={paperStyle}>
        {(contacts.map(contact => (
          <Paper elevation={6} style={{ margin: "10px", padding: "15px", textAlign: "left" }} key={contact.id}>
            Id:{contact.id}<br />
            Name: {contact.name}<br />
            Email:{contact.email}<br />
            Date Of Birth:{contact.dateOfBirth}
          </Paper>
        )))}
      </Paper>



    </Container>
  );
}