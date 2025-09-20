package model;




import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public class Transaction{

private UUID  id;
private LocalDateTime Instant;
private  String accountId;
private UUID user_id;
private BigDecimal amount;
private String type;


    public UUID getId() {
        return id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getInstant() {
        return Instant;
    }

    public String getAccountId() {
        return accountId;
    }

    public Transaction(String accountId, UUID userId, BigDecimal amount, String type)
{
    user_id = userId;
    this.amount = amount;
    this.type = type;
    this.id = UUID.randomUUID();
    this.Instant = LocalDateTime.now();
    this.accountId = accountId;
}

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setInstant(LocalDateTime instant) {
        Instant = instant;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
