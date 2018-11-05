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
			handler.handleNameFormatException(e);
		}
		try {
			formatPhoneNumber(cifPhoneNumber);
		} catch (PhoneNumberFormatException e) {
			handler.handlePhoneNumberFormatException(e);
		}
		try {
			formatEmail(cifEmail);
		} catch (EmailAddressFormatException e) {
			handler.handleEmailFormatException(e);
		}
		System.out.println();
	}

	@Override
	// format one email address
	public void formatEmail(String email) throws EmailAddressFormatException {
		if(email.equals(email.toLowerCase())) {
			System.out.println(email);
		} else {
			throw new EmailAddressFormatException(email);
		}	
	}
		

	@Override
	// format one phone number
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		
		phoneNumber = phoneNumber.replaceAll("[^\\d.]", "");
		phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
		if(phoneNumber.equals(phoneNumber)) {
		System.out.println(phoneNumber);
		} else {
			throw new PhoneNumberFormatException(phoneNumber);
		}
	}

	@Override
	// format one name
	public void formatName(String name) throws NameFormatException {
		String[] nameArr = name.split(" ");
		String first = nameArr[0].toLowerCase();
		String last = nameArr[1].toLowerCase();
		String capFirst = first.substring(0,1).toUpperCase() + first.substring(1);
		String capLast = last.substring(0,1).toUpperCase() + last.substring(1);
		String goodName = String.join(" ", capFirst, capLast);
		
		if(name.equals(goodName)) {
			System.out.println(name);
		} else {
			throw new NameFormatException(name);
		}
	}
}
