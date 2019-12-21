import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class main {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		statistic s=new statistic();
		kpp k=new kpp(s);
		validation v =new validation(s,new kpp(s));
		ArrayList<point> p=new ArrayList<point>();
		ArrayList<point> p2=new ArrayList<point>();
		ArrayList<Double> pr=new ArrayList<Double>();
		ArrayList<point> app=new ArrayList<point>();
		ArrayList<point> test=new ArrayList<point>();
		//p=s.lire_fichier();
		p2=s.lire_fichier();
		
		System.out.println("CV Regression = "+v.Validation_Croisee_RL(p2));
		
		System.out.println("CV KPPV : = "+v.Validation_Croisee_KPP(p2));
		
		
	  /*  System.out.println("Moyenne X :" +s.moyenneX(p));
		System.out.println("Moyenne Y :" +s.moyenneY(p));
		
		System.out.println("Variance X :" +s.varianceX(p));
		System.out.println("Variance Y :" +s.varianceY(p));
		
		System.out.println("Ecartype X :"+s.ecartypeX(p));
		System.out.println("Ecartype Y :"+s.ecartypeY(p));
		
		System.out.println("Covarience  : "+s.cov(p));
		
		System.out.println("Corrolation : "+s.corrolation(p));
		
		System.out.println("Ligne de Regression : y^=" +s.a(p)+"x + "+s.b(p)+ " ");
	/*	
		pr=s.Ychap(p,p);
		for(int i=0;i<pr.size();i++)
		{
			System.out.println("Y^ =("+i+")"+pr.get(i));
		}
		
		System.out.println("SSE : "+s.SSE(p,k.prediction_tout_kppv(p,p)));
		System.out.println("TSS : "+s.TSS(p));
		System.out.println("RMSE : +"+s.RMSE(p,k.prediction_tout_kppv(p,p)));
		System.out.println("NRMSE : "+s.NRMSE(p,k.prediction_tout_kppv(p,p)));	*/
		
		
		/*ArrayList<point> proche=new ArrayList<point>();
		proche=kpp.kppV(p,11.16);
		
		System.out.println("Les plus proches voisins du point a x = 11.16 sont : ");
		for(int i=0;i<proche.size();i++)
		{
			System.out.println("x = "+proche.get(i).x+" y = " +proche.get(i).y);
		}
		System.out.println("Y predis par kppV de x=11.16 est  : "+kpp.prediction_y_kpp(11.16,p));
		
		ArrayList<Double> ych=k.Ychap(p,p);
		System.out.println("NRMSE : "+s.NRMSE(p,ych));
		*/
}
	
	
}
