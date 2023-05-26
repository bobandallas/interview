package org.example.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.pojo.entity.Customer;
import org.example.pojo.entity.Transaction;

import java.util.Date;
import java.util.List;

@Data
public class RewardResponseDTO {
    private List<CustomerDTO> customers;

    @Data
    @AllArgsConstructor
    public static class CustomerDTO {
        private int id;
        private String name;
        private int totalPoints;   // recent 3 month total points
        private int[] monthlyPoints; // each month detail

        public CustomerDTO(Customer customer) {
            this.id = customer.getId();
            this.name = customer.getName();

            List<Transaction> transactions = customer.getTransactions();
            Date threeMonthsAgo = new Date(System.currentTimeMillis() - (3L * 30L * 24L * 60L * 60L * 1000L));
            this.monthlyPoints = new int[3];
            this.totalPoints = 0;

            for (int i = 0; i < 3; i++) {
                Date startDate = new Date(threeMonthsAgo.getTime() + (i * 30L * 24L * 60L * 60L * 1000L));
                Date endDate = new Date(startDate.getTime() + (30L * 24L * 60L * 60L * 1000L) - 1L);
                int monthlyTransactionPoints = transactions
                        .stream()
                        .filter(t -> t.getDate().after(startDate))
                        .filter(t -> t.getDate().before(endDate))
                        .mapToInt(this::calculatePoints)
                        .sum();

                this.monthlyPoints[2 - i] = monthlyTransactionPoints; // sort by recent month
                this.totalPoints += monthlyTransactionPoints;
            }
        }

        // points rule
        private int calculatePoints(Transaction transaction) {
            int amount = transaction.getAmount();
            if (amount > 100) {
                int pointsOver100 = (amount - 100) * 2;
                int pointsOver50 = Math.min(amount, 100) - 50;
                return pointsOver100 + pointsOver50;
            } else if (amount > 50) {
                return amount - 50;
            } else {
                return 0;
            }
        }
    }
}
