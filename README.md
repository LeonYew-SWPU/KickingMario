# 扫黑玛丽 简单说明书

**2021级数字媒体技术第34小组**  
**Java小游戏**  
**游戏名:** 扫黑玛丽 (KickingMario)

# 游戏截图

<img alt="picture 17" src="https://cdn.jsdelivr.net/gh/LeonYew-SWPU/FileTem@main/imgs/14b5494ac2e01992921148ab4e55c80d9d409396f17e3873767f6e6c35f03e02.gif" width="300" />  <img alt="picture 18" src="https://cdn.jsdelivr.net/gh/LeonYew-SWPU/FileTem@main/imgs/8200c203a715f02d258af0207db022e690aabd2f0efe19b1122b597f29190b49.gif" width="300" />  <img alt="picture 19" src="https://cdn.jsdelivr.net/gh/LeonYew-SWPU/FileTem@main/imgs/389d7658c0e2f936e95722fe848f336add524cd794c82b07ce76aa30ba733e9c.gif" width="300" />  <img alt="picture 20" src="https://cdn.jsdelivr.net/gh/LeonYew-SWPU/FileTem@main/imgs/0c02e4b73bceb23b383cb522d306f65cba2b3545ba95352ba00d73b542725921.jpg" width="300" />  

## 一、程序运行环境

### 1. 开发硬件配置:
- 处理器: AMD Ryzen 7 5800H with Radeon Graphics (八核)
- 内存: 16GB DDR4 3200MHz (8GB + 8GB)
- 显卡: NVIDIA GeForce RTX 3060 Laptop GPU (6GB / 联想)

### 2. 开发软件配置：
- 操作系统: Windows 11
- 开发工具: Eclipse 2022-06 (4.24.0)

### 3. 编译运行标准：
- JavaSE-1.8 (JRE)

## 二、程序说明

### 1. 程序文件说明：
- .git (Git软件产生)
- .setting (Git软件设置参数)
- bin (项目编译文件)
- src (项目文件)
- .project (无用，Git自行生成的)
- readme.txt (目前文件，用以简单说明)
- README.md (本文件，用于解释项目)
- 代码.png (代码脑图)
- 代码.xmind (代码脑图源文件)

### 2. 操作说明：
- 使用左右方向键控制马里奥进行移动
- 使用上方向键控制马里奥进行跳跃
- 使用回车键发射子弹 (暂未实现)

### 3. 角色死亡说明：
- 如果角色触碰到黑恶势力敌人立即死亡，游戏结束

### 4. 游戏积分说明：
- 破坏一个可破坏砖块可获得1分
- 踩死一个黑恶势力份子可获得3分

### 5. 游戏关卡说明：
1. 第一关：设有一个可水平移动黑恶势力敌人和一个可垂直移动敌人，需要找准时机避开敌人即可进入下一关。
2. 第二关：设有两个可水平移动黑恶势力敌人和两个可垂直移动敌人，除避开敌人外，还需要跳跃到最上面的方块才能通关。
3. 第三关：设有一个水平移动敌人，触碰到旗杆即可通过，结束游戏。

## 软件架构
本小游戏采用Java语言编写，使用Eclipse进行开发，利用Git进行同时多人共同开发，实现版本修改与迭代。

## 团队贡献
- 美工 & PPT：肖双武
- 开发文档：黄柏维
- 代码：黄柏维 & 黎恩瑜
- Git建立：黎恩瑜
