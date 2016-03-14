import java.lang.*;
import java.lang.CloneNotSupportedException;
import java.lang.IllegalAccessError;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.InterruptedException;

public class Object {
    private static native void registerNavtives();
    static {
        registerNavtives();
    }

    public final native Class<?> getClass();

    public native int hashCode();

    public boolean equals(Object obj) {return this == obj;}

    protected native Object clone() throw CloneNotSupportedException;

    public String toString() {return getClass() + "@" + Integer.toHexString();}

    public final native void notify();

    public final native void nofityAll();

    public final native void wait(long timeOut) throws InterruptedException;

    public final void wait(long timeOut, int nanos) throws InterruptedException {
        if (timeOut < 0) {
            throws new java.lang.IllegalArgumentException("time out");
        }

        if (nanos < 0 || nanos > 999999) {
            throws new IllegalArgumentException("nanosecond timeout value out of range")
                    ;
        }
        if (nanos >= 500000 || (nanos != 0 && timeOut ==0)) {
            timeOut++;
        }
        wait(timeOut);
    }

    public final void wait() throws InterruptedException{
        wait(0);
    }

    protected void finalize() throws Throwable{}
}