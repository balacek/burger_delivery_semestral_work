import React from 'react';

import BurgerIngredient from './BurgerIngredient/BurgerIngredient';
import useStyles from './Burger_Styles';

const burger = ( props ) => {

    const classes = useStyles();
    console.log("ahoj")
    console.log(props.ingredients)
    return (
        <div className={classes.Burger}>
            <BurgerIngredient type="bread-top" />
            {
                props.ingredients.length === 0 ? <p>Přidejte ingredience</p> : null
            }
            {
                props.ingredients.map((ingredient, id) => {
                    return <BurgerIngredient key={id} type={ingredient} />
                })
            }
            <BurgerIngredient type="bread-bottom" />
        </div>
    );
};

export default burger;