import React, { Component } from 'react';
import PropTypes from 'prop-types';

import useStyles from './BurgerIngredient_Styles';

const BurgerIngredient = (props) => {
    let ingredient = null;

    const classes = useStyles();
    
    const getIngredient = (type) => {
        switch ( type ) {
            case ( 'bread-bottom' ):
                ingredient = <div className={classes.BreadBottom}></div>;
                break;
            case ( 'bread-top' ):
                ingredient = (
                    <div className={classes.BreadTop}/>
                );
                break;
            case ( 'meat' ):
                ingredient = <div className={classes.Meat}></div>;
                break;
            case ( 'cheese' ):
                ingredient = <div className={classes.Cheese}></div>;
                break;
            case ( 'bacon' ):
                ingredient = <div className={classes.Bacon}></div>;
                break;
            case ( 'salad' ):
                ingredient = <div className={classes.Salad}></div>;
                break;
            default:
                ingredient = null;
        }

        return ingredient;
    }

    return (
        getIngredient(props.type)
    )
}

export default BurgerIngredient;