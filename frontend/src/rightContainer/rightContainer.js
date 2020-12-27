import React, { useState } from "react";

import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";

import Banner from '../common/banner';
import SignInComponent from '../signInComponent/SignInComponent';
import RegisterComponent from '../registerComponent/RegisterComponent';
import ForgottenPassword from '../forgottenPassword/ForgottenPassword';

const rightContainer = () => {

  const [step, setStep] = useState(1);

  const changeStep = (step) => {
    setStep(step);
  }

  return (
    <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
      <Banner />
    {step === 1 ? <SignInComponent changeStepCallback={changeStep}/> : null}
    {step === 2 ?<RegisterComponent changeStepCallback={changeStep}/> : null}
    {step === 3 ?<ForgottenPassword changeStepCallback={changeStep}/> : null}
    </Grid>
  );
};

export default rightContainer;
