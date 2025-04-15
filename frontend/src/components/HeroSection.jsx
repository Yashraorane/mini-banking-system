import React from 'react';
import { useNavigate } from 'react-router-dom'; // Import useNavigate for navigation
import '../styles/HeroSection.css';

export default function HeroSection() {
  const navigate = useNavigate(); // Initialize navigate function

  return (
    <section className="hero-section">
      <img
        src="/images/Homeban.png"
        alt="Dashboard preview"
        className="hero-image"
      />
      <div className="hero-content">
        <div className="hero-text">
          <h1>All your spending, in one place.</h1>
          <p>
            Simplify your finances. Link all your accounts and cards, track spending, and manage your budget effortlessly with Kash.
          </p>
        </div>
        <div className="hero-buttons">
          <button className="btn-primary" onClick={() => navigate('/register')}>Get Started</button> {/* Redirect to registration */}
          <button className="btn-secondary" onClick={() => navigate('/login')}>Log in</button> {/* Redirect to login */}
        </div>
      </div>
    </section>
  );
}
