import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  form: {
    width: "100%", // Fix IE 11 issue.
    marginTop: theme.spacing(1),
  },
  avatar: {
    margin: theme.spacing(1),
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
  paper: {
    margin: theme.spacing(1, 4, 1, 4),
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    backgroundColor: theme.palette.background.paper,
    maxWidth: '65%',
    borderRadius: '20px'
  },
  textfield: {
    margin: theme.spacing(1),
  },
  submit: {
    height: "3.5em",
    margin: theme.spacing(1, 0, 2),
  },
  back: {
    margin: theme.spacing(1, 0, 2),
  },
}));

export default useStyles;
