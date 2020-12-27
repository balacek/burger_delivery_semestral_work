import React from 'React';

import Grid from '@material-ui/core/Grid';
import useStyles from './LeftContainer_Styles';


const leftContainer = () => {
    const classes = useStyles();

    return (
        <Grid item xs={false} sm={4} md={7} className={classes.MainImage} />
    )
}

export default leftContainer;