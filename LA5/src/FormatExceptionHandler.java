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
		
	}

}
