import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

	String cifEmail;
	String cifPhoneNumber;
	String cifName;
	FormatExceptionHandler handler = new FormatExceptionHandler();
	
	@Override
	// read contact information from a list of files, given file paths
	public void readContactInformation(String[] filePaths) {
		
		for(int i = 0; i < filePaths.length; i++) {
			File file = new File(filePaths[i]);
			
			try {
				Scanner fileIn = new Scanner(file);
				cifName = fileIn.nextLine();
				cifPhoneNumber = fileIn.nextLine();
				cifEmail = fileIn.nextLine();
				
				formatContactInformation(filePaths[i]);
				
				fileIn.close();
			} 
			catch (FileNotFoundException e) {
				
				handler.handleFileNotFoundException(e);
			}
		}
	}

	@Override
	// format the contact information in one file
	public void formatContactInformation(String fileName) {
		try {
			formatName(cifName);
		} catch (NameFormatException e) {
			
		}
		try {
			formatPhoneNumber(cifPhoneNumber);
		} catch (PhoneNumberFormatException e) {
			
		}
		try {
			formatEmail(cifEmail);
		} catch (EmailAddressFormatException e) {
			handler.handleEmailFormatException(e);
		}
	}

	@Override
	// format one email address
	public void formatEmail(String email) throws EmailAddressFormatException {
			if(email.equals(email.toLowerCase())) {
				System.out.println(email);
			} else {
				throw new EmailAddressFormatException();
			}
			
	}
		

	@Override
	// format one phone number
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		
	}

	@Override
	// format one name
	public void formatName(String name) throws NameFormatException {
		
	}

}
