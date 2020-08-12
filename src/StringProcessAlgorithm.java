import java.io.FileWriter;
import java.io.IOException;

//Format String to proper html format
public class StringProcessAlgorithm {
	public static void main(String[] args) throws IOException {
		String adapterdescription = "afafafes\ndsfefaef";
		for (int i = 0; i < 4; i++) {
			FileWriter myWriter = new FileWriter("descriptions.txt", true);
		    myWriter.write("\n" + adapterdescription);
			myWriter.close();
		}
	}
}
