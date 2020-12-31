import React from "react";

import TextField from "@material-ui/core/TextField";
import Avatar from "@material-ui/core/Avatar";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import useStyles from "./ModalContent_Styles";

const modalContent = (props) => {
  const classes = useStyles();

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
          <TextField
            variant="outlined"
            margin="normal"
            required
            id="name"
            label="Jméno"
            name="name"
            required
            autoFocus
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
            className={classes.textfield}
          />
           <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Email"
            type="text"
            id="email"
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Ulice"
            required
            type="text"
            id="street"
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
            className={classes.textfield}
          />
          <div>
           <FormControlLabel
          control={<Checkbox value="remember" color="secondary" checked />}
          label="Zasílat novinky o změnách"/>
          </div>
          <div style={{display: 'inline-grid', width: '250px', marginBottom: '1.5em'}}>
        <Button
          type="submit"
          variant="contained"
          color="secondary"
          className={classes.submit}
        >
          Objednat
        </Button>
        <Button
          type="back"
          variant="contained"
          color="primary"
          onClick={(e) => {
            e.preventDefault();
            props.close(false)
          }}
        >Zpět</Button>
        </div>
        </div>
      </form>
    </div>
  );
};

export default modalContent;
