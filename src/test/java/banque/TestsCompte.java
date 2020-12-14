package banque;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import banque.exception.CompteException;

public class TestsCompte  {
	
	
    @Test
    public void testProprietaire() throws CompteException{
        Compte c1 = new Compte("01010", "cptTest");   
        assertEquals("cptTest",c1.getProprietaire() );
        
        c1.setProprietaire("Hernando E.");
        assertEquals("Hernando E.",c1.getProprietaire() );
    }
    
    @Test
    public void testRetirer() throws CompteException{
        Compte c1 = new Compte("12345", "cptTest");
        assertEquals(0.0,c1.soldeCompte());
        
        c1.retirer(100);
        assertEquals(-100.0,c1.soldeCompte());
    }
    
    @Test
    public void testDepot() throws CompteException {
        Compte c1 = new Compte("56789", "cptTest");
        assertEquals(0.0,c1.soldeCompte());
        
        c1.deposer(100);
        assertEquals(100.0, c1.soldeCompte());
    }

}
