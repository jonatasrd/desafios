package idwall.desafio.string;

/**
 * Created by Jonatas Ramos
 */
public class IdwallFormatter extends StringFormatter {

	// returns the OS dependent line separator
	private static String lineSeparator = System.getProperty("line.separator");
	private static String linha = "JONATAS RAMOS DOMINGOS DA SILVA";

	private static final String DEFAULT_INPUT_TEXT = "In the beginning God created the heavens and the earth. Now the earth was formless and empty, darkness was over the surface of the deep, and the Spirit of God was hovering over the waters."
			+ "\n"
			+ "And God said, \"Let there be light,\" and there was light. God saw that the light was good, and he separated the light from the darkness. God called the light \"day,\" and the darkness he called \"night.\" And there was evening, and there was morning - the first day.";

	/**
	 * Should format as described in the challenge
	 *
	 * @param text
	 * @return
	 */
	@Override
	public String format(String text, Integer limit, boolean justify) {
		limit -= 1;
		if (justify)
			return justify(format(text, limit));
		return format(text, limit);
	}

	private String format(String text, int limit) {
		StringBuilder txt = new StringBuilder(text);

		for (int i = limit; i <= txt.length(); i += limit) {
			
			String[] linhas = txt.substring(i - limit + 2, i).split(lineSeparator);
			
				System.out.println("linha " + linhas.length);
			
			while (mustDecrement(txt, i)) {
				i--;
			}
			if(txt.charAt(i)==' ')
				txt.deleteCharAt(i).insert(i, lineSeparator);
			else
				txt.deleteCharAt(i + 1).insert(i + 1, lineSeparator);
		}
		return txt.toString();
	}

	private boolean mustDecrement(StringBuilder txt, int i) {
		return txt.charAt(i) != ' ' && txt.charAt(i + 1) != ' ';
	}

	private String justify(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

		IdwallFormatter idwallFormatter = new IdwallFormatter();
		idwallFormatter.format(DEFAULT_INPUT_TEXT, 40);

	}
}
