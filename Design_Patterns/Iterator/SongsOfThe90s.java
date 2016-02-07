package Iterator;

import java.util.Hashtable;
import java.util.Iterator;

public class SongsOfThe90s implements SongIterator {

	// using HashTable
	
	Hashtable<Integer, SongInfo> bestSongs;
	
	int hashKey = 0;
	
	public SongsOfThe90s() {
		
		bestSongs = new Hashtable<Integer, SongInfo>();
		
		addSong("Losing My Religion", "REM", 1991);
		addSong("Creep", "Radiohead", 1993);
		addSong("Walk on the ocean", "toad the wet sprocket", 1991);
		
	}
	
	public void addSong (String songName, String bandName, int yearReleased) {
		
		SongInfo songInfo = new SongInfo(songName, bandName, yearReleased);
		
		bestSongs.put(hashKey++, songInfo);
		
	}

	@Override
	public Iterator createIterator() {

		return bestSongs.values().iterator();
		
	}
}
