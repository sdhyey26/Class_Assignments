package com.tss.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.tss.model.playlistModel;

public class playlist1est {

	private static final String FILE_NAME = "songs.ser";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<playlistModel> songs = new LinkedHashSet<>();
		songs = deserializeSongs();
		
		System.out.println("Playlist management system is initialized successfully!!");
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Add a song/songs");
		System.out.println("2. Remove songs");
		System.out.println("3. Search a song by title");
		System.out.println("4. Display all the songs");
		System.out.println("5. Choose for Shuffling the songs");
		System.out.println("6. Exit");

		boolean isTrue = true;
		while (isTrue) {
			System.out.print("\nEnter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {

				case 1: {
					songs = deserializeSongs();
					enterSongs(songs, sc);
				} break;

				case 2: {
					System.out.print("\nEnter the title of the song you want to remove: ");
					String title = sc.nextLine();
					removeSongs(title, songs, sc);
				} break;

				case 3: {
					System.out.print("\nEnter the title of the song you want to search: ");
					String title = sc.nextLine();
					searchByTitle(title, songs, sc);
				} break;

				case 4: {
					
					displaySongs(songs);
				} break;

				case 5: {
					shuffleSongs(songs);
				} break;

				case 6: {
					isTrue = false;
					serializeSongs(songs);
					System.out.println("Exiting Playlist Manager. Goodbye!");
				} break;

				default:
					System.out.println("Enter a valid choice!");
			}
		}
	}

	public static void enterSongs(Set<playlistModel> songs, Scanner sc) {
		System.out.print("Enter the number of songs you want to add: ");
		int count = sc.nextInt();
		sc.nextLine(); 

		for (int i = 0; i < count; i++) {
			System.out.print("\nEnter song title: ");
			String title = sc.nextLine();

			System.out.print("Enter the artist name: ");
			String artist = sc.nextLine();

			System.out.print("Enter the duration of the song: ");
			int duration = sc.nextInt();
			sc.nextLine(); 

			songs.add(new playlistModel(title, artist, duration));
		}

		System.out.println("\nSongs added successfully!");
		for (playlistModel song : songs) {
			System.out.println(song.toString());
		}
		
		serializeSongs(songs);
		
	}

	public static void removeSongs(String title, Set<playlistModel> songs, Scanner sc) {
		if (songs.isEmpty()) {
			System.out.println("The current playlist is empty. Nothing to delete!");
		} else {
			for (playlistModel song : songs) {
				System.out.println(song);
			}

			boolean isFound = false;
			playlistModel toRemove = null;

			for (playlistModel song : songs) {
				if (title.equals(song.getTitle())) {
					toRemove = song;
					System.out.println("Song deleted successfully.");
					isFound = true;
				}
			}

			if (!isFound) {
				System.out.println("Enter a valid song title to delete.");
			} else {
				songs.remove(toRemove);
				serializeSongs(songs);
			}
		}
	}

	public static void searchByTitle(String title, Set<playlistModel> songs, Scanner sc) {
		if (songs.isEmpty()) {
			System.out.println("The current playlist is empty. Nothing to search!");
		} else {
			boolean isFound = false;
			for (playlistModel song : songs) {
				if (title.equals(song.getTitle())) {
					System.out.println(song.toString());
					System.out.println("Press Enter to play the song!");
					isFound = true;
				}
			}
			if (!isFound) {
				System.out.println("The title you provided is not present!");
			}
		}
	}

	public static void displaySongs(Set<playlistModel> songs) {
		if (songs.isEmpty()) {
			System.out.println("The current playlist is empty. Nothing to display!");
		}
		for (playlistModel song : songs) {
			System.out.println(song.toString());
		}
	}

	public static void shuffleSongs(Set<playlistModel> songs) {
		List<playlistModel> shuffledList = new ArrayList<>();
		for (playlistModel song : songs) {
			shuffledList.add(song);
		}

		songs.removeAll(songs);
		Collections.shuffle(shuffledList);

		for (playlistModel song : shuffledList) {
			songs.add(song);
		}

		System.out.println("Your playlist is shuffled successfully!!");
		for (playlistModel song : songs) {
			System.out.println(song.toString());
		}
		
		serializeSongs(songs);
	}
	
	private static void serializeSongs(Set<playlistModel> songs) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("songs.txt"))) {
			oos.writeObject(songs);
		} catch (IOException e) {
			System.out.println("Error saving movies: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private static Set<playlistModel> deserializeSongs() {
		File file = new File("songs.txt");
		if (!file.exists()) {
			return new LinkedHashSet<>();
		}

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("songs.txt"))) {
			return (Set<playlistModel>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading movies: " + e.getMessage());
			return new LinkedHashSet<>();
		}
	}
}
