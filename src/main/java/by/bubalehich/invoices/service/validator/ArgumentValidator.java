package by.bubalehich.invoices.service.validator;

import by.bubalehich.invoices.exception.ValidationException;
import by.bubalehich.invoices.utils.result.Result;

import java.util.Arrays;

public final class ArgumentValidator {
    private static final String SEPARATOR = "-";
    private static final String CARD = "card";
    private static final int CARD_COUNT = 1;

    public static Result validate(String[] args) {
        try {
            validateFormat(args);

            if (hasCard(args)) {
                validateCardFormat(args);

                args = Arrays.stream(args)
                        .filter(a -> !a.split(SEPARATOR)[0].equalsIgnoreCase(CARD)).toArray(String[]::new);
            }
            validateItemsFormat(args);
        } catch (ValidationException e) {
            return Result.failure(e.getMessage());
        }
        return Result.ok();
    }

    private static boolean validateFormat(String[] args) {
        if (Arrays.stream(args).allMatch(a -> a.split(SEPARATOR).length == 2)) {
            return true;
        }

        throw new ValidationException("Invalid argument format.");
    }

    private static boolean hasCard(String[] args) {
        return Arrays.stream(args).anyMatch(a -> a.split(SEPARATOR)[0].equalsIgnoreCase(CARD));
    }

    private static boolean validateCardFormat(String[] args) {
        if (Arrays.stream(args).filter(a -> a.split(SEPARATOR)[0].equalsIgnoreCase(CARD)).count() != CARD_COUNT) {
            throw new ValidationException("Only one card allowed.");
        }

        var card = Arrays.stream(args)
                .filter(a -> a.split(SEPARATOR)[0].equalsIgnoreCase(CARD))
                .findFirst().get();

        if (card.split(SEPARATOR)[0].equalsIgnoreCase(CARD)
                && card.split(SEPARATOR)[1].chars().allMatch(Character::isDigit)) {
            return true;
        }

        throw new ValidationException("Invalid card format. Should be 'card-...' with digits.");
    }

    private static boolean validateItemsFormat(String[] args) {
        if (Arrays.stream(args).allMatch(a ->
                a.split(SEPARATOR)[0].chars().allMatch(Character::isDigit)
                        && a.split(SEPARATOR)[1].chars().allMatch(Character::isDigit))) {
            return true;
        }

        throw new ValidationException("Invalid items format. Should be '...-...' with digits.");
    }
}
