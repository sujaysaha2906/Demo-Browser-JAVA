
import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browser extends JFrame{
	private TextField field1 = new TextField();
	private JEditorPane display1 = new JEditorPane();
	private JScrollPane scroll1 = new JScrollPane(display1);
	
	public static void main(String args[]){
		Browser file = new Browser();
		file.frameHandler();
	}
	
	public void frameHandler(){
		setTitle ("Browser");
		setSize (1000,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		addCompotentsToFrame(getContentPane());
	}
	
	public void addCompotentsToFrame(Container pane){
		Insets inset1 = getInsets();
		
		pane.add(field1);
		pane.add(scroll1);
		
		Font font1 = new Font("Menlo", Font.PLAIN, 12);
		
		field1.setFont(font1);
		
		field1.setBounds(7 - inset1.left, 30 - inset1.top, 990, 25);
		
		scroll1.setBounds(7 - inset1.left, 55 - inset1.top, 990, 780);
		
		actionListenerCalls();
	}
	
	private void actionListenerCalls(){
		field1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event1){
				loadData("http://" + event1.getActionCommand());
			}
		});
		
		display1.addHyperlinkListener(new HyperlinkListener(){
			public void hyperlinkUpdate(HyperlinkEvent event2){
				if (event2.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
					loadData(event2.getURL().toString());
				}
			};
		});
	}
	
	private void loadData(String text){
		try{
			display1.setPage(text);
		}catch(Exception event1){
			System.out.println("Wrong Address");
		}
	}
}
