alter table cash_receipt
    rename column taxable_total to amount;

alter table cash_receipt
    rename column total to total_amount;
