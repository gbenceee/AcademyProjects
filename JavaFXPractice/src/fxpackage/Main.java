package fxpackage;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() throws Exception {
		// start előtt fut le
		// hasznos ha be akarunk tölteni valamit start metódus előtt pl. képet
		System.out.println("Before");
	}

	@Override
	public void start(Stage firstWindow) throws Exception {
		firstWindow.setTitle("First window"); // ablak címének beállítása
//		firstWindow.show(); // ablak megjelenítése (alapértelmezetten el van rejtve)

		Stage secondWindow = new Stage(); // ablak létrehozás
		secondWindow.setTitle("Second window");
		secondWindow.setWidth(1000); // ablak szélesség beállítása pixelben
		secondWindow.setHeight(600); // ablak magasság beállítása pixelben
		secondWindow.setX(460); // ablak pozíció beállítása x tengelyen pixelben(jobb-bal)
		secondWindow.setY(240); // ablak pozíció beállítása y tengelyen pixelben(fel-le)
		// az ablak bal felső sarka fog megjelenni a beállított tengelyen
		// középre állítás -> (az adott tengelyen max pixel / 2) - (ablak mérete
		// pixelben az adott tengelyen /2)
		// középre állítás példával az y tengelyen-> (1080/2) - (600/2)
//		secondWindow.show();

		// Modality
		// amíg az adott ablak meg van nyitva, más ablakokhoz nem fér hozzá a user (nem
		// tudja bezárni, letenni tálcára, kinagyítani stb.) amíg be nem zárja azt
		Stage thirdWindow = new Stage();
		thirdWindow.setTitle("Third window");
		thirdWindow.initModality(Modality.APPLICATION_MODAL);
		// alapértelmezetten none egy ablak modality vagyis bármely ablakhoz hozzáfér a
		// user attól függetlenül hogy hány van megnyitva és hogy honnan
		thirdWindow.initModality(Modality.NONE);
		// ha egy ablakból megnyitunk egy másikat, akkor csak a megnyitott ablakhoz van
		// hozzáférése a usernek amíg be nem zárja azt
		thirdWindow.initModality(Modality.WINDOW_MODAL);
		// a third window most már a second window-hoz tartozik, tehát a window_modal
		// nem engedi hogy a second window-hoz hozzáférjen a user amíg a third window
		// nyitva van
		thirdWindow.initOwner(secondWindow);
//		thirdWindow.show();

		// ablak formázása
		Stage fourthWindow = new Stage();
		fourthWindow.initStyle(StageStyle.DECORATED); // alapértelmezetten minden stage decorated, van benne 3 gomb(tálcára letesz,
														// kicsinyít/nagyít, bezár) és a cím mező
//		fourthWindow.initStyle(StageStyle.TRANSPARENT); // láthatatlanít
//		fourthWindow.initStyle(StageStyle.UTILITY); // csak egy bezáró gombja van, nincs kicsinyítés vagy nagyítás, beállítások menüponthoz hasznos
//		fourthWindow.initStyle(StageStyle.UNDECORATED); // nincs benne cím és gombok.
//		fourthWindow.initStyle(StageStyle.UNIFIED); // nincs benne border, gyakorlatban érdemes kipróbálni.
//		fourthWindow.setFullScreen(true); //ha nincs benne tartalom, nem látható
		fourthWindow.show();

	}

	public void stop() throws Exception {
		// start metódus után fut le
		System.out.println("After");
	}

}
