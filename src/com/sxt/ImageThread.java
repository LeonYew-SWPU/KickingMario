package com.sxt;

public class ImageThread extends Thread{
	private Mario mario;
	public ImageThread(Mario mario) {
		this.mario = mario;
	}
	
	@Override
	public void run() { 
		while(true) {
			// 判断当前是否是移动状态
			if (status.contains("move")) {
				// 判断是否向左移动
				if ("move--left".equals(status)) {
					for (index = 0; index < 21; index++) {
						show = StaticValue.run_L.get(index);// 展示马里奥的图片（索引）
//						System.out.println("L:" + index);// 用于检查索引是否出错
						if (index == 21) {
							index = 0;
						}
						try {
							Thread.sleep(45);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

				}
				// 判断是否向右移动
				if ("move--right".equals(status)) {
					for (index = 0; index < 21; index++) {
						show = StaticValue.run_R.get(index);// 展示马里奥的图片（索引）
						System.out.println("R:" + index);// 用于检查索引是否出错
						if (index == 21) {
							index = 0;
						}
						
						try {
							Thread.sleep(45);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
		}

		
	}

}
