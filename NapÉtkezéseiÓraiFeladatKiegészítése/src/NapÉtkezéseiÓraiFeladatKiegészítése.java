import java.util.Scanner;

public class NapÉtkezéseiÓraiFeladatKiegészítése {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String[] days = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};
		String[] meals = {"reggeli", "tízórai", "ebéd", "uzsonna", "vacsora"};
		System.out.println("1. feladat: ");
		dayLoop: for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(dayOfWeek > 4)
				{
					continue dayLoop;
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		}
		System.out.println("-------------------------------------------");
		System.out.println("2. feladat: ");
		for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(dayOfWeek < 5 && mealOfDay == 0)
				{
					continue;
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		
		}
		System.out.println("-------------------------------------------");
		System.out.println("3. feladat: ");
		for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(mealOfDay == 2)
				{
					continue;
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		
		}
		System.out.println("-------------------------------------------");
		System.out.println("4. feladat: ");
		for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(dayOfWeek < 3)
				{
					if(mealOfDay == 1 || mealOfDay == 3)
					{
						continue;
					}
				}
				if(dayOfWeek > 4)
				{
					if(mealOfDay == 4)
					{
					continue;
					}
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		
		}
		System.out.println("-------------------------------------------");
		System.out.println("5. feladat: ");
		for(int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++)
		{
			System.out.println(days[dayOfWeek]);
			for(int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++)
			{
				if(dayOfWeek == 0 && mealOfDay > 0)
				{
					continue;
				}
				if(dayOfWeek == 1 && mealOfDay != 1)
				{
					continue;
				}
				if(dayOfWeek == 2 && mealOfDay != 2)
				{
					continue;
				}
				if(dayOfWeek == 3 && mealOfDay != 3)
				{
					continue;
				}
				if(dayOfWeek == 4 && mealOfDay != 4)
				{
					continue;
				}
				if(dayOfWeek == 5)
				{
					continue;
				}
				if(dayOfWeek == 6 && mealOfDay != 2)
				{
					continue;
				}
				System.out.println("  " + meals[mealOfDay]);
			}
		
		}
		
		
		
		
	}

}
