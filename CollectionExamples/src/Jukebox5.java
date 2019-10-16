import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Jukebox5 {
	ArrayList<Song> songList = new ArrayList<Song>();

	public static void main(String[] args) {
		new Jukebox3().go();

	}
	List<Song> list = new ArrayList<Song>();
	class ArtistCompare implements Comparator<Song> {

		@Override
		public int compare(Song arg0, Song arg1) {
			return arg0.getArtist().compareTo(arg1.getArtist());
		}

	}

	public void go() {
		getSongs();
		System.out.println(songList);
		ArtistCompare artistCompare = new ArtistCompare();
		Collections.sort(songList,artistCompare);
		System.out.println(songList);
	}

	private void getSongs() {
		try {
			File file = new File("SongList.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addSong(String line) {
		String[] tokens = line.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}
}
