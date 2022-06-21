package com.sxt;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Music {
	String name;
	public Music() throws JavaLayerException, FileNotFoundException {
		Player player;
		String str = System.getProperty("user.dir") + "/src/Music/music.wav";
		BufferedInputStream name = new BufferedInputStream(new FileInputStream(str));
		player = new Player(name);
		player.play();
	}
}
