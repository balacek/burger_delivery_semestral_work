let inicialState = {
  token: undefined,
  email: undefined,
  userId: undefined,
  tokecustomerTypen: undefined
};

const rootReducer = (state = inicialState, action) => {
  switch (action.type) {
    case "SIGNIN":
      localStorage.setItem("token", action.token);
      localStorage.setItem("email", action.email);
      return {
        ...state,
        token: action.token,
        email: action.email,
      };
    case "LOGOUT":
      localStorage.clear();
      return {
        ...state,
        token: undefined,
      };
    case "INITUSER":
      localStorage.setItem("userId", action.userId);
      localStorage.setItem("customerType", action.customerType);
      return {
        ...state,
        userId: action.userId,
        customerType: action.customerType,
      };
    case "PERSIST":
      let email = localStorage.getItem("email") ? localStorage.getItem("email") : undefined;
      return {
        token: localStorage.getItem("token")
          ? localStorage.getItem("token")
          : undefined,
        email: email,
        userId: window.localStorage.getItem("userId")
          ? localStorage.getItem("userId")
          : undefined,
        tokecustomerTypen: window.localStorage.getItem("customerType")
          ? localStorage.getItem("customerType")
          : undefined
      };
    default:
      return state;
  }
};

export default rootReducer;
