import React, { useState } from "react";

import TextField from "@material-ui/core/TextField";
import Avatar from "@material-ui/core/Avatar";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Button from "@material-ui/core/Button";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import axios from "axios";

import Copyright from "../common/copyRight";
import useStyles from "./RegisterComponent_Styles";

const registerComponent = (props) => {
  const [name, setName] = useState();
  const [surname, setSurname] = useState();
  const [email, setEmail] = useState();
  const [password, setPassword] = useState();
  const [phone, setPhone] = useState();
  const [allowNewsletters, setAllowNewsletter] = useState(true);

  const createAccount = (e) => {
    e.preventDefault()
    axios.post("http://localhost:8080/api/customer/create-customer", {
      name: name,
      surname: surname,
      email: email,
      password: password,
      phone: phone,
      allowNewsletters: allowNewsletters
    }).then(res => {
      props.changeStepCallback(1);
    }, (error) => console.log(error))
  };

  const classes = useStyles();
  return (
    <div className={classes.paper}>
      <div style={{ display: "inline-flex" }}>
        <Typography component="h1" variant="h5" style={{ margin: "auto" }}>
          Registrace
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
            autoFocus
            onChange={(e) => setName(e.target.value)}
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
            onChange={(e) => setSurname(e.target.value)}
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            name="email"
            label="Email"
            type="text"
            onChange={(e) => setEmail(e.target.value)}
            id="email"
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            required
            name="password"
            label="Heslo"
            type="password"
            id="password"
            onChange={(e) => setPassword(e.target.value)}
            autoComplete="current-password"
            className={classes.textfield}
          />
          <TextField
            variant="outlined"
            margin="normal"
            name="tel"
            label="Telefon"
            type="tel"
            id="tel"
            onChange={(e) => setPhone(e.target.value)}
            className={classes.textfield}
          />
        </div>
        <FormControlLabel
          control={
            <Checkbox
              value="remember"
              color="secondary"
              onChange={() => setAllowNewsletter(!allowNewsletters)}
            />
          }
          label="Souhlasím se zpracováním osobních údajů"
        />
        <FormControlLabel
          control={<Checkbox value="remember" color="secondary" checked />}
          label="Zasílat novinky o změnách"
        />
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="secondary"
          className={classes.submit}
          onClick={createAccount}
        >
          Registrovat
        </Button>
        <Button
          type="back"
          fullWidth
          variant="contained"
          color="primary"
          className={classes.back}
          onClick={() => props.changeStepCallback(1)}
        >
          Zpět
        </Button>
        <Box mt={2}>
          <Copyright />
        </Box>
      </form>
    </div>
  );
};

export default registerComponent;
