import React, { useState } from 'react';
import AccountsOverview from './AccountsOverview';
import RecentActivity from './RecentActivity';
import AddBeneficiary from './AddBeneficiary';

export default function TabNavigation() {
  const [activeTab, setActiveTab] = useState("My Accounts");

  const tabs = ["My Accounts", "Debit & Credit", "Add Beneficiary"];

  return (
    <div className="flex flex-col">
      <div className="tab-navigation border-b border-[#3c4753] flex gap-4 px-4">
        {tabs.map((label, i) => (
          <button
            key={i}
            onClick={() => setActiveTab(label)}
            className={`px-4 py-3 text-sm font-semibold transition-all duration-300 border-b-2 ${activeTab === label
                ? 'text-white border-white'
                : 'text-[#9dabb8] border-transparent hover:text-white'
              }`}
          >
            {label}
          </button>
        ))}
      </div>
      <div className="tab-content mt-6">
        {activeTab === "My Accounts" && <AccountsOverview />}
        {activeTab === "Debit & Credit" && <RecentActivity />}
        {activeTab === "Add Beneficiary" && <AddBeneficiary />}
      </div>
    </div>
  );
}
