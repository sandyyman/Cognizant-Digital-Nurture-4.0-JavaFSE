-- Drop tables (ignore errors)
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Transactions CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Loans CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION
  WHEN OTHERS THEN NULL;
END;
/

-- Create Tables
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE,
    IsVIP CHAR(1)
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Insert Sample Data
INSERT INTO Customers VALUES (1, 'John Doe', TO_DATE('1955-05-15', 'YYYY-MM-DD'), 12000, SYSDATE, 'N');
INSERT INTO Customers VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 9000, SYSDATE, 'N');

INSERT INTO Accounts VALUES (1, 1, 'Savings', 1000, SYSDATE);
INSERT INTO Accounts VALUES (2, 2, 'Checking', 1500, SYSDATE);

INSERT INTO Transactions VALUES (1, 1, SYSDATE, 200, 'Deposit');
INSERT INTO Transactions VALUES (2, 2, SYSDATE, 300, 'Withdrawal');

INSERT INTO Loans VALUES (1, 1, 5000, 5, SYSDATE, SYSDATE + 15);
INSERT INTO Loans VALUES (2, 2, 6000, 6, SYSDATE, SYSDATE + 90);

INSERT INTO Employees VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));
INSERT INTO Employees VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Exercise 1: Control Structures

-- Scenario 1: Apply 1% discount to loans for customers > 60
BEGIN
  FOR cust IN (
    SELECT Loans.LoanID, Customers.CustomerID
    FROM Customers, Loans
    WHERE Customers.CustomerID = Loans.CustomerID
    AND MONTHS_BETWEEN(SYSDATE, Customers.DOB)/12 > 60
  ) LOOP
    UPDATE Loans
    SET InterestRate = InterestRate - 1
    WHERE LoanID = cust.LoanID;

    DBMS_OUTPUT.PUT_LINE('Discount applied to LoanID: ' || cust.LoanID);
  END LOOP;
END;
/

-- Scenario 2: Promote VIPs (Balance > 10000)
BEGIN
  FOR cust IN (SELECT CustomerID FROM Customers WHERE Balance > 10000) LOOP
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = cust.CustomerID;

    DBMS_OUTPUT.PUT_LINE('Customer ' || cust.CustomerID || ' promoted to VIP.');
  END LOOP;
END;
/

-- Scenario 3: Loan reminders due in next 30 days
BEGIN
  FOR loan IN (
    SELECT LoanID, CustomerID, EndDate
    FROM Loans
    WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || 
                         ' for Customer ' || loan.CustomerID || 
                         ' is due on ' || TO_CHAR(loan.EndDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/

-- Exercise 3: Stored Procedures

-- Procedure 1: ProcessMonthlyInterest
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  UPDATE Accounts
  SET Balance = Balance * 1.01
  WHERE AccountType = 'Savings';

  DBMS_OUTPUT.PUT_LINE('Monthly interest applied to savings accounts.');
END;
/
BEGIN
  ProcessMonthlyInterest;
END;
/

-- Procedure 2: UpdateEmployeeBonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(dept IN VARCHAR2, bonus_percent IN NUMBER) IS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * bonus_percent / 100)
  WHERE Department = dept;

  DBMS_OUTPUT.PUT_LINE('Bonus updated for department: ' || dept);
END;
/
BEGIN
  UpdateEmployeeBonus('HR', 10);
END;
/

-- Procedure 3: TransferFunds
CREATE OR REPLACE PROCEDURE TransferFunds(
  from_acc IN NUMBER,
  to_acc IN NUMBER,
  amt IN NUMBER
) IS
  from_balance NUMBER;
BEGIN
  SELECT Balance INTO from_balance FROM Accounts WHERE AccountID = from_acc;

  IF from_balance < amt THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
  END IF;

  UPDATE Accounts SET Balance = Balance - amt WHERE AccountID = from_acc;
  UPDATE Accounts SET Balance = Balance + amt WHERE AccountID = to_acc;

  DBMS_OUTPUT.PUT_LINE('Transferred ' || amt || ' from account ' || from_acc || ' to account ' || to_acc);
END;
/
BEGIN
  TransferFunds(1, 2, 200);
END;
/
