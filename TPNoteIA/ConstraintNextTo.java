package git;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintNextTo extends Constraint {

	public ConstraintNextTo(BufferedReader in) throws Exception {
		super(in);
	}

	public boolean violation(Assignment a) {
		ArrayList<Object> temp = new ArrayList<Object> ();
		if (a.getVars().containsAll(varList)){
			for (int i=0;i < getArity(); i++){
				temp.add(a.get(varList.get(i)));}

			for (int i=0;i<temp.size()-1; i++) {
				for (int j= i+1;j<temp.size();j++) {
					if (Math.abs(Integer.parseInt((String)temp.get(i)))-Integer.parseInt((String)temp.get(j)) != 1) return true;
				}
			}
		}
		return false;

	}

	public String toString(){
		return "nextTo "+super.toString();		
	}
}

			