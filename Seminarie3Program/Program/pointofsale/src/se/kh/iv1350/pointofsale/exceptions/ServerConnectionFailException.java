package se.kh.iv1350.pointofsale.exceptions;

/**
 * An exception for when the database is not running
 */
public class ServerConnectionFailException extends Exception{
    public ServerConnectionFailException(String message) {
        super(message);
    }
}