import javax.swing.*;       // package for frames/panels - import all classes 
import java.awt.*;          // package for abstract window toolcase - graphics
import java.awt.event.*;    // package for handling mouse/keyboard events

public class EmailClientComposeMessage implements ActionListener    {

// ActionListener is an interface that handles events

    private JFrame frame = null;
    
    //panels in frame
    private JPanel panel1 = null;
    private JPanel panel2 = null;
    private JPanel panel3 = null;
    
    //objects in panel1 
    private JLabel receiverLabel = null;
    private JTextField receiver  = null;
    private JLabel subjectLabel  = null;
    private JTextField subject   = null;
    
    //object in panel2 
    private JTextArea message = null;
    private JScrollPane scroll = null;
    
    //objects in panel3
    private JButton send    = null;
    private JButton cancel  = null;
    
    
    public EmailClientComposeMessage(){   
	//constructor - set up frame
	frame = new JFrame("Compose New Message - ICS3U TOPS Bloor CI");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(180, 160);
	frame.setResizable(false);
	
	//set up container with three panels
	Container contentPane = frame.getContentPane();
	BoxLayout contentPaneLayout = new BoxLayout(contentPane, BoxLayout.Y_AXIS);
	contentPane.setLayout(contentPaneLayout);
	
	panel1 = new JPanel();
	panel2 = new JPanel();
	panel3 = new JPanel();        
	
	//adds panels to container
	contentPane.add(panel1);
	contentPane.add(panel2);
	contentPane.add(panel3);
	
	//set up first panel layout (default)
	FlowLayout panel1Layout = new FlowLayout(FlowLayout.CENTER);
	panel1.setLayout(panel1Layout);
	
	receiverLabel = new JLabel("To:");
	panel1.add(receiverLabel);
	
	receiver = new JTextField(9);
	receiver.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	panel1.add(receiver);
	
	subjectLabel = new JLabel("Subject:");
	panel1.add(subjectLabel);
	
	subject = new JTextField(51);
	subject.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	panel1.add(subject);
	
	
	//set up second panel
	FlowLayout panel2Layout = new FlowLayout(FlowLayout.CENTER);
	panel2.setLayout(panel2Layout);
	
	message = new JTextArea(10, 69);
	scroll = new JScrollPane (message);
	panel2.add(scroll);
	message.setBorder(BorderFactory.createLineBorder(Color.black));
	message.setLineWrap(true);
	message.setWrapStyleWord(true);
	
	//set up third panel
	FlowLayout panel3Layout = new FlowLayout(FlowLayout.CENTER);
	panel3.setLayout(panel3Layout);
	
	send = new JButton("Send");
	panel3.add(send);
	
	cancel = new JButton("Cancel");
	panel3.add(cancel);
	
	//button function
	send.addActionListener(this);
	cancel.addActionListener(this);
	
	//visibility
	frame.pack();
	frame.setVisible(true); 
	
   
    }
    
    public void actionPerformed(ActionEvent event) {
	Object buttonPressed = event.getSource();
	if (buttonPressed == send)  {
	    String senderID = NetIO.myUserName();
	    senderID = Utils.leftPad(senderID, Globals.SENDER_LEN, '0');
	    
	    if (senderID.length() == Globals.SENDER_LEN && Utils.isANumber(senderID)) {
		String receiverID = receiver.getText().toLowerCase();
		receiverID = receiverID.length() == 0 ? Globals.STR_NULL : Utils.leftPad(receiverID, Globals.RECEIVER_LEN, '0');
		
		if (receiverID.length() == Globals.RECEIVER_LEN)  {
		    String entireMessage = Globals.SEND_MESSAGE + senderID + receiverID + Utils.leftPad(Globals.STR_NULL, Globals.DATE_TIME_LEN, '0') + 
		    Globals.FIRST_RECORD_OF_MESSAGE + subject.getText() + Globals.END_OF_SUBJECT_MARKER + message.getText();
		
		    int errorCode = NetIO.sendRequest(entireMessage, Globals.SERVER_IP_ADDRESS);
		    if (errorCode == Globals.NET_OK) {
			frame.dispose();
		    }
		    else    {
			JOptionPane.showMessageDialog(null, "Message Not Delivered", "ICS3U Error Manager", JOptionPane.ERROR_MESSAGE);
		    }
		}
		else {
		    JOptionPane.showMessageDialog(null, "Receiver ID must be 9 Digits", "ICS3U Error Manager", JOptionPane.ERROR_MESSAGE);
		}
	    }
	    else {
		JOptionPane.showMessageDialog(null, "Sender ID must be 9 Digits", "ICS3U Error Manager", JOptionPane.ERROR_MESSAGE);                                  
	    }
	}
	else if (buttonPressed == cancel)    {
	    frame.dispose();
	}
    }
    
    public static void main(String[] args)  {
	EmailClientComposeMessage e = new EmailClientComposeMessage();
    } 
}
