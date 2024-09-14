package logic;

public class CantDepositLessThanZeroException extends RuntimeException{
    public CantDepositLessThanZeroException(String message) {
        super(message);
    }
}
