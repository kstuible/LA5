
public class NameFormatException extends Exception {

	/**
	 * Exception to be thrown from improperly formatted name, supplying message with name string
	 * @param name	the name string that threw the exception
	 */
	public NameFormatException(String name) {
		super(name);
	}

}
