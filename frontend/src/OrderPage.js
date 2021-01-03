import React, { useState, useEffect } from "react";

import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Link from "./Link";
import Paper from "@material-ui/core/Paper";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Button from "@material-ui/core/Button";
import Person from "@material-ui/icons/Person";
import Typography from "@material-ui/core/Typography";

import BuildControls from "./common/buildControls/BuildControls";
import Burger from "./common/burger/Burger";
import { Box } from "@material-ui/core";
import { connect } from "react-redux";
import axios from "axios";

const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  },
}));

function OrderPage(props) {
  const classes = useStyles();

  const [tabIndex, setTabIndex] = useState(0);

  const handleTabClick = (_, index) => {
    setTabIndex(index);
  };

  useEffect(() => {
    if(props.email !== undefined){
      axios.get(`http://localhost:8080/api/customer-detail?email=${props.email}`, {
        headers: {
          Authorization: 'Bearer ' + props.token //the token is a variable which holds the token
        }
       })
      .then(
        (res) => {
          props.initUser(res.data.id, res.data.customerType);
        },
        (err) => console.log(err)
      );
    }
  }, []);

  const [ingredients, setIngredients] = useState([{}]);
  const [counts, setCounts] = useState([
    {
      type: "salad",
      count: 0,
      price: 10,
    },
    {
      type: "bacon",
      count: 0,
      price: 15,
    },
    {
      type: "cheese",
      count: 0,
      price: 8,
    },
    {
      type: "meat",
      count: 0,
      price: 20,
    },
  ]);

  const [totalPrice, setTotalPrice] = useState(0);

  const controls = [
    { label: "Salát", type: "salad" },
    { label: "Slanina", type: "bacon" },
    { label: "Sýr", type: "cheese" },
    { label: "Maso", type: "meat" },
  ];

  const calculateTotalPrice = () => {
    let pomPrice = 0;
    counts.forEach((item) => {
      pomPrice += item.count * item.price;
    });
    setTotalPrice(pomPrice);
  };

  const addIngredient = (ingredientType) => {
    setIngredients([...ingredients, ingredientType]);
    let pom = counts.slice();
    pom.forEach((obj) => {
      if (obj.type === ingredientType) {
        obj.count++;
      }
    });
    setCounts(pom);
    calculateTotalPrice();
  };

  const removeIngredient = (ingredientType) => {
    const pom = ingredients.slice();
    pom.splice(ingredients.indexOf(ingredientType), 1);
    setIngredients([...pom]);

    let p = counts.slice();
    p.forEach((obj) => {
      if (obj.type === ingredientType) {
        obj.count--;
      }
    });
    setCounts(p);
    calculateTotalPrice();
  };

  const createBurgrOrder = (address) => {
    var count = {};
    ingredients.forEach(function (i) {
      count[i] = (count[i] || 0) + 1;
    });

    axios
      .post("http://localhost:8080/api/order/create-order", {
        customerId: props.userId,
        name: address.name,
        surname: address.surname,
        phone: address.phone,
        email: address.email,
        adress: {
          street: address.street,
          city: address.city,
          postalCode: 7878,
        },
        burgers: [
          {
            burgerName: "pipka",
            ingredients: [
              {
                price: count.salad !== undefined ? count.salad * 10 : 0,
                amount: count.salad !== undefined ? count.salad : 0,
                type: "salad",
              },
              {
                price: count.bacon !== undefined ? count.bacon * 15 : 0,
                amount: count.bacon !== undefined ? count.bacon : 0,
                type: "bacon",
              },
              {
                price: count.meat !== undefined ? count.meat * 20 : 0,
                amount: count.meat !== undefined ? count.meat : 0,
                type: "meat",
              },
              {
                price: count.cheese !== undefined ? count.cheese * 8 : 0,
                amount: count.cheese !== undefined ? count.cheese : 0,
                type: "cheese",
              },
            ],
          },
        ],
      })
      .then(
        (res) => {
          window.location.reload();
        },
        (error) => console.log(error)
      );
  };

  return (
    <Grid container component="main" className={classes.root}>
      <Grid item xs={false} sm={4} md={7} direction="row-reverse">
        <AppBar position="fixed" elevation={0} color="primary">
          <Toolbar disableGutters style={{ marginLeft: "5em" }}>
            <Button
              variant="contained"
              color="secondary"
              startIcon={<Person />}
              size="large"
              component={Link}
              href="/"
              onClick={() => props.logout()}
            >
              {props.token ? "Odhlásit se" : "Přihlásit se"}
            </Button>
            <Tabs
              value={tabIndex}
              onChange={handleTabClick}
              style={{ marginLeft: "2em" }}
            >
              <Tab
                label="Burger"
                disableRipple
                component={Link}
                href="/createOrder"
              />
              {props.token ? (
                <Tab
                  label="Objednávky"
                  disableRipple
                  component={Link}
                  href="/listOfOrders"
                />
              ) : null}
            </Tabs>
          </Toolbar>
        </AppBar>
        <Box mt={5} style={{ marginTop: "6em", textAlign: "center" }}>
          <Typography component="h2" variant="h5">
            {`Cena : ${totalPrice},-`}
          </Typography>
        </Box>
        <Burger ingredients={ingredients} />
      </Grid>
      <Grid
        item
        xs={12}
        sm={8}
        md={5}
        component={Paper}
        elevation={6}
        style={{ zIndex: "1200" }}
      >
        <BuildControls
          controls={controls}
          ing={ingredients}
          add={addIngredient}
          remove={removeIngredient}
          counts={counts}
          createOrderCallback={createBurgrOrder}
        />
      </Grid>
    </Grid>
  );
}

const mapDispatchToProps = (dispatch) => {
  return {
    logout: (token) =>
      dispatch({
        type: "LOGOUT",
      }),
    initUser: (userId, customerType) =>
      dispatch({
        type: "INITUSER",
        userId: userId,
        customerType: customerType
      }),
  };
};

const mapStateToProps = (state) => {
  return {
    token: state.token,
    email: state.email,
    userId: state.userId
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(OrderPage);
