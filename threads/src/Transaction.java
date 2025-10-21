public class Transaction {
    private final String id;
    private final double amount;
    private final String type; // "DEBIT" ou "CREDIT"

    public Transaction(String id, double amount, String type) {
        this.id = id;
        this.amount = amount;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{id='" + id + "', amount=" + amount + ", type='" + type + "'}";
    }
}