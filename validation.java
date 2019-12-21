import java.util.ArrayList;

public class validation {
public statistic s;
public kpp k;
	
	validation(statistic s,kpp kpp){
		this.s=s;
		this.k=kpp;
	}
	
	public double Validation_Croisee_RL(ArrayList<point> p)
	{
		double CV=0;
		ArrayList<Double> N= new ArrayList<Double>();
		ArrayList<Double> d;
		int k=0,j;
		ArrayList<point> test,app;
		
		for(k=0;k<p.size()/10;k++)
		{
			test=new ArrayList<point>();
			app=new ArrayList<point>();
			d=new ArrayList<Double>();
			for(j=0;j<p.size();j++)
			{
				if(j>k*10 && j<(k*10)+10)
					test.add(p.get(j));
				else {
					app.add(p.get(j));
				}
			}
			d=s.Ychap(app,test);
			double NRMSE=s.NRMSE(test,d);
			N.add(NRMSE);
		}
		
		for(int i=0;i<N.size();i++)
		{
			CV+=N.get(i);
		}
		return CV/(N.size());
	}
	
	public double Validation_Croisee_KPP(ArrayList<point> p)
	{
		double CV=0;
		ArrayList<Double> N= new ArrayList<Double>();
		ArrayList<Double> d;
		int k=0,j;
		ArrayList<point> test,app;
		
		for(k=0;k<p.size()/10;k++)
		{
			test=new ArrayList<point>();
			app=new ArrayList<point>();
			d=new ArrayList<Double>();
			for(j=0;j<p.size();j++)
			{
				if(j>k*10 && j<(k*10)+10)
					test.add(p.get(j));
				else {
					app.add(p.get(j));
				}
			}
			d=kpp.prediction_tout_kppv(app,test);
			double NRMSE=s.NRMSE(test,d);
			//System.out.println("NRMSE : "+NRMSE);
			N.add(NRMSE);
		}
		
		for(int i=0;i<N.size();i++)
		{
			CV+=N.get(i);
		}
		return CV/(N.size());
	}
	
	
	
	
}
