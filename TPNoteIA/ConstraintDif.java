package git;

import java.io.BufferedReader;
import java.util.ArrayList;

public class ConstraintDif extends Constraint {

	public ConstraintDif(BufferedReader in) throws Exception {
		super(in);
		/*	diff = new ArrayList<Object>();
		for (String v : in.readLine().split(";")) diff.add(v);	// Val1;Val2;...;Val(arity)
		 */
	}

	@Override
	/*	public boolean violation(Assignment a) {
		ArrayList<Object> bar = new ArrayList<Object> ();
		for (int i=0;i<varList.size()-1;i++){
			if (a.getVars().contains(varList.get(i)))
				for (int j=i+1;j<varList.size();j++)
					if (a.getVars().contains(varList.get(j))) {
						for (int k=0;k < getArity(); k++){
							bar.add(a.get(varList.get(k)));}

						for (int l=0;l<bar.size()-1; l++)
							for (int m= l+1;m<bar.size();m++)
								if (bar.get(l).equals(bar.get(m))) return true;
					}
		}
		return false;

	}
	 */

	public boolean violation(Assignment a) {
		ArrayList<Object> temp = new ArrayList<Object> ();

		if (a.getVars().containsAll(varList)){
			for (int i=0;i < getArity(); i++){
				temp.add(a.get(varList.get(i)));}

			for (int i=0;i<temp.size()-1; i++) {
				for (int j= i+1;j<temp.size();j++) {
					if (temp.get(i).equals(temp.get(j))) return true;
				}
			}
		}
		return false;

	}

	public String toString(){
		return "dif "+super.toString();		
	}
}
