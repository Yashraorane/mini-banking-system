// MongoDB Playground
use("bankingdb");

// Delete all data from each collection
db.users.deleteMany({});
db.roles.deleteMany({});
db.accounts.deleteMany({});
db.transactions.deleteMany({});
db.branches.deleteMany({});
db.beneficiaries.deleteMany({});
db.audit_logs.deleteMany({});

// Verify deletion
print("All data deleted.");
