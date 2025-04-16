import React from 'react';

export default function QuickActions() {
  const actions = ["Transfer", "Pay Bills"];

  return (
    <>
      <h2 className="text-white text-[22px] font-bold px-4 pt-5 pb-3">Quick Actions</h2>
      <div className="flex justify-between px-4 py-3 gap-3 flex-wrap">
        {actions.map((text, i) => (
          <button
            key={i}
            className="flex items-center justify-center rounded-xl h-10 px-4 min-w-[84px] bg-[#293038] text-white text-sm font-bold"
          >
            <span className="truncate">{text}</span>
          </button>
        ))}
      </div>
    </>
  );
}
