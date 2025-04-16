import React from 'react';
import AccountCard from './AccountCard';

export default function AccountsOverview() {
  const accounts = [
    {
      balance: "$2,543.89",
      label: "Premier Checking",
      account: "***1234",
      image: "/images/Account.png",
    },
    {
      balance: "$10,200.50",
      label: "Savings Plus",
      account: "***5678",
      image: "/images/Account.png",
    },
  ];

  return (
    <div className="px-4">
      <h2 className="text-white text-[22px] font-bold pt-2 pb-4">Accounts Overview</h2>
      <div className="grid md:grid-cols-2 gap-y-6 gap-x-4">
        {accounts.map((account, index) => (
          <AccountCard key={index} {...account} />
        ))}
      </div>
    </div>
  );
}
