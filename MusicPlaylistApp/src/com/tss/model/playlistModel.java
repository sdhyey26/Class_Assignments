package com.tss.model;

import java.io.Serializable;

public class playlistModel implements Serializable{

    private static final long serialVersionUID = 1L;
	private String artist;
	private int duration;
	private String title;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public playlistModel(String title, String artist, int duration) {
		super();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "playlistModel [artist=" + artist + ", duration=" + duration + ", title=" + title + "]";
	}
}
