import React, { useEffect } from "react";

import Grid from "@material-ui/core/Grid";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { connect } from "react-redux";
import axious from 'axios';

import Banner from "./common/banner";
import OrderTable from "./orderTable/OrderTable";
import Copyright from "./common/copyRight";
import OrderDetail from "./common/orderDetail/OrderDetail";

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

const orders = (props) => {
  const classes = useStyles();

 /* useEffect(() => {

    console.log('jsem tu ')
    console.log(props.token)

    axious.get('http://localhost:8080')

 }, []);*/

  const customerOrder = {
    price: 154,
    status: "DELIVERED",
    adress: {
      city: "Praha",
      street: "Jizeraska 390",
      postalCode: 40011,
    },
    burgers: [
      {
        name: "Hovezi burger",
        ingredients: [
          { amount: 3, type: "salad" },
          { amount: 2, type: "bacon" },
          { amount: 0, type: "cheese" },
          { amount: 9, type: "meat" },
        ],
      },
      {
        name: "Kureci burger",
        ingredients: [
          { amount: 1, type: "salad" },
          { amount: 1, type: "bacon" },
          { amount: 8, type: "cheese" },
          { amount: 0, type: "meat" },
        ],
      },
    ],
  };
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
        style={{ zIndex: "1300", textAlign: "center" }}
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
        <Grid item justify="center">
          <OrderDetail order={customerOrder} />
        </Grid>
        <Box mt={3} style={{marginBottom: '2.5em'}}>
          <Copyright />
        </Box>
      </Grid>
    </Grid>
  );
};

const mapStateToProps = (state) => {
  return {
    token: state.token,
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(orders);
