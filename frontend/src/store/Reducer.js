const rootReducer = (state, action) => {
    switch (action.type) {
      case 'SIGNIN':
        return {
          ...state,
          token: action.token
        };
    }
}

export default rootReducer;