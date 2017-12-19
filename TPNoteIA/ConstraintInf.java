package git;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintInf extends Constraint {

	public ConstraintInf(BufferedReader in) throws Exception {
		super(in);
		/*	diff = new ArrayList<Object>();
		for (String v : in.readLine().split(";")) diff.add(v);	// Val1;Val2;...;Val(arity)
		 */
	}

	public boolean violation(Assignment a) {
		ArrayList<Object> temp = new ArrayList<Object> ();
		if (a.getVars().containsAll(varList)){
			for (int i=0;i < getArity(); i++){
				temp.add(a.get(varList.get(i)));}

			for (int i=0;i<temp.size()-1; i++) {
				for (int j= i+1;j<temp.size();j++) {
					if (Math.abs(Integer.parseInt((String)temp.get(i)))-Integer.parseInt((String)temp.get(j)) >= 0) return true;
				}
			}
		}
		return false;

	}

	public String toString(){
		return "inf "+super.toString();		
	}
}

					