package factoryRace;

import interfaces.AbstractRace;

public class RaceFactory implements InterfaceRaceFactory {
	
	int size;
	
	public RaceFactory() {
		size = 4;
	}
	
	public AbstractRace make (String s) throws IndexOutOfBoundsException {
	
		AbstractRace r;
		
		switch(s)
		{
			case "race1":
				r = new Race1();
				break;
			case "race2":
				r = new Race2();
				break;
			case "race3":
				r = new Race3();
				break;
			case "race4":
				r = new Race4();
				break;
			default:
				throw new IndexOutOfBoundsException();
		}	

		return r;
	}
			
	public int getSize() {
		return size;
	}

}
