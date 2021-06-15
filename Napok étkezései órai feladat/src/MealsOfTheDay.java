public class MealsOfTheDay {

	public static void main(String[] args) {
		String[] days = { "Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap" };
		String[] meals = { "reggeli", "tízórai", "ebéd", "uzsonna", "vacsora" };
		for (int dayOfWeek = 0; dayOfWeek < days.length; dayOfWeek++) {
			System.out.println(days[dayOfWeek]);
			for (int mealOfDay = 0; mealOfDay < meals.length; mealOfDay++) {
				System.out.println("  " + meals[mealOfDay]);
			}
		}
	}

}