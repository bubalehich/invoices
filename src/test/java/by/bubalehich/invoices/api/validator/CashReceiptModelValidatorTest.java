package by.bubalehich.invoices.api.validator;

import by.bubalehich.invoices.exception.ValidationException;
import by.bubalehich.invoices.objectmother.ObjectMother;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CashReceiptModelValidatorTest {
    @InjectMocks
    private CashReceiptModelValidator validator;

    @Test
    @DisplayName("╯°□°）╯")
    void testValidateSuccess() {
        var model = ObjectMother.getCashReceiptMutationModel();

        assertDoesNotThrow(() -> validator.validate(model));
    }

    @Test
    void testValidateWithInvalidCardNumber() {
        var expectedExceptionMessage = "Invalid card format.";
        var model = ObjectMother.getCashReceiptMutationModelWithInvalidCard();

        var actual = assertThrows(ValidationException.class, () -> validator.validate(model));

        assertNotNull(actual);
        assertEquals(expectedExceptionMessage, actual.getMessage());
    }

    @Test
    void testValidateWithInvalidItem() {
        var expectedExceptionMessage = "Invalid item(s) format.";
        var model = ObjectMother.getCashReceiptMutationModelWithInvalidItem();

        var actual = assertThrows(ValidationException.class, () -> validator.validate(model));

        assertNotNull(actual);
        assertEquals(expectedExceptionMessage, actual.getMessage());
    }
}