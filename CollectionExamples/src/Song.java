
public class Song implements Comparable<Song>{
String title;
String artist;
String rating;
String bpm;
Song(String t,String a,String r,String b){
	this.title = t;
	this.artist = a;
	this.rating = r;
	this.bpm = b;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getBpm() {
	return bpm;
}
public void setBpm(String bpm) {
	this.bpm = bpm;
}
@Override
public String toString() {
	return "Song [title=" + title + ", artist=" + artist + ", rating=" + rating + ", bpm=" + bpm + "]";
}
@Override
public int compareTo(Song s) {
	return title.compareTo(s.getTitle());
}

}
