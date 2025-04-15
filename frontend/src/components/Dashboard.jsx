import React from 'react';
import Header from './Header';
import Footer from './Footer'; // Assuming Footer component exists

export default function Dashboard() {
  return (
    <div className="dashboard">
      <Header />
      <main className="dashboard-content">
        {/* Add dashboard-specific content here */}
        <h1>Welcome to the Dashboard</h1>
      </main>
      <Footer />
    </div>
  );
}
