import React from 'react';
import Header from '../components/Header';
import HeroSection from '../components/HeroSection';
import FeaturesSection from '../components/FeaturesSection';
import Footer from '../components/Footer';

export default function HomePage() {
  return (
    <div className="home-page">
      {/* Header */}
      <Header />

      {/* Hero Section */}
      <HeroSection />

      {/* Features Section */}
      <FeaturesSection />

      {/* Footer */}
      <Footer />
    </div>
  );
}
