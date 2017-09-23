import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.util.ArrayList;
import  javax.swing.*;
import  java.awt.*;
import  java.awt.event.*;

public class Window extends JFrame implements ActionListener{
    protected ArrayList<Button> buttons;
    protected JLabel _screen;
    protected Calculator _calc;
    private Boolean testreturn;
    private String lastope;
    
    public Window(String title, int height, int width) {
	this.lastope=null;
	this.testreturn=false;
	this._calc = new Calculator();
	this.setTitle(title);
	this.setSize(width,height);
	this.buttons = new ArrayList<Button>();
	for(int i=0;i<10;i++){
	    Button temp = new Button(Integer.toString(i),SwingConstants.CENTER,
				     SwingConstants.CENTER);
	    buttons.add(temp);	    
	}
	Button plus = new Button("+",SwingConstants.CENTER,
				 SwingConstants.CENTER);
	Button minus = new Button("-",SwingConstants.CENTER,
				  SwingConstants.CENTER);
	Button mult = new Button("*",SwingConstants.CENTER,
				 SwingConstants.CENTER);
	Button divide = new Button("/",SwingConstants.CENTER,
				   SwingConstants.CENTER);
	Button reset = new Button("Reset", SwingConstants.CENTER,
				  SwingConstants.CENTER);
	Button compulte = new Button("=", SwingConstants.CENTER,
				     SwingConstants.CENTER);
	Button deleteb = new Button("Supr", SwingConstants.CENTER,
				    SwingConstants.CENTER);
     
	JLabel _testscreen = new JLabel();
	    
	buttons.add(plus);
	buttons.add(minus);
	buttons.add(mult);
	buttons.add(divide);
	buttons.add(reset);
	buttons.add(compulte);
	buttons.add(deleteb);

	JPanel WindowsContent = new JPanel();
	BorderLayout dispositionl = new BorderLayout();
	WindowsContent.setLayout(dispositionl);
	
	JPanel panneauChiffres= new JPanel();
	
	panneauChiffres.setLayout(new GridLayout(5,4));

	panneauChiffres.add(buttons.get(7));
        panneauChiffres.add(buttons.get(8));
        panneauChiffres.add(buttons.get(9));
        panneauChiffres.add(buttons.get(10));
	panneauChiffres.add(buttons.get(4));
        panneauChiffres.add(buttons.get(5));
        panneauChiffres.add(buttons.get(6));
        panneauChiffres.add(buttons.get(11));
        panneauChiffres.add(buttons.get(1));
        panneauChiffres.add(buttons.get(2));
        panneauChiffres.add(buttons.get(3));
        panneauChiffres.add(buttons.get(12));
        panneauChiffres.add(buttons.get(13));
        panneauChiffres.add(buttons.get(0));
        panneauChiffres.add(buttons.get(14));
        panneauChiffres.add(buttons.get(15));
	panneauChiffres.add(buttons.get(16));
	this._screen= new JLabel("0");
	this._screen.setPreferredSize(new Dimension(80, 80));
	
	WindowsContent.add("Center", panneauChiffres);
	WindowsContent.add("North",this._screen);
       
	this.setContentPane(WindowsContent);
	this.pack();
	this.setSize(new Dimension(height,width));
	for(int k=0;k<buttons.size();k++) {
	    buttons.get(k).addActionListener(this);
	}

	this.setVisible(true);
   	
    }

    public void actionPerformed(ActionEvent e) {
	String _last=this._screen.getText()
	    .substring(this._screen.getText().length() - 1);
	Button source = (Button)e.getSource();
	String _c=source.getText();
	String equal="+ - * / = Reset Supr";
	if(this.testreturn && source.getText()!="Reset" && source.getText()!="="
	   && source.getText()!="Supr" && !equal.contains(source.getText())){
	    this._screen.setText(source.getText());
	    this.testreturn=false;
	    return;
	}
	if(this._screen.getText().equals("0")) {
	    if(!equal.contains(_c)){
		this._screen.setText(source.getText());
	    }
	    if(_c.equals("-")){
		this._screen.setText("-");
	    }
	    return;
	}
     	switch(source.getText()) {
	case "Reset":
	    this._screen.setText("0");
	    break;
	case "=":
	    this.lastope=this._screen.getText();
	    if(this.lastope.length()>0){
		if(this.lastope.substring(0,1).equals("-")){
		    this.lastope="0"+this.lastope;	   
		}
	    }
	    this._screen.setText(String.valueOf(this._calc.
						compute(this.lastope)
						) );	    
	    this.testreturn=true;	   
	    break;
	case "Supr":	  
	    if(this._screen.getText().length()==1){
		if(this.lastope!=null){
		    if(this.lastope.length()>1 && this.lastope.substring(1,2).equals("0")){
			this.lastope=this.lastope.substring(1);
		    }
		    this._screen.setText(this.lastope);
		    return;
		}
		this._screen.setText("0");
	    }
	    if(this._screen.getText().length()>1) {
		this._screen.setText(this._screen.getText().
				     substring(0,this._screen.getText().length()-1));
	    }
	    break;
	default:
	    if(equal.contains(_c) && equal.contains(_last)) {
	        if(_last.equals("+") && _c.equals("-")) {
		    this._screen.setText(this._screen.getText().substring(0,this._screen.getText().length()-1));
		    this._screen.setText(this._screen.getText()+"-");
		    return;
		}
	       
		return;
	    }
	    this._screen.setText(this._screen.getText()+source.getText());
	    this.testreturn=false;
	    return;
	}

	
    }      
    
}
