import Post from "./Components/Post";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./Components/Home/home";
import User from "./Components/User/User";
import Navbar from "./Components/Navbar/Navbar";

function App() {
  return (
    <div className="App">
      <BrowserRouter >  
      
      <Navbar/>
            <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/users/:userId" element={<User />} />
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
