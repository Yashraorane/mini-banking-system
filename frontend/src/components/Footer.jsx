import React from 'react';
import '../styles/Footer.css';

export default function Footer() {
  return (
    <footer className="footer">
      <div className="footer-links">
        <a href="/privacy-policy">Privacy Policy</a>
        <a href="/terms-of-service">Terms of Service</a>
      </div>
      <p className="footer-text">© 2023 Kash. All rights reserved.</p>
    </footer>
  );
}
