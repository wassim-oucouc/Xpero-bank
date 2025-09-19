package model;


import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.time.LocalDateTime;




public class Account {


    private String accountId;
    private UUID ownerUserId;
    private BigDecimal balance;
    private LocalDateTime createdAt;
    private Boolean active;

    Random random = new Random();

    public Account(UUID ownerUserId)
    {
        this.accountId = "BK-"+ random.nextInt(1000) +"-"+random.nextInt(1000);
        this.ownerUserId = ownerUserId;
        this.balance = BigDecimal.valueOf(0);
        this.createdAt = LocalDateTime.now();
        this.active = true;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public UUID getOwnerUserId() {
        return ownerUserId;
    }
    public void addBalance(BigDecimal amount)
    {
        this.balance.add(amount);
    }

    public void setOwnerUserId(UUID ownerUserId) {
        this.ownerUserId = ownerUserId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Random getRandom() {
        return random;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", ownerUserId=" + ownerUserId +
                ", balance=" + balance +
                ", createdAt=" + createdAt +
                ", active=" + active +
                ", random=" + random +
                '}';
    }

    public void setRandom(Random random) {
        this.random = random;
    }

}
