import React from 'react'
import { useNavigate } from "react-router-dom";
import { useState } from 'react';
import makeOptions from './util'

const ModalForm = ({onClose}) => {
    const navigate = useNavigate();
    const [name, setName] = useState();
    const [password, setPassword] = useState();


     const addInventory = () => {
         fetch("http://localhost:8080/inventory/", makeOptions('POST', JSON.stringify({"foodId" : 8,"ownerName" : name, "ownerPwd" : password})) )
            .then((response) => {
                if(response.status != 200)
                    alert("에러!!")
            })
            .finally(navigate('/inventory'));
        
        }

  return (
    <>
        <div className='flex-col'>
            <div className='p-3'> 
                <h3 style={{fontFamily:"Bagel Fat One", fontSize:"2em"}}>냉장고에 담기</h3>
            </div>
            <div className='p-3 flex-row space-x-10'>
                
                <label className='pr-4'>소유주 이름</label>
                <input placeholder='김우리' onChange={e=> setName(e.target.value) }></input>
                
            </div>
            <div className='p-3 flex-row space-x-10'>
            
                <label className='pr-4'>비밀번호</label>
                <input placeholder='dontEatMyFood' onChange={e=> setPassword(e.target.value) }></input>
                
            </div>

            <button className="inline-flex items-center rounded-md text-xl  bg-[#637A9F] shadow-sm hover:bg-[#0C2D57] px-5 py-2 text-white ring-1 ring-inset ring-gray-500/10"
                onClick={addInventory}>
                담기
            </button>
        </div>
    </>
  )
}


export default ModalForm