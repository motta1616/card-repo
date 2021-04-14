const reducer =(state, action) => {
    switch (action.type) {
      case 'update-item':
        const gamerUpItem = state.gamer;
        const listUpdateEdit = gamerUpItem.list.map((item) => {
          if (item.id === action.item.id) {
            return action.item;
          }
          return item;
        });
        gamerUpItem.list = listUpdateEdit;
        gamerUpItem.item = {};
        return { ...state, gamer: gamerUpItem }
      case 'delete-item':
        const gamerUpDelete = state.gamer;
        const listUpdate = gamerUpDelete.list.filter((item) => {
          return item.id !== action.id;
        });
        gamerUpDelete.list = listUpdate;
        return { ...state, gamer: gamerUpDelete }
      case 'update-list':
        const gamerUpList = state.gamer;
        gamerUpList.list = action.list;
        return { ...state, gamer: gamerUpList }
      case 'edit-item':
        const gamerUpEdit = state.gamer;
        gamerUpEdit.item = action.item;
        return { ...state, gamer: gamerUpEdit }
      case 'add-item':
        const gamerUp = state.gamer.list;
        gamerUp.push(action.item);
        return { ...state, gamer: {list: gamerUp, item: {}} }
      default:
        return state;
    }
  }
  export default reducer;