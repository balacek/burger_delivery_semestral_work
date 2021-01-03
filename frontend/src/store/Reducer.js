let inicialState = {
  token: undefined,
  email: undefined,
  userId: undefined
};

const rootReducer = (state = inicialState, action) => {
  switch (action.type) {
    case "SIGNIN":
      return {
        ...state,
        token: action.token,
        email: action.email,
      };
    case "LOGOUT":
      return {
        ...state,
        token: undefined,
      };
    case "INITUSER":
      return {
        ...state,
        userId: action.userId,
      };
    default:
      return state;
  }
};

export default rootReducer;
