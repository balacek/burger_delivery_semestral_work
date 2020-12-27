import React from "react";

import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";

import Banner from '../common/banner';
import SignInComponent from '../signInComponent/SignInComponent';

const rightContainer = () => {

  return (
    <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
      <Banner />
    <SignInComponent />
    </Grid>
  );
};

export default rightContainer;
