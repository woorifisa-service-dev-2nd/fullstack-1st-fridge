import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import { Route,BrowserRouter as Router, Routes } from 'react-router-dom'
import StoreBody from './store/StoreBody'
import Next from './Next'

function App() {
  

  return (
    <Router>
      <Routes>
        <Route path='/food/:id' element={<Next/>}/>
        <Route path='/food' element={<StoreBody/>}/>
        <Route path="/inventory" element={<Fridge />}/>
      </Routes>
    </Router>
  )
}

export default App
