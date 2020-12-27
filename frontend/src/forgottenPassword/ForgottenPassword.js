import React from "react";

import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import TextField from "@material-ui/core/TextField";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import Copyright from "../common/copyRight";

import useStyles from './ForgottenPassword_Styles';

const forgottenPassword = (props) => {
    const classes = useStyles();

  return (
    <div className={classes.paper}>
      <div style={{ display: "inline-flex" }}>
        <Typography component="h1" variant="h5" style={{ margin: "auto" }}>
          Zapomenuté heslo
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
          label="Emailová adresa"
          name="email"
          autoComplete="email"
          autoFocus
        />
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="secondary"
          className={classes.submit}
        >
          Nové heslo
        </Button>
        <Button
          type="submit"
          fullWidth
          variant="contained"
          color="primary"
          className={classes.back}
          onClick={() => props.changeStepCallback(1)}
        >
          Zpět
        </Button>
        <Box mt={5}>
          <Copyright />
        </Box>
      </form>
    </div>
  );
};

export default forgottenPassword;
