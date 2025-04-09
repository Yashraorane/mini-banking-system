// filepath: c:\Users\Aanand\Desktop\Dev-exp\Mini-Bank\mini-banking-system\playground-fix-roles.mongodb.js
use("bankingdb");

// Find documents with invalid or null roles
print("Users with null roles before update:");
db.users.find({ roles: null }).forEach(doc => printjson(doc));

// Update documents with null roles to have a default role
db.users.updateMany(
    { roles: null },
    { $set: { roles: ["USER"] } }
);

// Verify the fix
print("Users with null roles after update:");
db.users.find({ roles: null }).forEach(doc => printjson(doc));

print("Updated users:");
db.users.find().forEach(doc => printjson(doc));

// List indexes on the users collection
print("Indexes before dropping:");
db.users.getIndexes().forEach(index => printjson(index));

// Drop the problematic index
db.users.dropIndex("roles.name");

// Verify the indexes
print("Indexes after dropping:");
db.users.getIndexes().forEach(index => printjson(index));