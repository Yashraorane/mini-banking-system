import React from 'react';
import ActivityCard from './ActivityCard';

export default function RecentActivity() {
  const activities = [
    { amount: "+$500.00", desc: "Received from David Carter", icon: "down" },
    { amount: "-$80.00", desc: "Paid to CableCo", icon: "up" },
    { amount: "-$200.00", desc: "Transferred to Savings Plus", icon: "up" },
  ];

  return (
    <>
      <h2 className="text-white text-[22px] font-bold px-4 pt-5 pb-3">Recent Activity</h2>
      {activities.map((activity, i) => (
        <ActivityCard key={i} {...activity} />
      ))}
    </>
  );
}
