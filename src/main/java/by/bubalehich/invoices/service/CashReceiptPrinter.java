package by.bubalehich.invoices.service;

import by.bubalehich.invoices.entity.CashReceipt;

import java.math.BigDecimal;

public final class CashReceiptPrinter {

    public static void print(CashReceipt cashReceipt) {
        System.out.println("----------CASH RECEIPT----------");
        System.out.printf("Cashier:  %22s%n", cashReceipt.getCashier());
        System.out.printf("Date: %s%n", cashReceipt.getDate());
        System.out.println("--------------------------------");
        System.out.println("QTY DESCRIPTION     PRICE TOTAL ");

        cashReceipt.getPositions()
                .forEach(position -> System.out.printf("%n%3d%17s%6s%6s",
                        position.getCount(),
                        position.getItem().getDescription(),
                        position.getItem().getPrice(),
                        position.getItem().getPrice().multiply(BigDecimal.valueOf(position.getCount()))
                ));

        System.out.printf("%n--------------------------------");
        System.out.printf("%nSum: %27s", cashReceipt.getTaxableTotal());
        System.out.printf("%nDiscount: %22s", cashReceipt.getDiscount());
        System.out.printf("%nTOTAL: %25s", cashReceipt.getTotal());
    }
}
