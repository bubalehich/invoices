package by.bubalehich.invoices.utils.result;

import lombok.Getter;

@Getter
public class ResultValue <T> extends Result{
    private T value;

    private ResultValue(T value){
        if (value == null) throw new RuntimeException("Value must not be null.");
        this.value = value;
    }

    private ResultValue(String errors){
        super(errors);
    }

    public static <T> ResultValue<T> ok (T value){
        return new ResultValue<T>(value);
    }
}
