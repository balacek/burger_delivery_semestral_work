import React from "react";

import useStyles from "./BuildControls_Styles";
import BuildControl from "./BuildControl/BuildControl";
import Box from "@material-ui/core/Box";
import ButtonBase from '@material-ui/core/ButtonBase';
import Typography from '@material-ui/core/Typography';
import Avatar from '@material-ui/core/Avatar';

import Copyright from "../../common/copyRight";

const buildControls = (props) => {
  const classes = useStyles();

  return (
    <div className={classes.paper}>
      <div className={classes.buildControls}>
      <div style={{ display: "inline-flex", marginTop: '1em'  }}>
        <Typography component="h1" variant="h5" >
          Vytvoř si burger
        </Typography>
        <Avatar
          style={{marginLeft: '0.5em'}}
          variant="square"
          src="assets/svg/burger.svg"
        />
      </div>
        {props.controls.map((ctrl) => (
          <BuildControl
            key={ctrl.label}
            label={ctrl.label}
            type={ctrl.type}
            add={props.add}
            remove={props.remove}
            disabled={false}
            ing={props.ing}
          />
        ))}
      </div>
      <ButtonBase
          focusRipple
          key='Burgers'
          className={classes.image}
          focusVisibleClassName={classes.focusVisible}
          style={{
            width: '100%',
          }}
        >
          <span
            className={classes.imageSrc}
            style={{
              backgroundImage: `url(assets/images/order.jpg)`,
            }}
          />
          <span className={classes.imageBackdrop} />
          <span className={classes.imageButton}>
            <Typography
              component="span"
              variant="subtitle1"
              color="inherit"
              className={classes.imageTitle}
            >
              Objednat
              <span className={classes.imageMarked} />
            </Typography>
          </span>
        </ButtonBase>
      <Box mt={5}>
        <Copyright />
      </Box>
    </div>
  );
};

export default buildControls;
