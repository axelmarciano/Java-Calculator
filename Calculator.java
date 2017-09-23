import java.util.ArrayList;
import java.util.Arrays;
public class Calculator  {
    public double add(double _f,double _s) {
	double _result=_f+_s;
	return _result;
    }
    public double subtract(double _f, double _s) {
	double _result=_f-_s;
	return _result;
    }
    public double multiply(double _f, double _s) {
	double _result=_f*_s;
	return _result;
    }
    public double divide(double _f, double _s) {

	try{
	    if(_s==0){
		throw new CalcException();
	    }
	    else{
	   
	    double _result=_f/_s;
	    return _result;
	    }
	}
	catch(Exception e){
	    return 0.0;
	}
	
    }

    
    public double compute(String _s) {
	ArrayList<String> operande = new ArrayList<String>();
	ArrayList<Double> opere = new ArrayList<Double>();
        ArrayList<String> equal = new ArrayList<String>();
	equal.add("+");
	equal.add("-");
	equal.add("*");
	equal.add("/");

	for(int i=0;i<_s.length();i++) {
	    String _ch=_s.substring(i,i+1);
	    if(equal.contains(_ch)) {
		if(_s.length()>2){
		    opere.add(Double.parseDouble(_s.substring(0,i)));
		    operande.add(_ch);
		}
		else{
		    opere.add(Double.parseDouble(_s.substring(0,i)));
		}
		_s=_s.substring(i+1,_s.length());
		i=0;
	    }

	}
	
	if(_s.length()>0 && !equal.contains(_s)){
	    opere.add((Double.parseDouble(_s)));
	}



	Double Temp=0.0;
	
	
	for(int i=0;i<operande.size();i++) {
	    switch(operande.get(i)){
	    case "*":
		Temp=this.multiply(opere.get(i),opere.get(i+1));
		opere.remove(i);
		opere.remove(i);
		operande.remove(i);
		opere.add(0,Temp);
		i=i-1;
		break;
	    case "/":
		Temp=this.divide(opere.get(i),opere.get(i+1));
		opere.remove(i);
		opere.remove(i);
		operande.remove(i);
		opere.add(0,Temp);
		i=i-1;
		break;
	    }
     
	}

	
	for(int i=0;i<operande.size();i++) {
	    switch(operande.get(i)){
	    case "+":
		Temp=this.add(opere.get(i),opere.get(i+1));
		opere.remove(i);
		opere.remove(i);
		operande.remove(i);
		opere.add(0,Temp);
		i=i-1;
		break;
	    case "-":
		Temp=this.subtract(opere.get(i),opere.get(i+1));
		opere.remove(i);
		opere.remove(i);
		operande.remove(i);
		opere.add(0,Temp);
		i=i-1;
		break;
	    }
     
	}
	
	return opere.get(0);
		
    }

    
}
