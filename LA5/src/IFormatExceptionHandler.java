import java.io.FileNotFoundException;

public interface IFormatExceptionHandler {

	/**
	 * overridden method to handle file not found
	 * @param e an exception
	 */
	void handleFileNotFoundException(FileNotFoundException e);
	
	/**
	 * overridden method to handle phone number format exception
	 * @param e	an exception
	 */
	void handlePhoneNumberFormatException(PhoneNumberFormatException e);
	
	/**
	 * overridden method to handle email format exception
	 * @param e	an exception
	 */
	void handleEmailFormatException(EmailAddressFormatException e);
	
	/**
	 * overridden method to handle name format exception
	 * @param e	an exception
	 */
	void handleNameFormatException(NameFormatException e);
	
}
