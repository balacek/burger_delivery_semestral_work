import React, { useState, useEffect } from "react";

import TextField from "@material-ui/core/TextField";
import Avatar from "@material-ui/core/Avatar";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";

import useStyles from "./ModalContent_Styles";

const modalContent = (props) => {
  const classes = useStyles();

  const [name, setName] = useState('');
  const [surname,setSurname] = useState('');
  const [phone, setPhone] = useState();
  const [email, setEmail] = useState('');
  const [street, setStreet] = useState('');
  const [city, setCity] = useState('');
  const [psc, setPsc] = useState();
  const [allowNewsletter, setAllowNewsletter] = useState(true);
  const [isSign, setIsSign] = useState(false);

  useEffect(() => {
      setIsSign(localStorage.getItem("token") ? true : false);
  }, )


  return (
    <div className={classes.paper}>
      <div style={{ display: "inline-flex" }}>
        <Typography component="h1" variant="h5" style={{ margin: "auto" }}>
          Objednat
        </Typography>
        <Avatar
          className={classes.avatar}
          variant="square"
          src="assets/svg/burger.svg"
        />
      </div>
      <form className={classes.form} noValidate>
        <div style={{ textAlign: "center" }}>
          {
            isSign ? null : (
            <React.Fragment>
 <TextField
            variant="outlined"
            margin="normal"
            required
            id="name"
            label="Jméno"
            name="name"
            required
            autoFocus
            onChange={ (e) => setName(e.target.value)} 
            className={classes.textfield}
          />

          <TextField
            variant="outlined"
            margin="normal"
            required
            name="surname"
            label="Příjmení"
            type="text"
            id="surname"
            onChange={ (e) => setSurname(e.target.value)} 
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Telefon"
            type="tel"
            required
            id="tel"
            onChange={ (e) => setPhone(e.target.value)} 
            className={classes.textfield}
          />
           <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Email"
            type="text"
            id="email"
            onChange={ (e) => setEmail(e.target.value)} 
            className={classes.textfield}
          />
            </React.Fragment>) 
          }
         
          
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Ulice"
            required
            type="text"
            id="street"
            onChange={ (e) => setStreet(e.target.value)} 
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Město"
            required
            type="text"
            id="city"
            onChange={ (e) => setCity(e.target.value)} 
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="PSČ"
            required
            type="tel"
            id="postalCode"
            onChange={ (e) => setPsc(e.target.value)} 
            className={classes.textfield}
          />
          <div>
            {
              isSign ? null : (
                <FormControlLabel
                control={<Checkbox value="remember" color="secondary" checked={allowNewsletter}  onChange={ () => setAllowNewsletter(!allowNewsletter)} />}
                label="Zasílat novinky o změnách" />
              )
            }
          
          </div>
          {
            props.error !== '' ? ( <div style={{backgroundColor: 'red', textAlign: 'center'}}>
          {props.error}
              </div>) : null
          }
         
          <div style={{display: 'inline-grid', width: '250px', marginBottom: '1.5em'}}>
        <Button
          type="submit"
          variant="contained"
          color="secondary"
          className={classes.submit}
          onClick={(e) => {
              e.preventDefault();
              const address = {
                name: name,
                surname: surname,
                phone: phone,
                email: email,
                street: street,
                city: city,
                psc, psc,
                allowNewsletter: allowNewsletter
              }
              props.createOrderCallback(address);
          }}
        >
          Objednat
        </Button>
        <Button
          type="back"
          variant="contained"
          color="primary"
          onClick={(e) => {
            e.preventDefault();
            props.close(false);
          }}
        >Zpět</Button>
        </div>
        </div>
      </form>
    </div>
  );
};

export default modalContent;
