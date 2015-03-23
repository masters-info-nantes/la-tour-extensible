package jobFE;

import interfaces.AbstractJob;


public class JobFEFactory {
	
	JobFE[] job;
	int sizeJob;
	
	public JobFEFactory() {
		sizeJob = 6;
		job = new JobFE[sizeJob];
		job[0] = new JobFE("Mage de vent",4,0,1);	
		job[1] = new JobFE("Mage de feu",5,0,0);
		job[2] = new JobFE("Sentinelle",3,3,2);
		job[3] = new JobFE("Guerrier",5,0, 1);
		job[4] = new JobFE("General",2,5,0);
		job[5] = new JobFE("Chevalier dragon",3,3,3);
	}
	
	public AbstractJob make (int i) throws IndexOutOfBoundsException {
		if (i>sizeJob || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractJob j = new JobFE(job[i].getJob(), job[i].getForce(), job[i].getDefence(), job[i].getLife());
		return j;
	}
	
	public AbstractJob[] getList(){
		return job;
	}
			
	public int getSize() {
		return sizeJob;
	}

}
