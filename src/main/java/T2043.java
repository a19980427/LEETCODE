

class Bank {

    private long nums;
    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
        this.nums = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {

        if (account1 > nums || account2 > nums) {
            return false;
        }
        if (balance[account1 - 1] - money < 0) {
            return false;
        }
        balance[account1 - 1] -= money;
        balance[account2 - 1] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (account > nums) {
            return false;
        }
        balance[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (account > nums) {
            return false;
        }
        if (balance[account - 1] - money < 0) {
            return false;
        }
        balance[account - 1] -= money;
        return true;
    }

    public static void main(String[] args) {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        bank.withdraw(3, 10);
        bank.transfer(5, 1, 20);
        bank.deposit(5, 20);
        bank.transfer(3, 4, 5);
        bank.withdraw(10, 50);
    }

}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */