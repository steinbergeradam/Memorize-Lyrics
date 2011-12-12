import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		
		Frame frame = new Frame("Memorize Lyrics");
		File inputFile = new File("lyrics.txt");
		Scanner scan = new Scanner(inputFile);
		Queue<String> queue = new Queue<String>();
		
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			if (!line.startsWith("#"))
				queue.enqueue(line);
		} // end while
		
		scan.close();
		
		frame.setQueue(queue);
		
		frame.lyric();
		
	} // end main()

} // end Main class
