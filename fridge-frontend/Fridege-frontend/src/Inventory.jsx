import React from 'react'
import makeOptions from './util'

const Inventory = () => {

const inventoryList=[];

fetch("http://localhost:8080/inventory", makeOptions("GET") )
    .then((response) => response.json())
    .then(data => {
        data.map(item => {
            inventoryList.push(item);
          });
        });

  return (
    <div>Inventory</div>
  )
}

export default Inventory