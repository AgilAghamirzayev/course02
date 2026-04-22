package l13.collections.usecases;

import java.util.LinkedList;

public class LinkedListUseCaseExample {
    public static void main(String[] args) {
        // Real use case: music playlist with many add/remove operations.
        LinkedList<String> playlist = new LinkedList<>();
        playlist.add("Song A");
        playlist.add("Song B");
        playlist.addFirst("Intro Song");
        playlist.removeLast();

        System.out.println("Where to use LinkedList: frequent insert/remove at ends.");
        System.out.println("Playlist: " + playlist);
    }
}
