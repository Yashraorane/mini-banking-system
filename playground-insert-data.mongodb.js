// MongoDB Playground
use("bankingdb");

// Insert sample users
// db.users.insertMany([
//     {
//         username: "john_doe",
//         password: "password123",
//         email: "john.doe@example.com",
//         firstName: "John",
//         lastName: "Doe",
//         enabled: true,
//         roles: ["USER"],
//         accounts: []
//     },
//     {
//         username: "jane_doe",
//         password: "password456",
//         email: "jane.doe@example.com",
//         firstName: "Jane",
//         lastName: "Doe",
//         enabled: true,
//         roles: ["USER"],
//         accounts: []
//     }
// ]);

// // Insert sample roles
// db.roles.insertMany([
//     { name: "ADMIN" },
//     { name: "USER" }
// ]);

// // Insert sample accounts
// db.accounts.insertMany([
//     {
//         accountNumber: "1234567890",
//         balance: 1000.0,
//         type: "SAVINGS",
//         userId: "john_doe",
//         branch: null,
//         outgoingTransactions: [],
//         incomingTransactions: []
//     },
//     {
//         accountNumber: "9876543210",
//         balance: 2000.0,
//         type: "CHECKING",
//         userId: "jane_doe",
//         branch: null,
//         outgoingTransactions: [],
//         incomingTransactions: []
//     }
// ]);

// Insert sample transactions
// db.transactions.insertMany([
//     {
//         sourceAccountId: "1234567890",
//         targetAccountId: "9876543210",
//         amount: 500.0,
//         type: "TRANSFER",
//         status: "SUCCESS",
//         branch: null,
//         timestamp: new Date()
//     },
//     {
//         sourceAccountId: "9876543210",
//         targetAccountId: "1234567890",
//         amount: 300.0,
//         type: "TRANSFER",
//         status: "SUCCESS",
//         branch: null,
//         timestamp: new Date()
//     }
// ]);

// Insert sample branches
// db.branches.insertMany([
//     {
//         branchCode: "BR001",
//         name: "Main Branch",
//         address: "123 Main St, Cityville",
//         contactNumber: "123-456-7890"
//     },
//     {
//         branchCode: "BR002",
//         name: "Secondary Branch",
//         address: "456 Secondary St, Townsville",
//         contactNumber: "987-654-3210"
//     }
// ]);

// Insert sample beneficiaries
db.beneficiaries.insertMany([
    {
        userId: "john_doe",
        accountNumber: "9876543210",
        branch: null,
        nickname: "Jane's Account"
    },
    {
        userId: "jane_doe",
        accountNumber: "1234567890",
        branch: null,
        nickname: "John's Account"
    }
]);

// Insert sample audit logs
// db.audit_logs.insertMany([
//     {
//         action: "CREATE_USER",
//         performedBy: "admin",
//         details: "Created user with username: john_doe",
//         timestamp: new Date()
//     },
//     {
//         action: "CREATE_ACCOUNT",
//         performedBy: "admin",
//         details: "Created account with number: 1234567890",
//         timestamp: new Date()
//     }
// ]);

print("Sample data inserted.");
