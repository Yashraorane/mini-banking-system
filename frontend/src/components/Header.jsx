import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUser, faMoon, faSun } from '@fortawesome/free-solid-svg-icons'; // Import icons for theme toggle
import '../styles/Header.css';

export default function Header() {
  const navigate = useNavigate();
  const [user, setUser] = useState(null);
  const [theme, setTheme] = useState('light'); // State for theme

  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem('user'));
    if (storedUser) {
      setUser(storedUser);
    }

    // Load theme from localStorage
    const storedTheme = localStorage.getItem('theme') || 'light';
    setTheme(storedTheme);
    document.documentElement.setAttribute('data-theme', storedTheme); // Apply theme to <html> instead of <body>
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    setUser(null);
    navigate('/login');
  };

  const handleManageAccounts = () => {
    // Redirect to /account or show modal
    navigate('/account');
  };
  
  const handleSettings = () => {
    // Redirect to settings page
    navigate('/settings');
  };

  const toggleTheme = () => {
    const newTheme = theme === 'light' ? 'dark' : 'light';
    setTheme(newTheme);
    localStorage.setItem('theme', newTheme);
    document.documentElement.setAttribute('data-theme', newTheme); // Apply theme to <html> instead of <body>
  };

  return (
    <header className="header">
      <div className="header-logo" onClick={() => navigate('/')}>
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
            <FontAwesomeIcon icon={faUser} className="profile-icon" />
            <div className="profile-dropdown">
              <p className="profile-username">{user.username}</p>
              <ul>
                <li><button onClick={handleManageAccounts}>Manage Account</button></li>
                <li><button onClick={handleSettings}>Settings</button></li>
                <li>
                  <button onClick={toggleTheme}>
                    {theme === 'light' ? (
                      <>
                        <FontAwesomeIcon icon={faMoon} /> Dark Mode
                      </>
                    ) : (
                      <>
                        <FontAwesomeIcon icon={faSun} /> Light Mode
                      </>
                    )}
                  </button>
                </li>
                <li><button onClick={handleLogout}>Logout</button></li>
              </ul>
            </div>
          </div>
        ) : (
          <>
            <button className="btn-primary" onClick={() => navigate('/register')}>Get Started</button>
            <button className="btn-secondary" onClick={() => navigate('/login')}>Log in</button>
          </>
        )}
      </div>
    </header>
  );
}
