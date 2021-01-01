let inicialState = {
  token: undefined,
};

const rootReducer = (state = inicialState, action) => {
  switch (action.type) {
    case "SIGNIN":
      return {
        ...state,
        token: action.token,
      };
    case "LOGOUT":
      return {
        ...state,
        token: undefined,
      };
    default:
      return state;
  }
};

export default rootReducer;
