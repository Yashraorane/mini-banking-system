import React, { useState } from 'react';
import axios from 'axios';
import '../styles/Login.css';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Header from './Header'; // Import Header component
import Footer from './Footer'; // Import Footer component
import { useNavigate } from 'react-router-dom'; // Import useNavigate

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080'; // Fallback value

export default function Login() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
  });

  const navigate = useNavigate(); // Initialize navigate

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
    console.log('Form data updated:', { ...formData, [name]: value }); // Debug log to verify state updates
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log('Form submitted');
  
    try {
      // Send username and password in the request body as JSON
      const response = await axios.post(
        `${API_BASE_URL}/api/auth/login`,
        {
          username: formData.username,
          password: formData.password
        },
        {
          headers: {
            'Content-Type': 'application/json'
          }
        }
      );
  
      console.log('Login successful:', response.data);
      toast.success('Login successful!');
      localStorage.setItem('user', JSON.stringify({ username: formData.username }));
      navigate('/dashboard');
    } catch (error) {
      console.error('Error during login:', error.response?.data || error.message);
      toast.error('Login failed. Please check your credentials.');
    }
  };

  return (
    <>
      <Header /> {/* Add Header */}
      <section className="login-section">
        <h2>Login</h2>
        <form className="login-form" onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={formData.username}
            onChange={handleChange}
            required
          />
          <input
            type="password"
            name="password"
            placeholder="Password"
            value={formData.password}
            onChange={handleChange}
            required
          />
          <button type="submit" className="btn-primary">Login</button>
        </form>
        <ToastContainer />
      </section>
      <Footer /> {/* Add Footer */}
    </>
  );
}
