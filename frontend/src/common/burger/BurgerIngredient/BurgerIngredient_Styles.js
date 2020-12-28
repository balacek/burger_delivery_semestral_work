import makeStyles from "@material-ui/core/styles/makeStyles";

const useStyles = makeStyles((theme) => ({
  BreadBottom: {
    height: "13%",
    width: "80%",
    background: "linear-gradient(#F08E4A, #e27b36)",
    borderRadius: "0 0 30px 30px",
    boxShadow: "inset -15px 0 #c15711",
    margin: "2% auto",
  },
  BreadTop: {
    height: "20%",
    width: "80%",
    background: "linear-gradient(#bc581e, #e27b36)",
    borderRadius: "50% 50% 0 0",
    boxShadow: "inset -15px 0 #c15711",
    margin: "2% auto",
    position: "relative",
  },
  Meat: {
    width: "80%",
    height: "8%",
    background: "linear-gradient(#7f3608, #702e05)",
    margin: "2% auto",
    borderRadius: "15px",
  },
  Cheese: {
    width: "90%",
    height: "4.5%",
    margin: "2% auto",
    background: "linear-gradient(#f4d004, #d6bb22)",
    borderRadius: "20px",
  },
  Salad: {
    width: "85%",
    height: "7%",
    margin: "2% auto",
    background: "linear-gradient(#228c1d, #91ce50)",
    borderRadius: "20px",
  },
  Bacon: {
    width: "80%",
    height: "3%",
    background: "linear-gradient(#bf3813, #c45e38)",
    margin: "2% auto",
  },
}));

export default useStyles;
