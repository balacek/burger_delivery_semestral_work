import React  from 'react';

import useStyles from './ModalContent_Styles';

const modalContent = () => {

    const classes = useStyles();

    return (
        <div className={classes.paper}>
            <h2 id="transition-modal-title">Transition modal</h2>
            <p id="transition-modal-description">react-transition-group animates me.</p>
          </div>
    )
}

export default modalContent;