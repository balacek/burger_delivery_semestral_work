import React from 'react';

import { makeStyles } from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';

import LeftContainer from './leftContainer/LeftContainer';
import RightContainer from './rightContainer/RightContainer';

const useStyles = makeStyles((theme) => ({
    root: {
      height: "100vh",
    }
}));

export default function IndexPage() {
  const classes = useStyles();

  return (
    <Grid container component="main" className={classes.root}>
     <LeftContainer />
     <RightContainer />
    </Grid>
  );
}