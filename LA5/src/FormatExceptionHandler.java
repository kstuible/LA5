import java.io.FileNotFoundException;

public class FormatExceptionHandler implements IFormatExceptionHandler {

	@Override
	public void handleFileNotFoundException(FileNotFoundException e) {
		System.out.println("File not Found!");
	}

	@Override
	public void handlePhoneNumberFormatException(PhoneNumberFormatException e) {
		
	}

	@Override
	public void handleEmailFormatException(EmailAddressFormatException e) {
		String email = e.getMessage();
		email = email.toLowerCase();
		System.out.println(email);
	}

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
