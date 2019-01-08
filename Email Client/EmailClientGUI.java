import javax.swing.*;       // package for frames/panels - import all classes 
import java.awt.*;          // package for abstract window toolcase - graphics
import java.awt.event.*;    // package for handling mouse/keyboard events

public class EmailClientGUI implements ActionListener    {
    private JFrame frame = null;
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;
    
    EmailClientPane eMailClientPane = null;
    
    private JLabel clientHeader = null;
    
    private JButton compose = null;
    private JButton getMail = null;
    private JButton delete = null;
    private JButton inBox = null;
    private JButton outBox = null;
    
    public EmailClientGUI() {
	frame = new JFrame("Bloor TOPS Email Client 2017");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.setLocation(100, 50);
	frame.setResizable(false);
	
	Container contentPane = frame.getContentPane();
	BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
	contentPane.setLayout(contentPaneLayout);
	
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3 = new JPanel();
	
	contentPane.add(panel1);
	contentPane.add(panel2);
	contentPane.add(panel3);
	
	//panel 1
	FlowLayout panel1Layout = new FlowLayout(FlowLayout.LEFT);
	panel1.setLayout(panel1Layout);
	
	clientHeader = new JLabel(" From                  Date Received                                        Subject");
	panel1.add(clientHeader);
	
	//panel2 
	
	FlowLayout panel2Layout = new FlowLayout(FlowLayout.LEFT);
	panel2.setLayout(panel2Layout);
	eMailClientPane = new EmailClientPane();
	panel2.add(eMailClientPane.getSplitPane());
	
	//panel3
	
	FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER);
	compose = new JButton("Compose");
	panel3.add(compose);
	
	getMail = new JButton("Get Mail");
	panel3.add(getMail);
	
	delete = new JButton("Delete");
	panel3.add(delete);
	
	inBox = new JButton("Inbox");
	panel3.add(inBox);
	
	outBox = new JButton("Outbox");
	panel3.add(outBox);
	
	
	compose.addActionListener(this);
	getMail.addActionListener(this);
	delete.addActionListener(this);
	inBox.addActionListener(this);
	outBox.addActionListener(this);
	
	frame.pack();
	frame.setVisible(true); 
	
    } 
    
    public void actionPerformed(ActionEvent event){
    }
}
