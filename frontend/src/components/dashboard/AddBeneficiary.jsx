import React, { useState } from 'react';

export default function AddBeneficiary() {
  const [formData, setFormData] = useState({
    userId: '',
    accountNumber: '',
    branchCode: '',
    nickname: '',
  });

  const [message, setMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await fetch('/api/beneficiaries', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        setMessage('Beneficiary added successfully!');
        setFormData({ userId: '', accountNumber: '', branchCode: '', nickname: '' });
      } else {
        setMessage('Failed to add beneficiary. Please try again.');
      }
    } catch (error) {
      setMessage('An error occurred. Please try again.');
    }
  };

  return (
    <div className="text-white px-4">
      <h2 className="text-[22px] font-bold pb-4">Add Beneficiary</h2>
      {message && <p className="mb-4">{message}</p>}
      <form onSubmit={handleSubmit} className="space-y-4">
        <div>
          <label className="block text-sm font-medium">User ID</label>
          <input
            type="text"
            name="userId"
            value={formData.userId}
            onChange={handleChange}
            className="w-full p-2 border rounded bg-[#111418] text-white"
            required
          />
        </div>
        <div>
          <label className="block text-sm font-medium">Account Number</label>
          <input
            type="text"
            name="accountNumber"
            value={formData.accountNumber}
            onChange={handleChange}
            className="w-full p-2 border rounded bg-[#111418] text-white"
            required
          />
        </div>
        <div>
          <label className="block text-sm font-medium">Branch Code</label>
          <input
            type="text"
            name="branchCode"
            value={formData.branchCode}
            onChange={handleChange}
            className="w-full p-2 border rounded bg-[#111418] text-white"
            required
          />
        </div>
        <div>
          <label className="block text-sm font-medium">Nickname</label>
          <input
            type="text"
            name="nickname"
            value={formData.nickname}
            onChange={handleChange}
            className="w-full p-2 border rounded bg-[#111418] text-white"
          />
        </div>
        <button
          type="submit"
          className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
        >
          Add Beneficiary
        </button>
      </form>
    </div>
  );
}
