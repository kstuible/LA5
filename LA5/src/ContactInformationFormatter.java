import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContactInformationFormatter implements IContactInformationFormatter {

	String cifEmail;
	String cifPhoneNumber;
	String cifName;
	FormatExceptionHandler handler = new FormatExceptionHandler();
	
	/**
	 * read contact information from a list of files, given file paths
	 * loops through the files, storing lines as strings to be used in the formatter
	 * @param filePaths	a string array, the array of file names to be read
	 */
	@Override
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
	/**
	 * format the contact information in one file
	 * reads in each line of the file, tries to format each, and catches then handles the exception 
	 * thrown if the information is not properly formatted
	 * @param fileName	a String of the name of the file being formatted
	 */
	@Override
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
	/**
	 * formats one email address
	 * checks if email is properly formatted. If yes, prints out email. 
	 * if not, throws EmailFormatException
	 * @param email	a string for the email line
	 */
	@Override
	public void formatEmail(String email) throws EmailAddressFormatException {
		if(email.equals(email.toLowerCase())) {
			System.out.println(email);
		} else {
			throw new EmailAddressFormatException(email);
		}	
	}
		
	/**
	 * format one phone number
	 * checks if phone number is properly formatted, prints if yes, 
	 * throws PhoneNumberFormatException if not
	 * @param phoneNumber	a string for the phone number line
	 */
	@Override
	public void formatPhoneNumber(String phoneNumber) throws PhoneNumberFormatException {
		
		String formattedNumber = phoneNumber.replaceAll("[^\\d.]", "");
		formattedNumber = formattedNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
		if(phoneNumber.equals(formattedNumber)) {
			System.out.println(phoneNumber);
		} else {
			throw new PhoneNumberFormatException(phoneNumber);
		}
	}

	/**
	 * format one name
	 * checks if name is properly formatted, if yes, prints it out, if not, 
	 * throws NameFormatException
	 * @param name	a string for the name line
	 */
	@Override
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
