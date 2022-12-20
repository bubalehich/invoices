package by.bubalehich.invoices.utils.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Result {
    private boolean succeed;

    private String errors;

    protected Result(){
        succeed = true;
    }

    protected Result(String errors){
        succeed = false;
        this.errors = errors;
    }

    public static Result ok(){
        return new Result();
    }

    public static Result failure(String errors){
        return new Result(errors);
    }
}
