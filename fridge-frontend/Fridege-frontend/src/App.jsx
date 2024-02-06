import { Route, BrowserRouter as Router, Routes } from 'react-router-dom'
import DetailPage from './DetailPage'
import Fridge from './Fridge'
import StoreBody from './store/StoreBody'

function App() {


  return (
    <Router>
      <Routes>
        <Route path='/food/:id' element={<DetailPage />} />
        <Route path='/food' element={<StoreBody />} />
        <Route path="/inventory" element={<Fridge />} />
      </Routes>
    </Router>
  )
}

export default App
