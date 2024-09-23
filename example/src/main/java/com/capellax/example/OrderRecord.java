package com.capellax.example;

public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {

}
