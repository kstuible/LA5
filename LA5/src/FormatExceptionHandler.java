import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler {
	
	/**
	 * handles file not found exception, printing out that file is not found
	 * @param e		the exception that was thrown
	 */
	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		System.out.println("File not Found!");
	}
	
	/**
	 * handles phone number format exception
	 * reformats the phone number string, then prints it out 
	 * @param e		the exception that was thrown
	 */
	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		String phoneNumber = e.getMessage();
		phoneNumber = phoneNumber.replaceAll("[^\\d.]", "");
		phoneNumber = phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)-$2-$3");
		System.out.println(phoneNumber);
	}
	
	/**
	 * handles email format exception
	 * reformats the email string, then prints out
	 * @param e		the exception that was thrown
	 */
	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		String email = e.getMessage();
		email = email.toLowerCase();
		System.out.println(email);
	}
	
	/**
	 * handles name format exception
	 * reformats the name, then prints out
	 * @param e		the exception that was thrown
	 */
	@Override
	public void handleNameFormatException(NameFormatException e) {
		String name = e.getMessage();
		String[] nameArr = name.split(" ");
		String first = nameArr[0].toLowerCase();
		String last = nameArr[1].toLowerCase();
		String capFirst = first.substring(0,1).toUpperCase() + first.substring(1);
		String capLast = last.substring(0,1).toUpperCase() + last.substring(1);
		String goodName = String.join(" ", capFirst, capLast);
		
		System.out.println(goodName);
	}

}
