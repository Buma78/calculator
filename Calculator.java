import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class Calculator implements ActionListener{
    
	JFrame frame;
	JTextField textfield;
	
	JButton[] number_button=new JButton[10];
	JButton[] opration_button=new JButton[8];
	JButton add,sub,mul,div;
	JButton dot,del,clr,equl;
	JPanel panel;
	
	Font myFont=new Font("Ink Free",Font.ITALIC,30);
	
	double num1=0,num2=0,result=0;
	char opration;
	
	Calculator(){
		 
		frame=new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
	    textfield=new JTextField();
	    textfield.setBounds(45, 25, 320, 50);
	    textfield.setFont(myFont);
	    textfield.setEditable(false);
	    
		add=new JButton("+");
		sub=new JButton("-");
		mul=new JButton("*");
		div=new JButton("/");
		dot=new JButton(".");
		del=new JButton("del");
		clr=new JButton("clr");
		equl=new JButton("=");
	    
		opration_button[0]=add;
	    opration_button[1]=sub;
	    opration_button[2]=mul;
	    opration_button[3]=div;
	    opration_button[4]=dot;
	    opration_button[5]=del;
	    opration_button[6]=clr;
	    opration_button[7]=equl;
	    
	    for(int i=0;i<8;i++) {
	    	opration_button[i].addActionListener(this);
	    	opration_button[i].setFont(myFont);
	    	opration_button[i].setFocusable(false);
	    }
	    
	    // add number_button
	    
	    for(int i=0;i<10;i++) {
	    	number_button[i]=new JButton(String.valueOf(i));
	    	number_button[i].addActionListener(this);
	    	number_button[i].setFont(myFont);
	    	number_button[i].setFocusable(false);
	    }
	    
	    del.setBounds(50, 430,145, 50);
	    clr.setBounds(200, 430,145, 50);
	    
	    panel=new JPanel();  // add panel for adding button of numbers and sign.
	    panel.setBounds(50, 100, 300, 300);
	    panel.setLayout(new GridLayout(4,4,10,10));  // 4,4 is row and column and 10,10 is space and pixels.
	    //panel.setBackground(Color.CYAN);
	    
	    // now add buttons to the panel
	    panel.add(number_button[1]);
	    panel.add(number_button[2]);
	    panel.add(number_button[3]);
	    panel.add(add);
	    panel.add(number_button[4]);
	    panel.add(number_button[5]);
	    panel.add(number_button[6]);
	    panel.add(sub);
	    panel.add(number_button[7]);
	    panel.add(number_button[8]);
	    panel.add(number_button[9]);
	    panel.add(mul);
	    panel.add(dot);
	    panel.add(number_button[0]);
	    panel.add(equl);
	    panel.add(div);
	    
	    frame.add(panel);
	    frame.add(del);   // add delete button to frame
	    frame.add(clr);   // add clear button to frame
		frame.add(textfield);
		frame.setVisible(true);
		
		
	}
    @Override
    public void actionPerformed(ActionEvent e) {
    	// add functionality to number_button
    	for(int i=0;i<10;i++) {
    		if(e.getSource()==number_button[i]) {
    			textfield.setText(textfield.getText().concat(String.valueOf(i)));
    		}
    	}
    	if(e.getSource()==dot) {                            
    		textfield.setText(textfield.getText().concat("."));
    	}
    	if(e.getSource()==add) {

    		if(textfield.getText().length()==0) {  // cheak if there is empty string
    			num1=0;
    		}
    		else if(textfield.getText().charAt(0)=='-' && textfield.getText().length()>1){
    			num1=Double.parseDouble(textfield.getText().substring(1));
    			num1=num1*(-1);
        		opration ='+';
        		textfield.setText("");
    		}
    		else {
    		num1=Double.parseDouble(textfield.getText());
    		opration ='+';
    		textfield.setText("");
    		}
    	}
    	
    	if(e.getSource()==sub) {
//    		if(textfield.getText().length()==0) {
//    			num1=0;
//    		}
    		if(textfield.getText().length()==0) {
    			textfield.setText("-");
    		}
    		else if(textfield.getText().charAt(0)=='-' && textfield.getText().length()>1){
    			num1=Double.parseDouble(textfield.getText().substring(1));
    			num1=num1*(-1);
        		opration ='-';
        		textfield.setText("");
    		}
    		else {
    		num1=Double.parseDouble(textfield.getText());
    		opration ='-';
    		textfield.setText("");
    		}
    	}
    	if(e.getSource()==mul) {
    		if(textfield.getText().length()==0) {
    			num1=0;
    		}
    		else if(textfield.getText().charAt(0)=='-' && textfield.getText().length()>1){
    			num1=Double.parseDouble(textfield.getText().substring(1));
    			num1=num1*(-1);
        		opration ='*';
        		textfield.setText("");
    		}
    		else {
    		num1=Double.parseDouble(textfield.getText());
    		opration ='*';
    		textfield.setText("");
    		}
    	}
    	if(e.getSource()==div) {
    		if(textfield.getText().length()==0) {
    			num1=0;
    		}
    		else if(textfield.getText().charAt(0)=='-' && textfield.getText().length()>1){
    			num1=Double.parseDouble(textfield.getText().substring(1));
    			num1=num1*(-1);
        		opration ='/';
        		textfield.setText("");
    		}
    		else {
    		num1=Double.parseDouble(textfield.getText());
    		opration ='/';
    		textfield.setText("");
    		}
    	}
    	
    	if(e.getSource()==del) {
    		
    		String s=textfield.getText();
    		if(s.length()!=0) {
    			int n=s.length();
    			String sub_s=s.substring(0, n-1);
    			textfield.setText(sub_s);
    		}   		
    	}
        if(e.getSource()==clr) {
    		textfield.setText("");
    		num1=0;
    		num2=0;
    		result=0;
    	}
        
        if(e.getSource()==equl) {
        	if(textfield.getText().length()==0) {
    			num2=0;
    		}
        	else {
        		num2=Double.parseDouble(textfield.getText());
        	}
        	if(opration=='+') {
        		result=num1+num2;
        		DecimalFormat df = new DecimalFormat();  //used for set the precision value after decimal
        		df.setMaximumFractionDigits(4);          //used for set the precision value after decimal
        		String x=df.format(result);              //used for set the precision value after decimal
        		textfield.setText(x);
        	}
        	else if(opration=='-') {
        		result=num1-num2;
        		DecimalFormat df = new DecimalFormat();  //used for set the precision value after decimal
        		df.setMaximumFractionDigits(4);
        		String x=df.format(result);
        		textfield.setText(x);
        	}
        	else if(opration=='*') {
        		result=num1*num2;
        		DecimalFormat df = new DecimalFormat();  //used for set the precision value after decimal
        		df.setMaximumFractionDigits(4);
        		String x=df.format(result);
        		textfield.setText(x);
        	}
        	else if(opration=='/') {
        		if(num2==0) {
        			textfield.setText("0");
        		}
        		else {
        		result=num1/num2;
        		DecimalFormat df = new DecimalFormat();  //used for set the precision value after decimal
        		df.setMaximumFractionDigits(4);
        		String x=df.format(result);
        		textfield.setText(x);
        		}
        	}
        }
    	
    }
}