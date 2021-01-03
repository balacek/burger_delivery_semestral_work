import React, { useEffect, useState } from "react";

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

  const [orders, setOrders] = useState();

  useEffect(() => {
    if(props.customerType === "ADMINISTATOR"){
      axious.get(`http://localhost:8080/api/orders`, {
        headers: {
          Authorization: 'Bearer ' + props.token //the token is a variable which holds the token
        }}).then(res => {
            setOrders(res)
        }, (err) => console.log(err))
    }else{
      axious.get(`http://localhost:8080/api/customer-orders?email=${props.email}`, {
      headers: {
        Authorization: 'Bearer ' + props.token //the token is a variable which holds the token
      }}).then(res => {
          setOrders(res)
      }, (err) => console.log(err))
    }

 }, []);

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
    userId: state.userId,
    email: state.email,
    customerType: state.customerType
  };
};

export default connect(mapStateToProps, null)(orders);
