package factoryJobPokemon;

import interfaces.AbstractJob;

public class JobFactory implements InterfaceJobFactory {

	Job[] job;
	int sizeJob;
	
	public JobFactory() {
		sizeJob = 4;
		job = new Job[sizeJob];
		job[0] = new Job("Aventurier",2,1,0);	
		job[1] = new Job("Taxis",0,3,2);
		job[2] = new Job("Méchant",3,3,5);
		job[3] = new Job("Gentil",2,4,4);
	}
	
	public AbstractJob make (int i) throws IndexOutOfBoundsException {
		if (i>sizeJob || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractJob j = new Job(job[i].getJob(), job[i].getForce(), job[i].getDefence(), job[i].getLife());
		return j;
	}
	
	public AbstractJob[] getList(){
		return job;
	}
			
	public int getSize() {
		return sizeJob;
	}
}
