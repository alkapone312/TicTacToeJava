package KolkoKrzyzyk;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
	
	public static int[] move(char[][] plane, boolean mark)
	{
		int[] pos = new int[2];
		pos[0]=-1;
		pos[1]=-1;
		char sign = mark ? 'X' : 'O';
		List<int[]> list = new ArrayList<int[]>();
		
		for(int x = 0; x < 2; x++)
		{
			for(int i = 0 ; i < plane.length ; i++)
			{
				int count = 0;
				for(int j = 0 ; j < plane.length ; j++)
				{
					if(plane[i][j] == sign)
					{
						count++;
						if(count >= 2)
						{
							for(int d = 0 ; d < plane.length ; d++)
							{
								if(plane[i][d] == '#')
								{
									pos[0]=i;
									pos[1]=d;
									System.out.println("LOL");
								}
							}
							if(pos[0]==-1)break;
							return pos;
						}
					}
				}
				pos[0]=-1;
				pos[1]=-1;
			}
			
			for(int j = 0 ; j < plane.length ; j++)
			{
				int count = 0;
				for(int i = 0 ; i < plane.length ; i++)
				{
					if(plane[i][j] == '#')
					{
						pos[0]=i;
						pos[1]=j;
						list.add(new int[]{pos[0],pos[1]});
					}
					else if(plane[i][j] == sign)
					{
						count++;
						if(count >= 2)
						{
							for(int d = 0 ; d < plane.length ; d++)
							{
								if(plane[d][j] == '#')
								{
									pos[0]=d;
									pos[1]=j;
									System.out.println("LOL");
								}
							}
							if(pos[0]==-1)break;
							return pos;
						}
					}
				}
				pos[0]=-1;
				pos[1]=-1;
			}
			
			sign = mark ? 'O' : 'X';
		}
		
		if(list.isEmpty())
		{
			return new int[0];
		}
		else
		{
			Set<int[]> set = new HashSet<int[]>(list);
			list.clear();
			list.addAll(set);
	        return list.get((int)(Math.random() * list.size())); 
		}
		
	}
	
}
