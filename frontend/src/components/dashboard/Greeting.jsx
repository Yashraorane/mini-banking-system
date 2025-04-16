import React from 'react';

export default function Greeting({ userName }) {
  const getGreeting = () => {
    const currentHour = new Date().getHours();
    if (currentHour < 12) return 'Good morning';
    if (currentHour < 18) return 'Good afternoon';
    return 'Good evening';
  };

  return (
    // <div className="flex flex-wrap justify-between gap-3 p-4">
    //   <p className="text-white text-[32px] font-bold">
    <div className="px-4 py-2">
      <h1 className="text-white text-3xl font-bold">
        {getGreeting()}, {userName}!
      </h1>
    </div>
  );
}
