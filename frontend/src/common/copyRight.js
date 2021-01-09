import React from 'react';

import Typography from '@material-ui/core/Typography';
import Link from '@material-ui/core/Link';

const copyRight = () => {
    return (
        <Typography variant="body2" color="textSecondary" align="center">
          {'Copyright © '}
          <Link color="inherit" >
            Burger delivery s.r.o.
          </Link>{' '}
          {new Date().getFullYear()}
          {'.'}
        </Typography>
      );
}

export default copyRight;