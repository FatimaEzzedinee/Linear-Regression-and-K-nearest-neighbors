import java.util.ArrayList;

public class kpp {
	
	
	public statistic s;
	
	kpp(statistic s){
		this.s=s;
	}
	
	public static  ArrayList<Double> distance(double x,ArrayList<point> p )
	{
		ArrayList<Double> dist=new ArrayList<Double>();
		double d=0;
		
		for(int i=0;i<p.size();i++)
		{
			d=Math.sqrt((p.get(i).x - x)*(p.get(i).x - x));
			dist.add(d);
		}
		return dist;
	}
	
	
	public static double min(ArrayList<Double> d)
	{
		double min;
		min=d.get(0);
		for(int i=0;i<d.size();i++)
		{
			if(d.get(i)<min)
				min=d.get(i);
		}
		return min;
	}
	
	public static double dp(double x,double x1)
	{
		double d=0;
		d=Math.sqrt((x1 - x)*(x1 - x));
		return d;
	}
	public static ArrayList<point> kppV(ArrayList<point> p,double x)
	{
		ArrayList<point> proche=new ArrayList<point>();
		ArrayList<point> prr=new ArrayList<point>();
		for(int i=0;i<p.size();i++)
		{
			prr.add(p.get(i));
		}
		
		double min=0,dp;
		int k=(int) Math.sqrt(p.size());
		ArrayList<Double> d=null;
		//System.out.println("k = "+k);
		
		
		for(int i=0;i<k;i++)
		{
			d=distance(x,prr);
			min=min(d);
			for(int j=0;j<prr.size();j++)
			{
				dp=dp(x,prr.get(j).x);
				if(dp==min)
				{
					proche.add(prr.get(j));
					prr.remove(prr.get(j));
					d.remove(min);
					break;
				}
			}
		}

		return proche;
	}
	
	 public ArrayList<Double> Ychap(ArrayList<point> app,ArrayList<point> test)
	 {
		 ArrayList<Double> f=new ArrayList<Double>();
		 double y=0;
		 for(int i=0;i<test.size();i++)
		 {
			 
			 f.add(prediction_y_kpp(test.get(i).x,app));
		 }
		 return f; 
	 }

	public static double prediction_y_kpp(double x,ArrayList<point> p)
	{
		double y=0,sum=0;
		ArrayList<point> pp =kppV(p,x);
		for(int i=0;i<pp.size();i++)
		{
			//System.out.println(pp.get(i).y);
			sum+=pp.get(i).y;
		}
		
		y=sum/pp.size();
	//	System.out.println("Somme : "+sum +" s/k " + y);
		return y;
	}
	
	public static ArrayList<Double> prediction_tout_kppv(ArrayList<point> app,ArrayList<point> test)
	{
	ArrayList<Double> y=new ArrayList<Double>();
	//ArrayList<point> proche;
	double d;
	
	for(int i=0;i<test.size();i++)
	{
		d=prediction_y_kpp(test.get(i).x,app);
		y.add(d);
	}
	return y;
	}
	

	
	
}
