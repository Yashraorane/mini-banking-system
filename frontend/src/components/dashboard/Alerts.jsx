import React from 'react';

export default function Alerts() {
  const alerts = [
    "Your Savings Plus account has reached a balance of $10,000.",
    "A recurring transfer of $200 to Savings Plus has been scheduled.",
  ];

  return (
    <>
      <h2 className="text-white text-[22px] font-bold px-4 pt-5 pb-3">Important Alerts</h2>
      {alerts.map((msg, i) => (
        <div className="bg-[#111418] px-4 py-2 min-h-14 text-white text-base" key={i}>
          {msg}
        </div>
      ))}
    </>
  );
}
