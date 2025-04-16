import React from 'react';

export default function ActivityCard({ amount, desc, icon }) {
  return (
    <div className="flex items-center gap-4 bg-[#111418] px-4 py-2 min-h-[72px]">
      <div className="text-white bg-[#293038] w-12 h-12 rounded-lg flex items-center justify-center shrink-0">
        {icon === "down" ? (
          <svg width="24" height="24" fill="currentColor" viewBox="0 0 256 256">
            <path d="M205.66,149.66l-72,72a8,8,0,0,1-11.32,0l-72-72a8,8,0,0,1-11.32-11.32L120,196.69V40a8,8,0,0,1,16,0V196.69l58.34-58.35a8,8,0,0,1,11.32,11.32Z" />
          </svg>
        ) : (
          <svg width="24" height="24" fill="currentColor" viewBox="0 0 256 256">
            <path d="M205.66,117.66a8,8,0,0,1-11.32,0L136,59.31V216a8,8,0,0,1-16,0V59.31L61.66,117.66a8,8,0,0,1-11.32-11.32l72-72a8,8,0,0,1,11.32,0l72,72A8,8,0,0,1,205.66,117.66Z" />
          </svg>
        )}
      </div>
      <div className="flex flex-col justify-center text-white">
        <p className="text-base font-medium">{amount}</p>
        <p className="text-sm text-[#9dabb8]">{desc}</p>
      </div>
    </div>
  );
}
