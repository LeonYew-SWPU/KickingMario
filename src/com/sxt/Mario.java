package com.sxt;

import java.awt.image.BufferedImage;

import javax.swing.TransferHandler;


public class Mario implements Runnable {
	// 用于表示横纵坐标
	private int x;
	private int y;
	
	// 用于表示当前的状态
	private String status;
	// 用于显示当前状态对应的图像
	private BufferedImage show = null;
	// 定义一个BackGround对象，用来获取障碍物的信息
	private BackGround backGround = new BackGround();
	// 用来实现马里奥的动作
	private Thread thread = null;
	
	// 马里奥的移动速度
	private double xSpeed;
	// 马里奥的跳跃速度
	private int ySpeed;
	// 马里奥水平加速度
	private double xAccSpeed;
	// 马里奥竖直加速度
	private int yAccSpeed;
	// 定义水平方向最大速度;
	private double xMaxSpeed = 10.0;

	// 定义水平启动加速度常量
	final private double ACC = 0.80;
	// 定义转向加速度常量
	final private double TURNACC = 0.9;
	// 停止加速度
	final private double FRICTION = -0.08;
	// 定义重力加速度常量
	final private int GRAVITY = 9;

	
	// 定义一个索引
	private int index;
	// 判断马里奥是否走到了城堡门口
	private boolean isOK;
	// 判断马里奥是否死亡
	private boolean isDeath = false;
	// 表示分数
	private int score = 0;

	
	public Mario() {
	}

	public Mario(int x, int y) {
		this.x = x;
		this.y = y;
		show = StaticValue.stand_R;
		this.status = "stand--right";
		thread = new Thread(this);
		thread.start();
	}

	// 马里奥死亡的方法
	public void death() {
		isDeath = true;
	}

	// 马里奥向左移动
	public void leftMove() {
		//判断是要转向还是启动
		status = "move--left";
	}

	// 马里奥向右移动
	public void rightMove() {
		//判断是要转向还是启动
		status = "move--right";
		

	}
	// 马里奥向左停止
	public void leftStop() {
		status = "stop--left";
	}
	// 马里奥向右停止
	public void rightStop() {
		status = "stop--right";
	}
	// 马里奥跳跃
	public void jump() {
		if(xSpeed >= 0)
			status = "jump--right";
		else if(xSpeed < 0)
			status = "jump--left";
		yAccSpeed = GRAVITY;//加速度向下
	}
	// 马里奥下落
	public void fall() {
		if(xSpeed >= 0)
			status = "jump--right";
		else if(xSpeed < 0)
			status = "jump--left";
		yAccSpeed = GRAVITY;
	}


	@Override
	public void run() {
		for (index = 0; index < 22; index++) {
			// 判断是否处于障碍物上
			boolean onObstacle = true;
			// 判断是否可以往右走
			boolean canRight = true;
			// 判断是否可以往左走
			boolean canLeft = true;
			// 判断马里奥是否到达旗杆位置
			boolean isFlag = false;
			
			
			/************ 马里奥移动板块 *************/
			//TODO finish this
			if(status.indexOf("move") != -1)//即含有move
			{
				if(status.indexOf("right") != -1)//向右移动
				{
					if(xSpeed < 0) {
						xAccSpeed = TURNACC; 
					}else if(xSpeed >= 0) {
						xAccSpeed = ACC;
					}
					
				}else if (status.indexOf("left") != -1) {
					
					if(xSpeed > 0) {
						xAccSpeed = -TURNACC; 
					}else if(xSpeed <= 0) {
						xAccSpeed = -ACC;
					}
				}
			}else if(status.indexOf("stop") != -1) {
				if(status.indexOf("right") != -1)//向右减速
				{
					xAccSpeed = FRICTION;
					if(xSpeed > 0)
						xSpeed += xAccSpeed;
					else if(xSpeed <= 0)
					{
						xAccSpeed = 0;
						xSpeed = 0;
					}
					
				}else if (status.indexOf("left") != -1) {
					xAccSpeed = -FRICTION;
					if(xSpeed < 0)
						xSpeed += xAccSpeed;
					else if(xSpeed >= 0)
					{
						xAccSpeed = 0;
						xSpeed = 0;
					}
				}
			}
			//判断是否达到最大速度
			if(Math.abs(xSpeed) < xMaxSpeed) {
				xSpeed += xAccSpeed;
			}else if(status.indexOf("move") != -1 && status.indexOf("right") != -1) {
				xAccSpeed = 0;
				xSpeed = xMaxSpeed;
			}else if(status.indexOf("move") != -1 && status.indexOf("left") != -1) {
				xAccSpeed = 0;
				xSpeed = -xMaxSpeed;
			}
			
//			xAccSpeed += xSpeed * FRICTION;
			xSpeed += xAccSpeed;
			x += xSpeed + 0.5 * xAccSpeed;
			System.out.println(status);
			/****************** 马里奥移动板块ENDING ****************/

			//线程休眠
			try {
				Thread.sleep(45);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			//刷新index，写死循环
			if(index == 21)
			{
				index = 0;
			}
		}
	}

	
	
// Setter and Getters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getShow() {
		return show;
	}

	public void setShow(BufferedImage show) {
		this.show = show;
	}

	public BackGround getBackGround() {
		return backGround;
	}

	public void setBackGround(BackGround backGround) {
		this.backGround = backGround;
	}

	public boolean isOK() {
		return isOK;
	}

	public boolean isDeath() {
		return isDeath;
	}

	public int getScore() {
		return score;
	}

	public double getxMaxSpeed() {
		return xMaxSpeed;
	}
	public void setxMaxSpeed(double xMaxSpeed) {
		this.xMaxSpeed = xMaxSpeed;
	}

	public String getStatus() {
		return status;
	}

	public Thread getThread() {
		return thread;
	}

	public double getxSpeed() {
		return xSpeed;
	}

	public int getySpeed() {
		return ySpeed;
	}

	public double getxAccSpeed() {
		return xAccSpeed;
	}

	public int getyAccSpeed() {
		return yAccSpeed;
	}

	public double getACC() {
		return ACC;
	}

	public double getTURNACC() {
		return TURNACC;
	}

	public double getFRICTION() {
		return FRICTION;
	}

	public int getGRAVITY() {
		return GRAVITY;
	}

	public int getIndex() {
		return index;
	}

}
