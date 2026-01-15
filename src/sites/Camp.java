package sites;

import personnages.Romain;
import personnages.Soldat;
import personnages.Grades;

public class Camp {
	private Soldat commandant ; 
	
	public Camp(Soldat commandant) {
			this.commandant = commandant ; 
	        
	    }
	public Romain getCommandant() {
        return commandant;
    }
}
