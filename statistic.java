import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class statistic {
	public statistic()
	{
	}
	public  ArrayList<point> lire_fichier()
	{
		ArrayList<point> p =new ArrayList<point>();
		
		try {
			Scanner in = new Scanner(new File("DataSet1.txt"));
			
			String one=in.nextLine();
			while(in.hasNext())
			{
				one=in.nextLine();
				String t[]=one.split("\t");
				
				double x= (double)Double.parseDouble(t[0]);
				double y= (double)Double.parseDouble(t[1]);
				p.add(new point(x,y));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
	public  ArrayList<point> lire_fichier2()
	{
		ArrayList<point> p =new ArrayList<point>();
		
		try {
			
			Scanner in = new Scanner(new File("DataSet2.txt"));
			String one=in.nextLine();
			while(in.hasNext())
			{
				one=in.nextLine();
				String t[]=one.split("\t");
				
				double x= (double)Double.parseDouble(t[0]);
				double y= (double)Double.parseDouble(t[1]);
				//System.out.println("x: = "+x +"y = "+y);
				p.add(new point(x,y));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	 public double moyenneX(ArrayList<point> p)
	 {
		double m=0;
		double sum=0;
		
		for(int i=0;i<p.size();i++)
		{
			sum+=p.get(i).x;
		}
		m=sum/p.size();
		return m;	 
	 }
	 
	 public double moyenneY(ArrayList<point> p)
	 {
		double m=0;
		double sum=0;
		
		for(int i=0;i<p.size();i++)
		{
			sum+=p.get(i).y;
		}
		m=sum/p.size();
		return m;	 
	 }
	
	 public double varianceX(ArrayList<point> p)
	 {
		  double variance=0;
		  double sum=0;
		  double mx=this.moyenneX(p);
		  
		  for(int i=0;i<p.size();i++)
		  {
			  sum+=((p.get(i).x - mx)*(p.get(i).x - mx));
		  }
		  variance=sum/p.size(); 
		  return variance;
	 }
	 
	 public double varianceY(ArrayList<point> p)
	 {
		  double variance=0;
		  double sum=0;
		  double mx=this.moyenneY(p);
		  
		  for(int i=0;i<p.size();i++)
		  {
			  sum+=((p.get(i).y - mx)*(p.get(i).y - mx));
		  }
		  variance=sum/p.size(); 
		  return variance;
	 }
	 
	 public double ecartypeX(ArrayList<point> p)
	 {
		 double e=0;
		 e=(double) Math.sqrt(this.varianceX(p));
		 return e;
	 }
	 
	 public double ecartypeY(ArrayList<point> p)
	 {
		 double e=0;
		 e=(double) Math.sqrt(this.varianceY(p));
		 return e;
	 }
	 
	 
	 
	 public double cov(ArrayList<point> p)
	 {
		 double cov=0;
		 
		 double sum=0;
		 double mx=this.moyenneX(p),my=this.moyenneY(p);
		 
		 for(int i=0;i<p.size();i++)
		 {
			 sum+=(p.get(i).x-mx)*(p.get(i).y - my);
		 }
		 
		 cov=sum/p.size();
		 return cov;
	 }
	 
	 public double corrolation(ArrayList<point> p)
	 {
		 double c=0;
		 c=cov(p)/(this.ecartypeX(p)*this.ecartypeY(p));
		 //System.out.println("Corrolation : "+c);
		 return c;
	 }
	 
	 
	 public  double a(ArrayList<point> p)
	 {
		 
		 double a;
		 double ex= ecartypeX(p),ey=ecartypeY(p);
		 double cor=corrolation(p);
		 a=cor*(ey/ex);
		 
		 return a;
	 }
	 
	 public double b(ArrayList<point> p)
	 {
		 
		 double b; 
		 b=moyenneY(p)-(a(p)*moyenneX(p));
		 return b;
	 }
	 
	 public ArrayList<Double> Ychap(ArrayList<point> app,ArrayList<point> test)
	 {
		 ArrayList<Double> f=new ArrayList<Double>();
		 double y=0;
		 double a = a(app),b=b(app);
		 for(int i=0;i<test.size();i++)
		 {
			 y=a*test.get(i).x+b;
			// System.out.println("Ychap ["+i+"]="+y);
			 f.add(y);
		 }
		 return f; 
	 }
	 
	
	 
	 

	 
	 
	 public double predictionLineaire(double x,ArrayList<point> p )
	 {
		 double a = a(p),b=b(p);
		 return  a*x+b;
	 }
	 
	 
	
	 
	 public double SSE(ArrayList<point> p,ArrayList<Double> d)
	 {
		 double SSE=0;

		 for(int i=0;i<p.size();i++)
		 {
			 SSE+=((p.get(i).y -d.get(i))*(p.get(i).y -d.get(i)));
		 }
		 
	//System.out.println("SSE ="+SSE);
		 return SSE;
	 }
	 
	 
	 
	 public double TSS(ArrayList<point> p)
	 {
		 double TSS=0;
		 for(int i=0;i<p.size();i++)
		 {
			 TSS+=((p.get(i).y - moyenneY(p))*(p.get(i).y - moyenneY(p)));
		 }
		 return TSS;
	 }
	 
	 public double  MSE(ArrayList<point> p,ArrayList<Double> ch)
	 {
		 double MSE=0;
		 
		 double SSE=SSE(p,ch);
		 MSE=SSE/p.size();
		 return MSE;
	 }

	 
	 public double RMSE(ArrayList<point> p,ArrayList<Double> ch) 
	 {
		 double RMSE =0;
		 RMSE = (double) Math.sqrt(MSE(p,ch));
		 return RMSE;
	 }
	 
	 public double NRMSE(ArrayList<point> p,ArrayList<Double> ch)
	 {
		 double NRMSE=0;
		 NRMSE=RMSE(p,ch)/moyenneY(p);
		 System.out.println("NRMSE ="+ NRMSE);
		 return NRMSE;
	 }
	 
	 
}

