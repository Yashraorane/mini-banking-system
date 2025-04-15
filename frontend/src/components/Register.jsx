import React, { useState } from 'react';
import axios from 'axios';
import '../styles/Register.css';
import { toast, ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import Header from './Header'; // Import Header component
import Footer from './Footer'; // Import Footer component

const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8080'; // Fallback value

export default function Register() {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    firstName: '',
    lastName: '',
    roles: '', // Comma-separated roles
    accounts: '', // Comma-separated account IDs
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
        const authHeader = 'Basic ' + btoa('admin:admin123'); // Replace with actual credentials
        const requestBody = {
            username: formData.username,
            password: formData.password,
            email: formData.email,
            firstName: formData.firstName,
            lastName: formData.lastName,
            enabled: true, // Ensure enabled is set to true by default
            roles: formData.roles
                ? formData.roles.split(',').map(role => role.trim()) // Convert to array
                : ["USER"], // Default role
            accounts: formData.accounts
                ? formData.accounts.split(',').map(account => account.trim()) // Convert to array
                : [], // Default empty array
        };

        console.log('Request Body:', requestBody);

        const response = await axios.post(`${API_BASE_URL}/api/users/register`, requestBody, {
            headers: {
                Authorization: authHeader,
                'Content-Type': 'application/json',
            },
        });

        console.log('Registration successful:', response.data);
        toast.success('Registration successful!', {
            position: "top-right",
            autoClose: 3000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
        });
    } catch (error) {
        console.error('Error during registration:', error.response || error.message);
        toast.error('Registration failed. Please try again.', {
            position: "top-right",
            autoClose: 3000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            progress: undefined,
        });
    }
  };

  return (
    <>
      <Header /> {/* Add Header */}
      <section className="register-section">
        <h2>Register</h2>
        <form className="register-form" onSubmit={handleSubmit}>
          <input
            type="text"
            name="username"
            placeholder="Username"
            value={formData.username}
            onChange={handleChange}
            required
          />
          <input
            type="email"
            name="email"
            placeholder="Email"
            value={formData.email}
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
          <input
            type="text"
            name="firstName"
            placeholder="First Name"
            value={formData.firstName}
            onChange={handleChange}
          />
          <input
            type="text"
            name="lastName"
            placeholder="Last Name"
            value={formData.lastName}
            onChange={handleChange}
          />
          <input
            type="text"
            name="roles"
            placeholder="Roles (comma-separated)"
            value={formData.roles}
            onChange={handleChange}
            required
          />
          <input
            type="text"
            name="accounts"
            placeholder="Accounts (comma-separated)"
            value={formData.accounts}
            onChange={handleChange}
          />
          <button type="submit" className="btn-primary">Register</button>
        </form>
        <ToastContainer />
      </section>
      <Footer /> {/* Add Footer */}
    </>
  );
}
