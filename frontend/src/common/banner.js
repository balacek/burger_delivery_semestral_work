import React from "react";
import Link from "../Link";

const banner = () => {
  return (
    <Link href="/">
      <img
        alt="banner"
        src="assets/gif/banner.gif"
        style={{ width: "100%", height: '12em' }}
      />
    </Link>
  );
};

export default banner;
