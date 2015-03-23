package factoryJobZelda;

import interfaces.AbstractJob;

public class JobFactory {

	Job[] job;
	int sizeJob;
	
	public JobFactory() {
		sizeJob = 4;
		job = new Job[sizeJob];
		job[0] = new Job("Hero",3, 3, 3);	
		job[1] = new Job("Pricesse", 2, 2, 5);
		job[2] = new Job("Mechant",3,3,5);
		job[3] = new Job("Vendeur",1 , 1, 1);
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
