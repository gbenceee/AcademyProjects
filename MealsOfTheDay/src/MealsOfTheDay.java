import java.util.Random;
import java.util.Scanner;

public class MealsOfTheDay {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] days = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
		String[] meals = {"reggeli", "tízórai", "ebéd", "uzsonna", "vacsora"};
		dayLoop: for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(dayOfWeek > 2 && mealOfDay > 2)
				{
					continue dayLoop;
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		}
		System.out.println("-------------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
