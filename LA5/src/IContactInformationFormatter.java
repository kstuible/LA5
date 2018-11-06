
public interface IContactInformationFormatter {

	/**
	 * read contact info from a list of files, given file paths
	 * @param filePaths an array of strings with the names of the files/file paths to be used
	 */
	void readContactInformation(String[] filePaths);
	
	/**
	 * formats the contact info in one of the files
	 * @param fileName a string, the name of the file
	 */
	void formatContactInformation(String fileName);
	
	/**
	 * formats one email address
	 * @param Email	a string, the email address to be formatted
	 * @throws EmailAddressFormatException	an exception to be thrown in the case of an email not being properly formatted
	 */
	void formatEmail(String Email) throws EmailAddressFormatException;
	
	/**
	 * formats one phone number
	 *
	 * @param phoneNumber a string, the phone number to be formatted
	 * @throws PhoneNumberFormatException	exception to be thrown if phone number is not in the correct format
	 */
	void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException;
	
	/**
	 * formats one name
	 * @param name	a string, the name to be formatted
	 * @throws NameFormatException	exception to be thrown if name is not formatted properly
	 */
	void formatName(String name) throws NameFormatException;
	
}
