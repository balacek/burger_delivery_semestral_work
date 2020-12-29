import React, { useState } from "react";

import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Link from "../../Link";
import Tabs from "@material-ui/core/Tabs";
import Tab from "@material-ui/core/Tab";
import Button from "@material-ui/core/Button";
import Person from "@material-ui/icons/Person";

const appBar = () => {
  const [tabIndex, setTabIndex] = useState(1);

  const handleTabClick = (_, index) => {
    setTabIndex(index);
  };

  return (
    <AppBar position="fixed" elevation={0} color="primary" style={{marginBottom: '5em'}} >
      <Toolbar disableGutters style={{ marginLeft: "5em" }}>
        <Button
          variant="contained"
          color="secondary"
          startIcon={<Person />}
          size="large"
          component={Link}
          href="/"
        >
          Přihlásit
        </Button>
        <Tabs
          value={tabIndex}
          onChange={handleTabClick}
          style={{ marginLeft: "2em" }}
        >
          <Tab
            label="Burger"
            disableRipple
            component={Link}
            href="/createOrder"
          />
          <Tab
            label="Objednávky"
            disableRipple
            component={Link}
            href="/listOfOrders"
          />
        </Tabs>
      </Toolbar>
    </AppBar>
  );
};

export default appBar;
