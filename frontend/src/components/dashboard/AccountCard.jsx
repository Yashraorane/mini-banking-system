import React from 'react';

export default function AccountCard({ balance, label, account, image }) {
  return (
    <div
      className="relative aspect-[4/3] bg-cover bg-center rounded-xl shadow-lg transition-transform hover:scale-[1.02]"
      style={{
        backgroundImage: `linear-gradient(0deg, rgba(0, 0, 0, 0.4), transparent), url(${image})`,
        height: '200px',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
      }}
    >
      <div className="absolute bottom-0 left-0 p-4 space-y-1 bg-gradient-to-t from-black/60 via-black/30 to-transparent rounded-b-xl text-white">
        <p className="text-sm text-black">{balance}</p>
        <p className="text-2xl font-bold text-black">{label}</p>
        <p className="text-base font-medium text-black">Account Number: {account}</p>
      </div>
    </div>
  );
}
