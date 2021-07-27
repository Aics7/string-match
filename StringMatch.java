/**
@author Issifu Alhassan
@version 1.0.0
*/
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class StringMatch
{
	public static void main(String [] args)
	{
		Scanner sc;
		String text,pattern;
		/*If no only one input is passed*/
		if(args.length == 1)
		{
			/*If input is interactive mode*/
			if(args[0].equalsIgnoreCase("interactive"))
			{
				sc = new Scanner(System.in);
				System.out.println("Enter text: ");
				text = sc.nextLine();
				System.out.println("Enter pattern to search for: ");
				pattern = sc.nextLine();
				System.out.println("Index of first Occurence: " + findMatch(text,pattern));
				sc.close();
			}
			/*if input is file mode*/
			else if (args[0].equalsIgnoreCase("file"))
			{
				try
				{
					BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
					sc = new Scanner(new File("input.txt"));
					int num = Integer.parseInt(sc.nextLine());
					for(int i = 0; i < num; i++)
					{
					    text = sc.nextLine();
					    pattern = sc.nextLine();
					    bw.write(findMatch(text,pattern)+"");
					    bw.newLine();
					}
					bw.close();
					sc.close();
					System.out.println("Done!");
				}
				catch (FileNotFoundException e)
				{
					System.out.println("Could not find input file \"input.txt\"");
				}
				catch(Exception e)
				{
					System.out.println("An error occured");
				}				
			}
			/*If input is not file or interactive*/
			else
			{
				System.out.println("Invalid input (" + args[0]+"). Acceptable inputs are \"interactive\" and \"file\"");
			}	
		}
		/*if no or more than 1 input is passed*/
		else
		{
			System.out.println("No or more than one argument passed!");
		}
	}
	/**
	*findMatch method finds and returns the index of the first occurence of a pattern in a text
	*@param text : the text to search
	*@param pattern : the pattern to search for in text
	*/
	public static int findMatch(String text, String pattern)
	{
		int n = text.length();
		int m = pattern.length();
		int j;
		for(int i = 0; i< n - m + 1; i++)
		{
			j=0;
			while(j<m && pattern.charAt(j) == text.charAt(i+j))
			{
				j++;
			}
			if(j==m)
			{
				return i;
			}
		}
		return -1;
	}
}