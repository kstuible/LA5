
public interface IContactInformationFormatter {

	// read contact information from a list of files, given file paths
	void readContactInformation(String[] filePaths);
	
	// format the contact information in one file
	void formatContactInformation(String fileName);
	
	// format one email address
	void formatEmail(String Email) throws EmailAddressFormatException;
	
	// format one phone number
	void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException;
	
	// format one name
	void formatName(String name) throws NameFormatException;
	
}
