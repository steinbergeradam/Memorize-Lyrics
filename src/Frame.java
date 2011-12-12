import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame extends JFrame {
	
	private static final long serialVersionUID = 2L;
	private JPanel panel = new JPanel();
	protected JLabel label = new JLabel("text", JLabel.CENTER);
	protected JTextField textField = new JTextField(20);
	private String line = "";
	private boolean correct = false;
	protected Queue<String> queue = null;
	protected int lineNum = 0;
	
	public Frame(String title) {
		
		this.setTitle(title);
		this.add(this.panel, BorderLayout.CENTER);
		this.panel.add(this.label);
		this.panel.add(this.textField);
		
		this.setSize(300,80);
		TextListener listener = new TextListener();
		textField.addActionListener(listener);
		
		this.panel.setLayout(new GridLayout(2,1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	} // end Frame() constructor
	
	public void lyric() {
		if (queue.isEmpty()) {
			lineNum++;
			setCorrect(false);
			String line = queue.dequeue();
			this.label.setText("line " + lineNum + " of " + queue.size() + " / guess 1 of 10");
			this.setLine(line);
			setQueue(queue);
		} // end if
	} // end lyric()
	
	public boolean isCorrect() {
		return correct;
	} // end isCorrect()

	public void setCorrect(boolean correct) {
		this.correct = correct;
	} // end setCorrect()

	public String getLine() {
		return line;
	} // end getLine()

	public void setLine(String line) {
		this.line = line;
	} // end setLine()
	
	public Queue<String> getQueue() {
		return queue;
	} // end getQueue()

	public void setQueue(Queue<String> queue) {
		this.queue = queue;
	} // end setQueue()
	
	public int getLineNum() {
		return lineNum;
	} // end getLineNum()

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	} // end setLineNum()
	
	private class TextListener implements ActionListener {
		
		private int guesses = 0;
		private int mistakes = 0;
		
		public void actionPerformed(ActionEvent e) {
			String input = textField.getText().toLowerCase().trim();
			String lyric = getLine().toLowerCase().trim();
			if (input.equals(lyric) && guesses < 9) {
				guesses++;
				textField.setText("");
				label.setText("line " + lineNum + " of " + queue.size() + " / guess " + (guesses+1) + " of 10");
				textField.grabFocus();
			} else if (input.equals(lyric) && guesses == 9 && lineNum != queue.size()) {
				textField.setText("");
				setCorrect(true);
				textField.grabFocus();
				lyric();
				guesses = 0;
			} else if (mistakes < 2) {
				mistakes++;
			} else if (mistakes == 2 && !(lineNum == queue.size() && guesses == 9)) {
				mistakes = 0;
				label.setText(lyric);
			} else {
				textField.setText("");
				label.setText("done");
			} // end if
		} // end actionPerformed()
		
	} // end TextListener class

} // end Frame class
