import React from 'react';
import '../styles/FeatureCard.css';

export default function FeatureCard({ title, description, icon }) {
  return (
    <div className="feature-card">
      {icon}
      <h3 className="feature-card-title">{title}</h3>
      <p className="feature-card-description">{description}</p>
    </div>
  );
}
