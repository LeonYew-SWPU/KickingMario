package com.sxt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javazoom.jl.decoder.JavaLayerException;

public class MyFrame extends JFrame implements KeyListener, Runnable{
	//用于存储所有的背景
	private List<BackGround> allBg = new ArrayList<>();
	//用于存储当前的背景
	private BackGround nowBg = new BackGround();
	//用于双缓存
	private Image offScreenImage = null;
	//马里奥对象
	private Mario mario = new Mario();
	//实现马里奥的运动,线程对象
	private Thread thread = new Thread(this);
	
	
	public MyFrame() {
		//设置窗口的大小为800 * 600
		this.setSize(800, 600);
		//设置窗口居中显示
		this.setLocationRelativeTo(null);
		//设置窗口的可见性
		this.setVisible(true);
		//设置点击窗口上的关闭键，结束程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小不可变
		this.setResizable(false);
		//向窗口对象添加键盘监听器
		this.addKeyListener(this);
		//设置窗口名称
		this.setTitle("扫黑玛丽");
		StaticValue.init();
		// 初始化马里奥0
		mario = new Mario(10, 385);

		//创建全部的场景
		for (int i = 1; i <= 3; i++) {
			allBg.add(new BackGround(i, i == 3 ? true : false));
		}
		//将第一个场景设置为当前场景
		nowBg = allBg.get(0);
		mario.setBackGround(nowBg);
		//绘制图像
		repaint();
		thread.start();
		try {
			new Music();
		} catch (FileNotFoundException | JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame();
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 37 <- 38 ↑ 39 -> 40 ↓
		//向右移动
		if(e.getKeyCode() == 39){
			mario.rightMove();
		}
		//向左移动
		if(e.getKeyCode() == 37) {
			mario.leftMove();
		}
		//跳跃
		if(e.getKeyCode() == 38) {
			mario.jump();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
//		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == 37) {
			mario.leftStop();
		}
		if (e.getKeyCode() == 39) {
			mario.rightStop();
		}
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = createImage(800,600);
		}
		
		
		Graphics graphics = offScreenImage.getGraphics();
		graphics.fillRect(0, 0, 800, 600);
		
		//绘制背景
		graphics.drawImage(nowBg.getBgImage(),0,0,this);
		
		//绘制敌人
		for(Enemy e : nowBg.getEnemyList()) {
			graphics.drawImage(e.getShow(), e.getX(), e.getY(), this);
		}
		
		//绘制障碍物
		for(Obstacle ob : nowBg.getObstacleList()) {
			graphics.drawImage(ob.getShow(),ob.getX(),ob.getY(),this);
		}

		//绘制城堡
		graphics.drawImage(nowBg.getTower(), 620, 270, this);
		
		//绘制旗杆
		graphics.drawImage(nowBg.getGan(), 500, 220, this);
		
		//绘制马里奥
		graphics.drawImage(mario.getShow(), mario.getX(), mario.getY(), this);
		
		// 绘制分数
		Color c = graphics.getColor();
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("黑体", Font.BOLD, 25));
		graphics.drawString("Score" + mario.getScore(), 300, 100);
		graphics.setColor(c);// 还原graphics画笔颜色
		//将图像绘制到窗口中
		g.drawImage(offScreenImage,0,0,this);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(50);
				
				if (mario.getX() >= 775) {
					//判断走到地图右边且背景不是最后一关
					nowBg = allBg.get(nowBg.getSort());
					mario.setBackGround(nowBg);
					mario.setX(10);
					mario.setY(385);
				}
				
				//判断马里奥是否死亡
				if (mario.isDeath()) {
					JOptionPane.showMessageDialog(this, "GAME OVER!!");
					System.exit(0);
				}
				
				//判断游戏是否结束
				if(mario.isOK()){
					JOptionPane.showMessageDialog(this, "恭喜你，成功通关了！");
					System.exit(0);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

