import React from "react";

import Button from "@material-ui/core/Button";
import Grid from "@material-ui/core/Grid";
import Typography from "@material-ui/core/Typography";

import useStyles from "./BuildControl_Styles.js";

const buildControl = (props) => {
  const classes = useStyles();

  const imageUrl = `assets/images/${props.type}.png`;
  return (
    <Grid container direction="column" className={classes.BuildControl} alignContent="center">
      <Grid item>
        <div className={classes.Label} style={{display: 'inline-flex', justifyContent: 'center', alignItems: 'center'}}>
          {props.label}
          <img alt={props.type} src={imageUrl} style={{width: '45px', paddingLeft: '0.5em'}}/>
        </div>
      </Grid>
      <Grid container justify="center" alignItems="center" >
        <Grid item style={{paddingRight: '2em' }}>
          <Button
            variant="contained"
            style={{ backgroundColor: "#D39952", borderRadius: "40%"}}
            size="medium"
            onClick={() => props.remove(props.type)}
            disabled={props.ing.length === 0 || props.ing.indexOf(props.type) < 0}
          >
            <Typography component="h1" variant="h5" style={{ color: "white" }}>
              -
            </Typography>
          </Button>
        </Grid>
        <Grid item>
          <Typography component="h1" variant="h5" style={{ color: "black" }}>
            {props.count[0].count}
          </Typography>
        </Grid>
        <Grid item style={{paddingLeft: '2em' }}>
          <Button
            variant="contained"
            size="medium"
            color="secondary"
            style={{ borderRadius: "40%" }}
            onClick={() => props.add(props.type)}
          >
            <Typography component="h1" variant="h5" style={{ color: "white" }}>
              +
            </Typography>
          </Button>
        </Grid>
      </Grid>
    </Grid>
  );
};

export default buildControl;
