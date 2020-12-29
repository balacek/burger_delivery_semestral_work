import React from "react";

import Grid from "@material-ui/core/Grid";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";

import Banner from "./common/banner";
import OrderTable from "./orderTable/OrderTable";
import Copyright from './common/copyRight';

const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  },
  avatar: {
    margin: theme.spacing(1),
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
}));

const orders = () => {
  const classes = useStyles();
  return (
    <Grid container component="main" className={classes.root}>
      <Grid item xs={false} sm={4} md={7}>
        <OrderTable />
      </Grid>
      <Grid
        item
        xs={12}
        sm={8}
        md={5}
        component={Paper}
        elevation={6}
        style={{ zIndex: "1300", textAlign: 'center' }}
        square
      >
        <Banner />
        <div style={{ display: "inline-flex" }}>
          <Typography component="h1" variant="h5" style={{ margin: "auto" }}>
            Detail objednávky
          </Typography>
          <Avatar
            className={classes.avatar}
            variant="square"
            src="assets/svg/burger.svg"
          />
        </div>
        <Box mt={2}>
          <Copyright />
        </Box>
      </Grid>
    </Grid>
  );
};

export default orders;
