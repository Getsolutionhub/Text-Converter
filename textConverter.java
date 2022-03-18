package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class textConverter extends JFrame {
    //JFrame components declarations start here  :
    JLabel counterLabel = new JLabel();
    JLabel mainHeading = new JLabel();
    JScrollPane jScrollPane1 = new JScrollPane();
    JTextArea previewTextBox = new JTextArea();
    JButton uppercaseBtn = new JButton();
    JLabel previewTextLabel = new JLabel();
    JButton lowercaseBtn = new JButton();
    JButton copyBtn = new JButton();
    JScrollPane jScrollPane2 = new JScrollPane();
    JTextArea mainTextbox = new JTextArea();
    JLabel mainTextBoxLabel = new JLabel();
    JButton removeSpaecBtn = new JButton();
    JButton clearBtn = new JButton();
    JButton cutBtn = new JButton();
    JButton pasteBtn = new JButton();

    //Create a constructor
    textConverter(){

        counterLabel.setFont(new Font("Tahoma", 1, 18));
        add(counterLabel);
        counterLabel.setText("Words : 0 , Character : 0 , Spaces : 0");
        counterLabel.setBounds(320, 280, 400, 30);

        mainHeading.setFont(new Font("Tahoma", 1, 18));
        mainHeading.setText("TEXT CONVERTER :");
        add(mainHeading);
        mainHeading.setBounds(340, 20, 200, 30);

        previewTextBox.setEditable(false);
        previewTextBox.setColumns(20);
        previewTextBox.setRows(5);
        previewTextBox.setToolTipText("Preview Text Here");
        previewTextBox.setFont(new Font("Tahoma", 1, 18));
        jScrollPane1.setViewportView(previewTextBox);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 340, 850, 190);

        uppercaseBtn.setFont(new Font("Tahoma", 1, 14));
        uppercaseBtn.setText("UPPERCASE");
        uppercaseBtn.setToolTipText("UPPERCASE");
        add(uppercaseBtn);
        uppercaseBtn.setBounds(50, 540, 120, 40);
        uppercaseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        previewTextLabel.setFont(new Font("Tahoma", 1, 18));
        previewTextLabel.setText("Preview Text Here :");
        add(previewTextLabel);
        previewTextLabel.setBounds(30, 310, 220, 30);

        lowercaseBtn.setFont(new Font("Tahoma", 1, 14));
        lowercaseBtn.setText("lower case");
        lowercaseBtn.setToolTipText("lower case");
        add(lowercaseBtn);
        lowercaseBtn.setBounds(180, 540, 120, 40);
        lowercaseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        copyBtn.setFont(new Font("Tahoma", 1, 14));
        copyBtn.setText("Copy");
        copyBtn.setToolTipText("Copy");
        add(copyBtn);
        copyBtn.setBounds(310, 540, 90, 40);
        copyBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        pasteBtn.setFont(new Font("Tahoma", 1, 14));
        pasteBtn.setText("Paste");
        pasteBtn.setToolTipText("Paste");
        add(pasteBtn);
        pasteBtn.setBounds(410, 540, 90, 40);
        pasteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        mainTextbox.setColumns(20);
        mainTextbox.setRows(5);
        mainTextbox.setToolTipText("Enter Your Text Here");
        mainTextbox.setFont(new Font("Tahoma", 1, 18));
        jScrollPane2.setViewportView(mainTextbox);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 90, 850, 190);

        mainTextBoxLabel.setFont(new Font("Tahoma", 1, 18));
        mainTextBoxLabel.setText("Enter Your Text Here :");
        add(mainTextBoxLabel);
        mainTextBoxLabel.setBounds(20, 60, 220, 30);

        removeSpaecBtn.setFont(new Font("Tahoma", 1, 14));
        removeSpaecBtn.setText("Remove Space");
        removeSpaecBtn.setToolTipText("Remove Extra Spaces");
        add(removeSpaecBtn);
        removeSpaecBtn.setBounds(590, 540, 160, 40);
        removeSpaecBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        clearBtn.setFont(new Font("Tahoma", 1, 14));
        clearBtn.setText("Clear");
        clearBtn.setToolTipText("Clear all text");
        add(clearBtn);
        clearBtn.setBounds(760, 540, 73, 40);
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        cutBtn.setFont(new Font("Tahoma", 1, 14));
        cutBtn.setText("Cut");
        cutBtn.setToolTipText("Cut");
        add(cutBtn);
        cutBtn.setBounds(510, 540, 70, 40);
        cutBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setTitle("TEXT CONVERTER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFont(new Font("Tahoma", 1, 14));
        setLocation(new Point(400, 100));
        setResizable(false);
        setSize(900, 650);
        setLayout(null);
        setVisible(true);

        //Button AddEventListener start here :

        //1.Create uppercase button
        uppercaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    String str = mainTextbox.getText().toUpperCase();
                    previewTextBox.setText(str);
                }
            }
        });
        //2.Create lowercase button
        lowercaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    String str = mainTextbox.getText().toLowerCase();
                    previewTextBox.setText(str);
                }
            }
        });
        //3.word count , character count and white spaces
        mainTextbox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String str = mainTextbox.getText();
                previewTextBox.setText(str);
                //Count number of character are there :
                int TotalChar = str.length();
                int numSpaces=0;
                int numWords=0;

                //Count number of spaces are there :
                    for (char c : mainTextbox.getText().toCharArray()){
                        if(c ==' '){
                            numSpaces++;
                        }
                    }
                //Count number of words are there :
                    for (String s : mainTextbox.getText().split("\\s+")){
                        numWords++;
                        if(mainTextbox.getText().length()<1){
                            numWords=0;
                        }
                    }

                counterLabel.setText("Words : "+numWords+" , Character : "+ TotalChar +" , Spaces : "+numSpaces +"");
            }
        });
        //4.Create copy button
        copyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    previewTextBox.selectAll();
                    previewTextBox.copy();
                }
            }
        });
        //4.Create cut button
        cutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    previewTextBox.selectAll();
                    previewTextBox.setEditable(true);
                    previewTextBox.cut();
                    previewTextBox.setEditable(false);
                  }
            }
        });
        //5.Create clear button
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    previewTextBox.setText("");
                    mainTextbox.setText("");
                    counterLabel.setText("Words : 0 , Character : 0 , Spaces : 0");
                }
            }
        });
        //6.Create remove extra white spaces button
        removeSpaecBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    String str = mainTextbox.getText().replaceAll("\\s+"," ");
                    mainTextbox.setText(str);
                    previewTextBox.setText(str);
                }
            }
        });
        //
        pasteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mainTextbox.getText().length()==0){
                    mainTextbox.requestFocus();
                    JOptionPane.showMessageDialog(null,"Please Enter Text In TextBox...","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    mainTextbox.paste();
                }
            }
        });

    }
    //main method start here
    public static void main(String[] args) {
        new textConverter();
    }
}
