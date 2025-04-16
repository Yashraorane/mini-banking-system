import React, { useEffect, useState } from 'react';
import Header from './Header';
import Footer from './Footer';
import '../styles/Dashboard.css';
import Greeting from './dashboard/Greeting';
import TabNavigation from './dashboard/TabNavigation';
// import QuickActions from './dashboard/QuickActions';
// import Alerts from './dashboard/Alerts';

export default function Dashboard() {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storedUser = JSON.parse(localStorage.getItem('user'));
    if (storedUser) {
      setUser(storedUser);
    }
  }, []);

  return (
    <div className="dashboard">
      <Header />
      <main className="dashboard-content">
        <div className="dashboard-wrapper">
          <Greeting userName={user?.username || 'User'} />
          <TabNavigation />
          {/* <QuickActions /> */}
          {/* <Alerts /> */}
        </div>
      </main>
      <Footer />
    </div>
  );
}
