import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Register from './components/Register';
import Login from './components/Login';
import Dashboard from './components/Dashboard'; // Import Dashboard component

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} /> {/* Registration route */}
        <Route path="/login" element={<Login />} /> {/* Login route */}
        <Route path="/dashboard" element={<Dashboard />} /> {/* Dashboard route */}
        {/* Add more routes as needed */}
      </Routes>
    </Router>
  );
}

export default App;
