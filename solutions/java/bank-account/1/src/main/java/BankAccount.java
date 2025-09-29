class BankAccount {

    private int balance;
    private boolean isOpen;
    void open() throws BankAccountActionInvalidException {
        if(isOpen)
            throw new BankAccountActionInvalidException("Account already open");

        balance = 0;
        isOpen = true;
        
    }

    void close() throws BankAccountActionInvalidException {
        if(!isOpen)
            throw new BankAccountActionInvalidException("Account not open");

        isOpen = false;     
    }

    synchronized int getBalance() throws BankAccountActionInvalidException {
        if(!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        else{
            return balance;
        }
        
    }

    synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if(!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        else{
            if(amount < 0)
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            balance += amount;
        }
        
    }

    synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if(!isOpen)
            throw new BankAccountActionInvalidException("Account closed");
        else{
            if(amount < 0)
                throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            else if(amount > balance)
                throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
            balance -= amount;
        }    
    }
}