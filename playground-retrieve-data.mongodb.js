// MongoDB Playground
use("bankingdb");

// Retrieve and print all data from each collection
// print("Users:");
// db.users.find().forEach(doc => printjson(doc));

// print("Roles:");
// db.roles.find().forEach(doc => printjson(doc));

// print("Accounts:");
// db.accounts.find().forEach(doc => printjson(doc));

// print("Transactions:");
// db.transactions.find().forEach(doc => printjson(doc));

// print("Branches:");
// db.branches.find().forEach(doc => printjson(doc));

// print("Beneficiaries:");
// db.beneficiaries.find().forEach(doc => printjson(doc));

print("Audit Logs:");
db.audit_logs.find().forEach(doc => printjson(doc));
