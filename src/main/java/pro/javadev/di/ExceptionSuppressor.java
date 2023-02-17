package pro.javadev.di;

@SuppressWarnings("all")
public class ExceptionSuppressor {

    public static <T extends Throwable> void throwException(Throwable throwable) throws T {
        throw (T) throwable;
    }

}
