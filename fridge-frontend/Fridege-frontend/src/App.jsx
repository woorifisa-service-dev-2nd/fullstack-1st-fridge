import { Route, BrowserRouter as Router, Routes } from 'react-router-dom'
import DetailPage from './DetailPage'
import Fridge from './Fridge'
import StoreBody from './store/StoreBody'
import Header from './Header'

function App() {


  return (
    <>
    <Header></Header>
    <Router>
      <Routes>
        <Route path='/food/:id' element={<DetailPage />} />
        <Route path='/food' element={<StoreBody />} />
        <Route path="/inventory" element={<Fridge />} />
      </Routes>
    </Router>
    
    </>
  )
}

export default App
