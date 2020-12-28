
import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles(theme => ({
    BuildControl: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        margin: '5px 0'
      },
      Button: {
        display: 'block',
        font: 'inherit',
        padding: '5px',
        margin: '0 5px',
        width: '80px',
        border: '1px solid #AA6817',
        cursor: 'pointer',
        outline: 'none'
      },
      Label: {
        padding: '10px',
        fontWeight: 'bold',
        fontSize: '1rem',
        width: '80px',
        textAlign: 'center'
      }
}));

export default useStyles;