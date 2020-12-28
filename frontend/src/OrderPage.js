import React, { useState } from "react";

import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import Paper from '@material-ui/core/Paper';

import BuildControls from './common/buildControls/BuildControls';
import Burger from './common/burger/Burger';


const useStyles = makeStyles((theme) => ({
  root: {
    height: "100vh",
  }
}));

export default function OrderPage() {
  const classes = useStyles();

  const [ingredients, setIngredients] = useState([]);

  const controls = [
    { label: "Salad", type: "salad" },
    { label: "Bacon", type: "bacon" },
    { label: "Cheese", type: "cheese" },
    { label: "Meat", type: "meat" }
  ];

  const addIngredient = (ingredientType) => {
    setIngredients([
      ...ingredients,
      ingredientType
    ])
  }

  const removeIngredient = (ingredientType) => {
    const pom = ingredients.slice();
    pom.splice(ingredients.indexOf(ingredientType), 1);
    setIngredients([
      ...pom
    ])
  }

  return (
    <Grid container component="main" className={classes.root}>
      <Grid item xs={false} sm={4} md={7} direction="row-reverse">
        <Burger ingredients={ingredients}/>
        </Grid>
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <BuildControls controls={controls} add={addIngredient} remove={removeIngredient}/>
      </Grid>
    </Grid>
  );
}
