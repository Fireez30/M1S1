package tp1;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class testZebre {

	/*@Test
	public void test() {
		String fileName="\\junitzebre";
		Network myNetwork = null;
		try {
			System.out.println("Chargement du fichier : "+new java.io.File("../").getCanonicalPath()+ "/" + fileName);
		} catch (IOException e) {
			System.out.println("Erreur lors du chargement du fichier ! ");
			e.printStackTrace();
		}
		BufferedReader readFile=null;
		try {
			readFile = new BufferedReader(new FileReader("C:\\Users\\Fireez\\Desktop\\Master\\eclipse\\IntelligenceArtificielle"+fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Erreur lors de la lecture du fichier  ! ");
			e.printStackTrace();
		}
		try {
			myNetwork= new Network(readFile);
		} catch (Exception e) {
			System.out.println("Erreur lors du chargement du network ! ");
			e.printStackTrace();
		}
		try {
			readFile.close();
		} catch (IOException e) {
			System.out.println("Erreur lors de la fermeture du fichier ! ");
			e.printStackTrace();
		}
		CSP x = new CSP(myNetwork);
		Assignment A = new Assignment() ;
		
		A.put("english", 2);
		A.put("norvegian", 2);
		A.put("japanese", 2);
		A.put("spanish", 2);
		A.put("ukranian", 2);
		System.out.println(myNetwork.toString());
		System.out.println(A.toString());
		assertTrue(x.consistant("english",A));
	}
*/
}
