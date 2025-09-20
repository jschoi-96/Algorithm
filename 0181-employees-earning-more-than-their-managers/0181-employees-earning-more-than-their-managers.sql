# Write your MySQL query statement below
SELECT b.name as Employee
FROM Employee a
JOIN Employee b
ON a.id = b.managerId
WHERE a.salary < b.salary