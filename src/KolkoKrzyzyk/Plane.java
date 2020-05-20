package KolkoKrzyzyk;

public class Plane {
	static char[][] plane;
	static int emptyFields;
	
	public Plane(int size)
	{
		//declaring plane
		plane = new char[size][size];
		emptyFields = size * size;
		for(int i = 0 ; i < size ; i++)
		{
			for(int j = 0; j < size; j++)
			{
				plane[i][j] = '#';
			}
		}
	}
	
	public void displayPlane() 
	{
		//Displays plane
		
		//x numbers
		System.out.print("  ");
		for(int j = 0; j < plane.length; j++)
		{
			System.out.print(j);
		}
		System.out.println();
		
		//y numbers + plane
		for(int i = 0 ; i < plane.length ; i++)
		{
			//y number
			System.out.print(i + " ");
			
			//rest of plane
			for(int j = 0; j < plane.length; j++)
			{
				System.out.print(plane[i][j]);
			}
			System.out.println();
		}
		
		//space between displayed planes
		System.out.println();
	}
	
	//sets field by coordinates
	public Boolean setField(Boolean mark, int x, int y)
	{
		//true = X | false = O
		char sign = (mark ? 'X' : 'O');
		
		//if field isn't filled
		if(plane[x][y] == '#')
		{
			plane[x][y] = sign;
			//swap sign and return
			mark = mark ? false : true;
			emptyFields--;
		}
		return mark;
	}
	
}
