package KolkoKrzyzyk;
import java.util.Scanner;

public class MainClass {
	
	public static void main(String[] args)
	{
		// for example size 3 = 3x3 plane
		int size = 3;
		
		// variables
		Scanner scan = new Scanner(System.in);
		Plane plane = new Plane(size);
		char result;
		
		//x or o is starting
		double random = Math.random();
		Boolean sign = (random > 0.5 ? true : false);
		
		//game loop
		while(true)
		{
			plane.displayPlane();
			
			//so user pick a place to place a sign
			System.out.println("Podaj kolumne:");
			int y = scan.nextInt();
			System.out.println("Podaj rz¹d:");
			int x = scan.nextInt();
			
			//here is setting field and changing sign
			if(x < size && y < size && x >= 0 && y >= 0)
			{
				sign = plane.setField(sign, x, y);
			}
			else
			{
				//if coordinates out of plane
				System.out.println("Zakres od 0 do " + (size-1) );
			}
			
			//getting result # if no winner, X if X winner, O if O winner
			result = Score.checkScore(Plane.plane);
			if(result != '#')break;
			
			//if plane run out of empty fields
			if(plane.emptyFields == 0) {break;}
		}
		
		//ending stuff
		scan.close();
		plane.displayPlane();
		if(result != '#')
		System.out.println("Zwyciezc¹ jest: " + result + ", gratulacje!");
		else
		System.out.println("Mamy remis! Dziêkuje za grê.");
	}
}
