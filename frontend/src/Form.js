import React, { useContext, useRef, useState } from 'react';
import { Store, HOST_API } from './App';

export const Form = () => {
  const formRef = useRef(null);
  const { dispatch, state: { gamer } } = useContext(Store);
  const item = gamer.item;
  const [state, setState] = useState(item);
  const [error, setError] = useState(null);

  /*
  const listgamer = () => {
    fetch(HOST_API + "/game/gamers", {
      method: "GET",
      body: JSON.stringify(request),
    })
  }
  */

  const validForm = () => {
    let isValid = true;
    setError(null);
    if (state.name.length < 3 || state.name.length > 30 || state.name === null) {
      setError("Debes ingresar tareas con mas de dos caracteres");
      isValid = false;
    }
    return isValid;
  };

  const onAdd = (event) => {
    event.preventDefault();

    if (!validForm()) {
      return;
    };

    const request = {
      name: state.name,
    };
    
    fetch(HOST_API + "/game", {
      method: "POST",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((gamer) => {
        dispatch({ type: "add-item", item: gamer });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  const onEdit = (event) => {
    event.preventDefault();

    if (!validForm()) {
      return;
    };

    const request = {
      name: state.name,
      id: item.id,
    };


    fetch(HOST_API + "/game", {
      method: "PUT",
      body: JSON.stringify(request),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => response.json())
      .then((gamer) => {
        dispatch({ type: "update-item", item: gamer });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return <form ref={formRef}>
    <div className=" alert-warning" role="alert">
      {error && <span>{error}</span>}
    </div>
    <div className="input-group mb-3">
      <input
        type="text"
        name="name"
        placeholder="Ingrese jugador"
        className="form-control" aria-describedby="button-addon1"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value });
        }}></input>
      {!item.id && <button onClick={onAdd} className="btn btn-outline-secondary" type="button" id="button-addon1">Crear</button>}
    
      <input
        type="text"
        name="distancia"
        placeholder="Ingrese el valor en kilometros"
        className="form-control" aria-describedby="button-addon1"
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value });
        }}></input>
        
      {item.id && <button onClick={onEdit} className="btn btn-outline-secondary" type="button" id="button-addon1">Actualizar</button>}
      {!item.id && <button onClick={onAdd} className="btn btn-outline-secondary" type="button" id="button-addon1">Crear</button>}
    
    </div>
  </form>;
};
