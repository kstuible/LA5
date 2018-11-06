
public class EmailAddressFormatException extends Exception {

	/**
	 * Exception to be thrown with an improperly formatted email, supplying the message with the email string
	 * @param email	a string, improperly formatted, to be fixed with the appropriate handler
	 */
	public EmailAddressFormatException(String email) {
		super(email);
	}
}
