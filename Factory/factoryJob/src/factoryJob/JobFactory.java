package factoryJob;

import interfaces.AbstractJob;

public class JobFactory implements InterfaceJobFactory {

	Job[] job;
	int sizeJob;
	
	public JobFactory() {
		sizeJob = 4;
		job = new Job[sizeJob];
		job[0] = new Job("job0",100,100,100);	
		job[1] = new Job("job1",101,101,101);
		job[2] = new Job("job2",102,102,102);
		job[3] = new Job("job3",103,103,103);
	}
	
	public AbstractJob make (int i) throws IndexOutOfBoundsException {
		if (i>sizeJob || i<0)
			throw new IndexOutOfBoundsException();
	
		AbstractJob j = new Job(job[i].getJob(), job[i].getForce(), job[i].getDefence(), job[i].getLife());
		return j;
	}
			
	public int getSize() {
		return sizeJob;
	}
}
