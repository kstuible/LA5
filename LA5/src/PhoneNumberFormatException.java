
public class PhoneNumberFormatException extends Exception {
	
	/**
	 * Exception to be thrown from improperly formatted phone number, providing message with phone number string
	 * that threw the exception
	 * @param phoneNumber	a phone number string that threw the exception
	 */
	public PhoneNumberFormatException(String phoneNumber) {
		super(phoneNumber);
	}
}
