package KolkoKrzyzyk;

public class Score {
	
	public static char checkScore(char[][] plane)
	{
		//middle point of plane
		int size = plane.length;
		int m = ((plane.length-1)/2);
		
		//score from middle (4 possibilities)
		if(plane[m][m] != '#')
		{
			int score = 0;
			char s = plane[m][m];
			
			//left to right
			for(int i = m*-1 ; i<=m ; i++)
			{
				if(plane[i+m][m] == s) score++;
				else {score = 0; break;}
				if(score==size) return s;
			}
			
			//top to bottom
			for(int i = m*-1 ; i<=m ; i++)
			{
				if(plane[m][i+m] == s) score++;
				else {score = 0; break;}
				if(score==size) return s;
			}
			
			//top left to bottom right
			for(int i = m*-1 ; i<=m ; i++)
			{
				if(plane[i+m][i+m] == s) score++;
				else {score = 0; break;}
				if(score==size) return s;
			}
			
			//top right to bottom left
			for(int i = m*-1 ; i<=m ; i++)
			{
				if(plane[i+m][m-i] == s) score++;
				else {score = 0; break;}
				if(score==size) return s;
			}
		}

			//score around middle
			int score = 0;
			
			//all planes in x axis
			for(int i = 0 ; i < size ; i++)
			{
				char s = plane[i][0] != '#' ? plane[i][0] : ' ';
				for(int j=0; j < size ; j++)
				{
					if(plane[i][j]==s) score++;
					else {score = 0; break;}
					if(score==size) return s;
				}
			}
			
			//all planes in y axis
			for(int j = 0 ; j < size ; j++)
			{
				char s = plane[0][j] != '#' ? plane[0][j] : ' ';
				for(int i = 0; i < size ; i++)
				{
					if(plane[i][j]==s) score++;
					else {score = 0; break;}
					if(score==size) return s;
				}
			}
		
		//if there's no winner
		return '#';
	}
}
