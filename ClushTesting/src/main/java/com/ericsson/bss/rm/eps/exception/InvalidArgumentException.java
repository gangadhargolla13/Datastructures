package com.ericsson.bss.rm.eps.exception;

public class InvalidArgumentException
        extends Exception
{
    private static final long serialVersionUID = 1L;

    public InvalidArgumentException(String message)
    {
        super(message);
    }

    public InvalidArgumentException(String message, Exception cause)
    {
        super(message, cause);
    }
}
