package git;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintEq extends Constraint {

	public ConstraintEq(BufferedReader in) throws Exception {
		super(in);
		/*	diff = new ArrayList<Object>();
		for (String v : in.readLine().split(";")) diff.add(v);	// Val1;Val2;...;Val(arity)
		 */
	}

	@Override
	public boolean violation(Assignment a) {
		ArrayList<Object> temp = new ArrayList<Object> ();

		if (a.getVars().containsAll(varList)){
			for (int i=0;i < getArity(); i++){
				temp.add(a.get(varList.get(i)));}

			for (int i=0;i<temp.size()-1; i++) {
				for (int j= i+1;j<temp.size();j++) {
					if ((! temp.get(i).equals(temp.get(j)))) return true;
				}
			}
		}
		return false;

	}
	public String toString(){
		return "eq "+super.toString();
	}

}
