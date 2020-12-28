import React, { useState } from "react";

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

const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  },
}));

export default function OrderPage() {
  const classes = useStyles();

  const [tabIndex, setTabIndex] = useState(0);

  const handleTabClick = (_, index) => {
    setTabIndex(index);
  };

  const [ingredients, setIngredients] = useState([{}]);
  const [counts, setCounts] = useState([
    {
      type: "salad",
      count: 0,
    },
    {
      type: "bacon",
      count: 0,
    },
    {
      type: "cheese",
      count: 0,
    },
    {
      type: "meat",
      count: 0,
    },
  ]);

  const controls = [
    { label: "Salad", type: "salad" },
    { label: "Bacon", type: "bacon" },
    { label: "Cheese", type: "cheese" },
    { label: "Meat", type: "meat" },
  ];

  const addIngredient = (ingredientType) => {
    setIngredients([...ingredients, ingredientType]);
    let pom = counts.slice();
    pom.forEach((obj) => {
      if (obj.type === ingredientType) {
        obj.count++;
      }
    });
    setCounts(pom);
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
              >
                Přihlásit
              </Button>
            <Tabs
              value={tabIndex}
              onChange={handleTabClick}
              style={{marginLeft: '2em'}}
            >
             
              <Tab label="Burger" disableRipple component={Link} href="" />
              <Tab label="Objednávky" disableRipple component={Link} href="" />
            </Tabs>
          </Toolbar>
        </AppBar>
        <Box mt={5} style={{ marginTop: "6em", textAlign: "center" }}>
          <Typography component="h2" variant="h5">
            Cena: 40
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
        style={{ zIndex: "1500" }}
      >
        <BuildControls
          controls={controls}
          ing={ingredients}
          add={addIngredient}
          remove={removeIngredient}
          counts={counts}
        />
      </Grid>
    </Grid>
  );
}
