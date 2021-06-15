import java.io.IOException;
import java.time.LocalDateTime;

public class AlarmClock {

    public static void main(String[] args) throws IOException, InterruptedException {
        while (!LocalDateTime.now().isAfter(LocalDateTime.of(2020, 7, 5, 8, 35, 0))) {
            Thread.sleep(1_000L);
        }
        Runtime.getRuntime().exec("\"C:/Program Files/VideoLAN/VLC/vlc.exe\" music.mp3");
    }

}