package entity;

public class Transaction {
    String transactionId;
    String userId;
    Double amount;
    String type;
    String description;
    
    // Getter and setter
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getTransactionId() { return transactionId; }

    public void setUserId(String userId) { this.userId = userId; }
    public String getUserId() { return userId; }

    public void setAmount(Double amount) { this.amount = amount; }
    public Double getAmount() { return amount; }

    public void setType(String type) { this.type = type; }
    public String getType() { return type; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
}
