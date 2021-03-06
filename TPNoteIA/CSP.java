package git;

import java.util.ArrayList;
import java.util.*;
/**
 * Solveur : permet de résoudre un problème de contrainte par Backtrack : 
 * 	Calcul d'une solution, 
 * 	Calcul de toutes les solutions
 *
 */
public class CSP {

	private Network network;			// le réseau à résoudre
	private ArrayList<Assignment> solutions; 	// les solutions du réseau (résultat de searchAllSolutions)
	private Assignment assignment;			// l'assignation courante (résultat de searchSolution)
	int cptr;					// le compteur de noeuds explorés

	/**
	 * Crée un problème de résolution de contraintes pour un réseau donné
	 * 
	 * @param r le réseau de contraintes à résoudre
	 */
	public CSP(Network r) {
		network = r;
		solutions = new ArrayList<Assignment>();
		assignment = new Assignment();

	}



	/********************** BACKTRACK UNE SOLUTION *******************************************/

	/**
	 * Cherche une solution au réseau de contraintes
	 * 
	 * @return une assignation solution du réseau, ou null si pas de solution
	 */

	public Assignment searchSolution() {
		cptr=1;

		// pretraitement
		Assignment sol = backtrack();
		if (sol == null) {System.out.println("Pas de solution ! ");}
		else {System.out.println(cptr + " noeuds ont été explorés");}
		return sol;
	}

	/* La methode bactrack ci-dessous travaille directement sur l'attribut assignment. 
	 * On peut aussi choisir de ne pas utiliser cet attribut et de créer plutot un objet Assignment local à searchSolution : 
	 * dans ce cas il faut le passer en parametre de backtrack
	 */
	/**
	 * Exécute l'algorithme de backtrack à la recherche d'une solution en étendant l'assignation courante
	 * Utilise l'attribut assignment
	 * @return la prochaine solution ou null si pas de nouvelle solution
	 */

	private Assignment backtrack() {
		cptr++;
		if (assignment.size()==network.getVarNumber()){
			return assignment;}
		String x=chooseVar(assignment);
		for(int i=0;i<tri(network.getDom(x)).size();i++){
			assignment.put(x,network.getDom(x).get(i));
			if (consistant(x)) {
				if (backtrack() != null){return assignment;}	
				else {}
			}
		}
		return null;
	}



	/********************** BACKTRACK TOUTES SOLUTIONS *******************************************/

	/**
	 * Calcule toutes les solutions au réseau de contraintes
	 * 
	 * @return la liste des assignations solution
	 * 
	 */
	public ArrayList<Assignment> searchAllSolutions(){
		solutions.clear(); 
		assignment.clear();
		backtrackAll();
		System.out.println("Nb solutions : " + solutions.size());
		return solutions;
	}

	/**
	 * Exécute l'algorithme de backtrack à la recherche de toutes les solutions
	 * étendant l'assignation courante
	 * 
	 */
	private void backtrackAll() {
		if (assignment.size() == network.getVarNumber()){
			Assignment a = assignment.clone();
			solutions.add(a);
		}
		else {String x=chooseVar(assignment);
		for(int i=0;i<tri(network.getDom(x)).size();i++){
			assignment.put(x,network.getDom(x).get(i));
			if (consistant(x)) {backtrackAll();}
			assignment.remove(x);
		}
		}
	}


	// IMPLANTER l'UNE DES DEUX METHODES CHOOSEVAR CI-DESSOUS (SELON QUE L'ASSIGNATION COURANTE EST PASSEE EN PARAMETRE OU PAS)

	/**
	 * Retourne la prochaine variable à assigner étant donné assignment (qui doit contenir la solution partielle courante)
	 *  
	 * @return une variable non encore assignée
	 */
	private String chooseVar() {
		return null;
	}

	/*****************************************************************/

	/**
	 * Retourne la prochaine variable à assigner étant donné la solution partielle passée en paramètre
	 *  
	 *  @param sol solution partielle courante
	 * @return une variable non encore assignée
	 */
	private String chooseVar(Assignment sol) {
		return network.getVars().get(sol.size());
	}


	/**
	 * Fixe un ordre de prise en compte des valeurs d'un domaine
	 * 
	 * @param values une liste de valeurs
	 * @return une liste de valeurs
	 */
	private ArrayList<Object> tri(ArrayList<Object> values) {
		return values;
	}



	// IMPLANTER l'UNE DES DEUX METHODES CONSISTANT CI-DESSOUS (SELON QUE L'ASSIGNATION COURANTE EST PASSEE EN PARAMETRE OU PAS)

	/**
	 * Teste si l'assignation courante stokée dans l'attribut assignment est consistante, c'est à dire qu'elle
	 * ne viole aucune contrainte.
	 * 
	 * @param lastAssignedVar la variable que l'on vient d'assigner à cette étape
	 * @return vrai ssi l'assignment courante ne viole aucune contrainte
	 */
	private boolean consistant() {
		return false;
	}

	/**
	 * Teste si l'assignation courante stockée dans assignment est consistante par rapport à sol, c'est à dire qu'elle
	 * ne viole aucune contrainte.
	 * 
	 * @param sol solution partielle courante
	 * @param lastAssignedVar la variable que l'on vient d'assigner à cette étape
	 * @return vrai ssi l'assignment courante ne viole aucune contrainte
	 */


	private boolean consistant(String lastAssignedVar) {
		for (int i=0;i<network.getConstraintNumber();i++) {
			if(network.getConstraints().get(i).getVars().contains(lastAssignedVar)){
				if(network.getConstraints().get(i).violation(assignment)){
					return false;
				}
			}
		}
		return true;
	}

	boolean consistant(String lastAssignedVar,Assignment a) {
		for (int i=0;i<network.getConstraintNumber();i++) {
			if(network.getConstraints().get(i).getVars().contains(lastAssignedVar)){
				if(network.getConstraints().get(i).violation(a)){
					return false;
				}
			}
		}
		return true;
	}


}
