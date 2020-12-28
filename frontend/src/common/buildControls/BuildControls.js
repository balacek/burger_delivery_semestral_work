import React from "react";
import useStyles from "./BuildControls_Styles";
import BuildControl from "./BuildControl/BuildControl";
import Box from "@material-ui/core/Box";
import ButtonBase from '@material-ui/core/ButtonBase';
import Typography from '@material-ui/core/Typography';
import Avatar from '@material-ui/core/Avatar';
import Modal from '@material-ui/core/Modal';
import Backdrop from '@material-ui/core/Backdrop';
import Fade from '@material-ui/core/Fade';

import Copyright from "../../common/copyRight";
import ModalContent from '../../common/modalContent/ModalContent';

const buildControls = (props) => {
  const classes = useStyles();

  const [open, setOpen] = React.useState(false);

  const handleOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

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
            count={props.counts.filter(c => c.type === ctrl.type)}
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
            height: '12em'
          }}
          onClick={() => handleOpen()}
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
      <Box mt={4}>
        <Copyright />
      </Box>

      <Modal
        aria-labelledby="transition-modal-title"
        aria-describedby="transition-modal-description"
        className={classes.modal}
        open={open}
        onClose={handleClose}
        closeAfterTransition
        BackdropComponent={Backdrop}
        BackdropProps={{
          timeout: 500,
        }}
      >
        <Fade in={open}>
          <ModalContent />
        </Fade>
      </Modal>

    </div>
  );
};

export default buildControls;
