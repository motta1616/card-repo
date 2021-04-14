import React, { useContext, useEffect } from 'react';
import { Store, HOST_API } from './App';

export const List = () => {
  const { dispatch, state: { gamer } } = useContext(Store);
  const currentList = gamer.list;

  useEffect(() => {
    fetch(HOST_API + "/game")
      .then(response => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [dispatch]);


  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/game", {
      method: "DELETE"
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onEdit = (gamer) => {
    dispatch({ type: "edit-item", item: gamer });
  };
  
  return <div>
    <table className="table">
      <thead>
        <tr>
          <th scope="col" className="text-center">Id</th>
          <th scope="col" className="text-center">Player</th>
          <th scope="col" className="text-center">Carro</th>
          <th scope="col" className="text-center">Estado</th>
        </tr>
      </thead>
      <tbody className="table-info">
        {currentList.map((gamer) => {
          return <tr>
            <td className="text-center">{gamer.id}</td>
            <td className="text-center">{gamer.name}</td>
            <td className="text-center">{gamer.podium}</td>
            <td className="text-center"><button onClick={() => onDelete(gamer.id)} type="button" className="btn btn-primary col-4 mx-auto">Eliminar</button>
              <button onClick={() => onEdit(gamer)} type="button" className="btn btn-danger col-4 mx-auto">Editar</button></td>
          </tr>
        
        })}
      </tbody>
    </table>
    <button onClick={() => onEdit(gamer)} className="btn btn-outline-secondary" type="button" id="button-addon1">Jugar</button>
  </div>;
};
