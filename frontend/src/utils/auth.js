import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Header.css';

export default function Header() {
  const navigate = useNavigate();
  const [user, setUser] = useState(null); // State to store logged-in user details

  useEffect(() => {
    // Check if user session exists in cookies
    const storedUser = JSON.parse(localStorage.getItem('user'));
    if (storedUser) {
      setUser(storedUser);
    }
  }, []);

  const handleLogout = () => {
    // Clear user session and redirect to login
    document.cookie = 'token=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;';
    localStorage.removeItem('user');
    setUser(null);
    navigate('/login');
  };

  return (
    <header className="header">
      <div className="header-logo">
        <svg className="logo-icon" viewBox="0 0 48 48" fill="none" xmlns="http://www.w3.org/2000/svg">
          <path
            fillRule="evenodd"
            clipRule="evenodd"
            d="M24 18.4228L42 11.475V34.3663C42 34.7796 41.7457 35.1504 41.3601 35.2992L24 42V18.4228Z"
            fill="currentColor"
          />
          <path
            fillRule="evenodd"
            clipRule="evenodd"
            d="M24 8.18819L33.4123 11.574L24 15.2071L14.5877 11.574L24 8.18819ZM9 15.8487L21 20.4805V37.6263L9 32.9945V15.8487ZM27 37.6263V20.4805L39 15.8487V32.9945L27 37.6263ZM25.354 2.29885C24.4788 1.98402 23.5212 1.98402 22.646 2.29885L4.98454 8.65208C3.7939 9.08038 3 10.2097 3 11.475V34.3663C3 36.0196 4.01719 37.5026 5.55962 38.098L22.9197 44.7987C23.6149 45.0671 24.3851 45.0671 25.0803 44.7987L42.4404 38.098C43.9828 37.5026 45 36.0196 45 34.3663V11.475C45 10.2097 44.2061 9.08038 43.0155 8.65208L25.354 2.29885Z"
            fill="currentColor"
          />
        </svg>
        <h2>Kash</h2>
      </div>
      <nav className="header-nav">
        <a href="/">Home</a>
        <a href="/products">Products</a>
        <a href="/resources">Resources</a>
        <a href="/company">Company</a>
        <a href="/pricing">Pricing</a>
      </nav>
      <div className="header-buttons">
        {user ? (
          <div className="profile-section">
            <img
              src="https://www.lucidchart.com/publicSegments/assets/images/logos/lucidchart-logo.png" // Replace with Lucid profile logo
              alt="Profile"
              className="profile-picture"
            />
            <div className="profile-dropdown">
              <p>{user.username}</p>
              <ul>
                <li><button onClick={handleLogout}>Logout</button></li> {/* Ensure button is clickable */}
              </ul>
            </div>
          </div>
        ) : (
          <>
            <button className="btn-primary" onClick={() => navigate('/register')}>Register</button>
            <button className="btn-secondary" onClick={() => navigate('/login')}>Log in</button>
          </>
        )}
      </div>
    </header>
  );
}