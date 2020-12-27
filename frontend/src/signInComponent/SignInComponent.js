import React from "react";

import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Link from "@material-ui/core/Link";
import Box from "@material-ui/core/Box";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import Copyright from "../common/copyRight";

const useStyles = makeStyles((theme) => ({
  paper: {
    margin: theme.spacing(1, 4, 1, 4),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
  },
  avatar: {
    margin: theme.spacing(1),
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  submit: {
    margin: theme.spacing(1, 0, 2),
  },
}));

const signInComponent = (props) => {
  const classes = useStyles();

  return (
    <div className={classes.paper}>
      <div style={{ display: "inline-flex" }}>
        <Typography component="h1" variant="h5" style={{ margin: "auto" }}>
          Přihlásit se
        </Typography>
        <Avatar
          className={classes.avatar}
          variant="square"
          src="assets/svg/burger.svg"
        />
      </div>

      <form className={classes.form} noValidate>
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          id="email"
          label="Email Address"
          name="email"
          autoComplete="email"
          autoFocus
        />
        <TextField
          variant="outlined"
          margin="normal"
          required
          fullWidth
          name="password"
          label="Password"
          type="password"
          id="password"
          autoComplete="current-password"
        />
        <FormControlLabel
          control={<Checkbox value="remember" color="secondary" />}
          label="Uložit přihlašovací údaje"
        />
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="secondary"
          className={classes.submit}
        >
          Přihlásit se
        </Button>
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className={classes.submit}
        >
          Pokračovat bez přihlášení
        </Button>
        <Grid container>
          <Grid item xs>
            <Link variant="body2" color="secondary" style={{cursor: 'pointer'}} onClick={() => props.changeStepCallback(3)}>
              Zapomenuté heslo?
            </Link>
          </Grid>
          <Grid item>
            <Link variant="body2" color="secondary" style={{cursor: 'pointer'}} onClick={() => props.changeStepCallback(2)}>
              {"Nemáte účet? Registrujte se"}
            </Link>
          </Grid>
        </Grid>
        <Box mt={5}>
          <Copyright />
        </Box>
      </form>
    </div>
  );
};

export default signInComponent;
