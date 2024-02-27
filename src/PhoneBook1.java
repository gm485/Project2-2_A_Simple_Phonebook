//Project 2-2: A simple phone list.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class PhoneBook1 {
    JTextField jtfName;
    JTextField jtfNumber;
    JRadioButton jrbExact;
    JRadioButton jrbStartsWith;
    JRadioButton jrbEndsWith;
    JCheckBox jcbIgnoreCase;

    //a short list of names and phone numbers
    String[][] phoneList = {
            {"Jon", "555-8765"},
            {"Jessica", "555-5643"},
            {"Adam", "555-5643"},
            {"Rachel", "555-3435"},
            {"Tom & Jerry", "555-1001"}
    };

    PhoneBook1() {
        //create a new JFrame container
        JFrame jfrm = new JFrame("A Simple Phone List");

        //Grid Layout for the layout manager
        jfrm.getContentPane().setLayout(new GridLayout(0, 1));

        //frames initial size
        jfrm.setSize(240, 220);

        //terminate the program on closing the app
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //create labels
        JLabel jlabName = new JLabel("Name");
        JLabel jlabNumber = new JLabel("Number");
        JLabel jlabOptions = new JLabel("Search Options");

        //create text fields
        jtfName = new JTextField(10);
        jtfNumber = new JTextField(10);

        //create check box for Ignore Case
        jcbIgnoreCase = new JCheckBox("Ignore Case");

        //create the radio buttons
        jrbExact = new JRadioButton("Exact Match", true);
        jrbStartsWith = new JRadioButton("Starts With");
        jrbEndsWith = new JRadioButton("Ends with");

        //add radio buttons to a group
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbExact);
        bg.add(jrbStartsWith);
        bg.add(jrbEndsWith);

        //add action listener for the name text field
        jtfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                jtfName.setText(lookupName(jtfName.getText()));
            }
        });
        //add action listener for the number text field
        jtfNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jtfNumber.setText(lookupNumber(jtfNumber.getText()));
            }
        });
        //add the components to the content pane
        jfrm.getContentPane().add(jlabName);
        jfrm.add(jtfName);
        jfrm.add(jlabNumber);
        jfrm.add(jtfNumber);
        jfrm.add(new JLabel());
        jfrm.add(jlabOptions);
        jfrm.add(jcbIgnoreCase);
        jfrm.add(new JLabel());
        jfrm.add(jrbExact);
        jfrm.add(jrbStartsWith);
        jfrm.add(jrbEndsWith);

        //display the frame
        jfrm.setVisible(true);

    }

    //Look up name and return a number
    String lookupName(String n) {
        for (int i = 0; i < phoneList.length; i++) {
            if (jrbStartsWith.isSelected()) {
                if (jcbIgnoreCase.isSelected()) {
                    if (phoneList[i][0].toLowerCase().endsWith(n.toLowerCase()))
                        return phoneList[i][1];
                } else {
                    if (phoneList[i][0].startsWith(n))
                        return phoneList[i][1];
                }
            } else if (jrbEndsWith.isSelected()) {
                if (jcbIgnoreCase.isSelected()) {
                    if (phoneList[i][0].toLowerCase().endsWith(n.toLowerCase()))
                        return phoneList[i][1];
                } else {
                    if (phoneList[i][0].endsWith(n))
                        return phoneList[i][1];
                }
            } else {
                if (jcbIgnoreCase.isSelected()) {
                    if (phoneList[i][0].toLowerCase().equals(n.toLowerCase()))
                        return phoneList[i][1];
                } else {
                    if (phoneList[i][0].equals(n))
                        return phoneList[i][1];
                }
            }
        }
        return "Not Found";
    }

    //Look up a number and return the name
    String lookupNumber(String n) {
        for(int i=0; i<phoneList.length; i++)  {
            if(phoneList[i][1].equals(n))
                return phoneList[i][0];
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhoneBook1();
            }
        });
    }
}//end of class
