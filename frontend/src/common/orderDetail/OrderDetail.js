import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import ListItemAvatar from "@material-ui/core/ListItemAvatar";
import Avatar from "@material-ui/core/Avatar";
import { Typography } from "@material-ui/core";
import Button from '@material-ui/core/Button';

const useStyles = makeStyles((theme) => ({
  root: {
    width: "100%",
    margin: "auto",
    maxWidth: 360,
    backgroundColor: theme.palette.background.paper,
  },
}));

export default function orderDetail(props) {
  const classes = useStyles();

  console.log(props);

  return (
    <React.Fragment>
      <Typography style={props.order.status === 'DELIVERED' ? {color: 'green'} : {color: red}}
        component="h6"
        variant="h5"
      >{`Status: ${props.order.status}, Cena: ${props.order.price} Czk`}</Typography>
      <Typography variant="h5">Adresa: </Typography>
      <List dense className={classes.root}>
        <ListItem
          key={props.order.adress.street}
          style={{ textAlign: "center" }}
        >
          <ListItemText primary={`Ulice: ${props.order.adress.street}`} />
        </ListItem>
        <ListItem key={props.order.adress.city} style={{ textAlign: "center" }}>
          <ListItemText primary={`Město: ${props.order.adress.city}`} />
        </ListItem>
        <ListItem
          key={props.order.adress.postalCode}
          style={{ textAlign: "center" }}
        >
          <ListItemText primary={`PSČ: ${props.order.adress.postalCode}`} />
        </ListItem>
      </List>

      {
        // N burgereru
      }
      {props.order.burgers.map((burger) => {
        return (
          <React.Fragment>
            <Typography variant="h5">{`${burger.name}`}</Typography>
            <List dense className={classes.root}>
              {burger.ingredients.map((value) => {
                return (
                  <ListItem key={value} button style={{textALign: 'center'}}>
                    <ListItemAvatar>
                      <Avatar
                        alt={`Avatar n°${value + 1}`}
                        src={`assets/images/${value.type}.png`}
                      />
                    </ListItemAvatar>
                    <ListItemText
                      primary={`Počet: ${value.amount} ks`}
                    />
                  </ListItem>
                );
              })}
            </List>
          
          </React.Fragment>
        );
      })}
        <Button
          type="submit"
          variant="contained"
          color="secondary"
          style={{marginTop: '1em'}}
          onClick={(e) => {
            e.preventDefault();
          }}
        >
          Označit objednávku za vyřízenou
        </Button>
    </React.Fragment>
  );
}
