package com.sxt;

import java.util.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StaticValue {
	//背景
	public static BufferedImage bg = null;
	public static BufferedImage bg2 = null;
	//马里奥向左跳跃
	public static BufferedImage jump_L = null;
	//马里奥向右跳跃
	public static BufferedImage jump_R = null;
	//马里奥向左站立
	public static BufferedImage stand_L = null;
	//马里奥向右站立
	public static BufferedImage stand_R = null;
	//城堡
	public static BufferedImage tower = null;
	//旗杆
	public static BufferedImage gan = null;// Why not use "flag" ???
	//障碍物
	public static List<BufferedImage> obstacle = new ArrayList<>();
	//马里奥向左跑
	public static List<BufferedImage> run_L = new ArrayList<>();
	//马里奥向右跑
	public static List<BufferedImage> run_R = new ArrayList<>();
	//蘑菇敌人
	public static List<BufferedImage> mogu = new ArrayList<>();
	//食人花敌人
	public static List<BufferedImage> flower = new ArrayList<>();
	//路径的前缀，方便后续调用
	public static String path = System.getProperty("user.dir") + "/src/images/";
	//run_L
	public static String pathL = System.getProperty("user.dir") + "/src/run_L/";
	//run_L
	public static String pathR = System.getProperty("user.dir") + "/src/run_R/";
	
	
	//初始化方法
	public static void init() {
		try {
			//加载背景图片
			bg = ImageIO.read(new File(path + "bg.png"));
			bg2 = ImageIO.read(new File(path + "bg2.png"));
			//加载马里奥向左站立
			stand_L = ImageIO.read(new File(path + "s_mario_stand_L.png"));
			//加载马里奥向右站立
			stand_R = ImageIO.read(new File(path + "s_mario_stand_R.png"));
			//加载城堡
			tower = ImageIO.read(new File(path + "tower.png"));
			//加载旗杆
			gan = ImageIO.read(new File(path + "gan.png"));
			//加载马里奥向左跳跃
			jump_L = ImageIO.read(new File(path + "s_mario_jump1_L.png"));
			//加载马里奥向右跳跃
			jump_R = ImageIO.read(new File(path + "s_mario_jump1_R.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//加载马里奥向左跑
		for(int i = 0; i <=21 ; i ++) {
			try {
				run_L.add(ImageIO.read(new File(pathL +  i + ".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//加载马里奥向右跑
		for(int i = 1; i <= 21; i ++) {
			try {
				run_R.add(ImageIO.read(new File(pathR +  i + ".png")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

		try {
			//加载障碍物
			obstacle.add(ImageIO.read(new File(path + "brick.png")));//0
			obstacle.add(ImageIO.read(new File(path + "soil_up.png")));// 1
			obstacle.add(ImageIO.read(new File(path + "soil_base.png")));// 2
		} catch (IOException e) {
			e.printStackTrace();
		}
		//加载水管
		for(int i = 1; i <= 4; i++)
		{
			try {
				obstacle.add(ImageIO.read(new File(path + "pipe" + i + ".png")));//3 4 5 6
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		//加载不可破坏的砖块和旗子
		try {
			obstacle.add(ImageIO.read(new File(path + "brick2.png")));//7
			obstacle.add(ImageIO.read(new File(path + "flag.png")));//8
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//加载蘑菇敌人
		for(int i = 1; i <= 3; i++)
		{
			try {
				mogu.add(ImageIO.read(new File(path + "fungus" + i + ".png")));// 9 10 11
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//记载食人花敌人
		for(int i = 1; i <= 2; i++)
		{
			try {
				flower.add(ImageIO.read(new File(path + "flower1." + i + ".png")));// 12 13
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
