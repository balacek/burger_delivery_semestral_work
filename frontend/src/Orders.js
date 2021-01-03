import React, { useEffect, useState } from "react";

import Grid from "@material-ui/core/Grid";
import { makeStyles } from "@material-ui/core/styles";
import Paper from "@material-ui/core/Paper";
import Avatar from "@material-ui/core/Avatar";
import Box from "@material-ui/core/Box";
import Typography from "@material-ui/core/Typography";
import { connect } from "react-redux";
import axious from "axios";

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

  const [listOR, setlistOR] = useState();
  const [customerOrder, setCustomerOrder] = useState();
  const [lastId, setLastId] = useState();

  const loadData = () => {
    if (props.customerType === "ADMINISTATOR") {
      axious
        .get(`http://localhost:8080/api/orders`, {
          headers: {
            Authorization: "Bearer " + props.token, //the token is a variable which holds the token
          },
        })
        .then(
          (res) => {
            setlistOR(res.data);
          },
          (err) => console.log(err)
        );
    } else {
      axious
        .get(`http://localhost:8080/api/customer-orders?email=${props.email}`, {
          headers: {
            Authorization: "Bearer " + props.token, //the token is a variable which holds the token
          },
        })
        .then(
          (res) => {
            setlistOR(res.data);
          },
          (err) => console.log(err)
        );
    }
  }

  useEffect(() => {
    loadData();
  }, []);

  const setOrderAsDelivered = () => {
    axious
      .post(`http://localhost:8080/api/order-delivered?orderId=${lastId}`,{}, {
        headers: {
          Authorization: "Bearer " + props.token, //the token is a variable which holds the token
        }
      })
      .then(
        (res) => {
          setCustomerOrder(undefined);

          loadData();
        },
        (err) => console.log(err)
      );
  };

  const showOrderDetail = (id) => {
    const item = listOR.filter((i) => i.orderId === id);

    setLastId(id);
    setCustomerOrder({
      price: item[0].totalPrice,
      status: item[0].orderstate,
      adress: {
        city: item[0].adress.city,
        street: item[0].adress.street,
        postalCode: item[0].adress.postalCode,
      },
      burgers: [
        {
          name: item[0].burgers[0].burgerName,
          ingredients: item[0].burgers[0].ingredients,
        },
      ],
    });
  };

  return (
    <Grid container component="main" className={classes.root}>
      <Grid item xs={false} sm={4} md={7}>
        <OrderTable listOrders={listOR} orderClickCallback={showOrderDetail} />
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
          <OrderDetail
            order={customerOrder}
            isAdmin={props.customerType === "ADMINISTATOR"}
            orderDeliveredCallback={setOrderAsDelivered}
          />
        </Grid>
        <Box mt={3} style={{ marginBottom: "2.5em" }}>
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
    customerType: state.customerType,
  };
};

export default connect(mapStateToProps, null)(orders);
