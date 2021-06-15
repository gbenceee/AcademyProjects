public class TömbNaptár {

	public static void main(String[] args) {
		
		String[][] calendar = new String [8][14];
		//idő
		calendar[0][0] = "idő";
		calendar[0][1] = "6:00 - 7:00";
		calendar[0][2] = "7:00 - 8:00";
		calendar[0][3] = "8:00 - 9:00";
		calendar[0][4] = "9:00 - 10:00";
		calendar[0][5] = "10:00 - 11:00";
		calendar[0][6] = "11:00 - 12:00";
		calendar[0][7] = "12:00 - 13:00";
		calendar[0][8] = "13:00 - 14:00";
		calendar[0][9] = "14:00 - 15:00";
		calendar[0][10] = "15:00 - 16:00";
		calendar[0][11] = "16:00 - 17:00";
		calendar[0][12] = "17:00 - 18:00";
		calendar[0][13] = "18:00 - 19:00";
		//Hétfő
		calendar[1][0] = "Hétfő";
		calendar[1][1] = "Bundást sétáltatni";
		calendar[1][2] = " ";
		calendar[1][3] = " ";
		calendar[1][4] = "autót szervizbe vinni";
		calendar[1][5] = " ";
		calendar[1][6] = " ";
		calendar[1][7] = " ";
		calendar[1][8] = " ";
		calendar[1][9] = " ";
		calendar[1][10] = " ";
		calendar[1][11] = " ";
		calendar[1][12] = " ";
		calendar[1][13] = "Bundást sétáltatni";
		//Kedd
		calendar[2][0] = "Kedd";
		calendar[2][1] = "Bundást sétáltatni";
		calendar[2][2] = " ";
		calendar[2][3] = " ";
		calendar[2][4] = " ";
		calendar[2][5] = "ebédet főzni";
		calendar[2][6] = " ";
		calendar[2][7] = " ";
		calendar[2][8] = " ";
		calendar[2][9] = " ";
		calendar[2][10] = " ";
		calendar[2][11] = " ";
		calendar[2][12] = " ";
		calendar[2][13] = "Bundást sétáltatni";
		//Szerda
		calendar[3][0] = "Szerda";
		calendar[3][1] = "Bundást sétáltatni";
		calendar[3][2] = " ";
		calendar[3][3] = " ";
		calendar[3][4] = " ";
		calendar[3][5] = " ";
		calendar[3][6] = " ";
		calendar[3][7] = "Bundásnak kaját adni";
		calendar[3][8] = "rendelni processzort";
		calendar[3][9] = " ";
		calendar[3][10] = " ";
		calendar[3][11] = " ";
		calendar[3][12] = " ";
		calendar[3][13] = "Bundást sétáltatni";
		//Csütörtök
		calendar[4][0] = "Csütörtök";
		calendar[4][1] = "Bundást sétáltatni";
		calendar[4][2] = " ";
		calendar[4][3] = " ";
		calendar[4][4] = " ";
		calendar[4][5] = " ";
		calendar[4][6] = " ";
		calendar[4][7] = " ";
		calendar[4][8] = " ";
		calendar[4][9] = " ";
		calendar[4][10] = " ";
		calendar[4][11] = " ";
		calendar[4][12] = " ";
		calendar[4][13] = "Bundást sétáltatni";
		//Péntek
		calendar[5][0] = "Péntek";
		calendar[5][1] = "Bundást sétáltatni";
		calendar[5][2] = " ";
		calendar[5][3] = " ";
		calendar[5][4] = " ";
		calendar[5][5] = " ";
		calendar[5][6] = " ";
		calendar[5][7] = " ";
		calendar[5][8] = " ";
		calendar[5][9] = " ";
		calendar[5][10] = " ";
		calendar[5][11] = " ";
		calendar[5][12] = "vacsorát készíteni";
		calendar[5][13] = "Bundást sétáltatni";
		//Szombat
		calendar[6][0] = "Szombat";
		calendar[6][1] = "Bundást sétáltatni";
		calendar[6][2] = " ";
		calendar[6][3] = "kirándulás";
		calendar[6][4] = "kirándulás";
		calendar[6][5] = "kirándulás";
		calendar[6][6] = "kirándulás";
		calendar[6][7] = "kirándulás";
		calendar[6][8] = "kirándulás";
		calendar[6][9] = "kirándulás";
		calendar[6][10] = "kirándulás";
		calendar[6][11] = "kirándulás";
		calendar[6][12] = " ";
		calendar[6][13] = "Bundást sétáltatni";
		//Vasárnap
		calendar[7][0] = "Vasárnap";
		calendar[7][1] = "Bundást sétáltatni";
		calendar[7][2] = " ";
		calendar[7][3] = " ";
		calendar[7][4] = " ";
		calendar[7][5] = " ";
		calendar[7][6] = " ";
		calendar[7][7] = " ";
		calendar[7][8] = " ";
		calendar[7][9] = "mozi";
		calendar[7][10] = "mozi";
		calendar[7][11] = "mozi";
		calendar[7][12] = " ";
		calendar[7][13] = "Bundást sétáltatni";
		
		//Esemény csere:
		for(int i = 0; i<= 7; i++)
		{
			for(int j = 0; j <= 13; j++)
			{
				if(calendar[i][j] == "rendelni processzort")
				{
					calendar[i][j] = "vacsorát készíteni";
					System.out.println("Szerdán 13:00 és 14:00 közötti teendő: " + calendar[i][j]);
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
