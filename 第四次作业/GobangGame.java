/**
 * 游戏主类
 */
package com.qzs.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				
				isOver = true;
			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo(chessboard);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo(Chessboard chessboard) {
		
		int[] result = new int[2];
		int lastX = chessboard.getLastX();
		int lastY = chessboard.getLastY();
		String[][] board = chessboard.getBoard();
		
		//判断最后落子的横行是否有三个或四个，若有，则进行阻止
		int lenInRow = numberInRow(board, lastX, lastY, Chessman.BLACK.getChessman());
		if (lenInRow == 3 || lenInRow == 4) {
			//标记是否找到合适位置
			boolean isExist = false;
			//以最后一个棋子的位置为起点向右查找合适位置
			for (int i = lastY; i < Chessboard.BOARD_SIZE; i++) {
				if (board[lastX][i-1].equals(Chessman.BLACK.getChessman()) && board[lastX][i].equals("十")) {
					isExist = true;
					result[0] = lastX;
					result[1] = i;
					break;
				}
			}
			//如果右边存在合适位置
			if (isExist)
				return result;
			
			//以最后一个棋子的位置为起点向左查找合适位置
			for (int i = lastY; i >= 0; i--) {
				if (board[lastX][i+1].equals(Chessman.BLACK.getChessman()) && board[lastX][i].equals("十")) {
					isExist = true;
					result[0] = lastX;
					result[1] = i;
					break;
				}
			}
			//如果左边存在合适位置
			if (isExist)
				return result;
		}
		
		//判断最后落子的纵行是否有三个或四个，若有，则进行阻止
	    int lenInCol = numberInCol(board, lastX, lastY, Chessman.BLACK.getChessman());
	    if (lenInCol == 3 || lenInCol == 4) {
		    //标记是否找到合适位置
	        boolean isExist = false;
	        //以最后一个棋子的位置为起点向下查找合适位置
		    for (int i = lastX; i < Chessboard.BOARD_SIZE; i++) {
		        if (board[i-1][lastY].equals(Chessman.BLACK.getChessman()) && board[i][lastY].equals("十")) {
			       isExist = true;
				   result[0] = i;
				   result[1] = lastY;
			       break;
			    }
		    }
			//如果下边存在合适位置
			if (isExist)
				return result;
			
			//以最后一个棋子的位置为起点向上查找合适位置
			for (int i = lastX; i >= 0; i--) {
				if (board[i+1][lastY].equals(Chessman.BLACK.getChessman()) && board[i][lastY].equals("十")) {
					isExist = true;
					result[0] = i;
					result[1] = lastY;
					break;
				}
			}
			//如果左边存在合适位置
			if (isExist)
				return result;
		}
		
	  //判断最后落子的斜向下方向是否有三个或四个，若有，则进行阻止
	  int lenInRB = numberInRB(board, lastX, lastY, Chessman.BLACK.getChessman());
	  if (lenInRB == 3 || lenInRB == 4) {
	  	//标记是否找到合适位置
	  	boolean isExist = false;
	  	//以最后一个棋子的位置为起点向左向上方向查找合适位置
	  	for (int i = lastX, j = lastY; i >= 0 && j >= 0; i--, j--) {
	  		if (board[i+1][j+1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("十")) {
	  			isExist = true;
	  			result[0] = i;
	  			result[1] = j;
	  			break;
	  		}
	  	}
	  	//如果右边存在合适位置
	  	if (isExist)
	  		return result;
	  			
		//以最后一个棋子的位置为起点向右向下查找合适位置
	  	for (int i = lastX, j = lastY; i < Chessboard.BOARD_SIZE && j < Chessboard.BOARD_SIZE; i++, j++) {
	  		if (board[i-1][j-1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("十")) {
	  			isExist = true;
	  			result[0] = i;
	  			result[1] = j;
	  			break;
	  		}
	  	}
	  	//如果左边存在合适位置
	  	if (isExist)
	  		return result;
	 }
	  
     //判断最后落子的斜向上方向是否有三个或四个，若有，则进行阻止
     int lenInRU = numberInRU(board, lastX, lastY, Chessman.BLACK.getChessman());
     if (lenInRU == 3 || lenInRU == 4) {
    	 //标记是否找到合适位置
	     boolean isExist = false;
	     //以最后一个棋子的位置为起点向右向上方向查找合适位置
	     for (int i = lastX, j = lastY; i >= 0 && j < Chessboard.BOARD_SIZE; i--, j++) {
	         if (board[i+1][j-1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("十")) {
	  		   isExist = true;
	  		   result[0] = i;
	  		   result[1] = j;
	  		   break;
	  		  }
	  	  }
	  	 //如果右边存在合适位置
	  	 if (isExist)
	        return result;
	  			
	     //以最后一个棋子的位置为起点向左向下方向查找合适位置
	  	 for (int i = lastX, j = lastY; i < Chessboard.BOARD_SIZE && j >= 0; i++, j--) {
	  		if (board[i-1][j+1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("十")) {
	  	        isExist = true;
	  			result[0] = i;
	  		    result[1] = j;
	  		    break;
	  		}
	  	}
	  	//如果左边存在合适位置
	  	if (isExist)
	  	    return result;
	  }
		
      //如果不需要阻碍黑棋
      //在该棋子右边找到一个合适位置
      boolean isFound = false;
      for (int i = lastY; i < Chessboard.BOARD_SIZE; i++) {
    	  if (board[lastX][i].equals("十")) {
    		  result[0] = lastX;
    		  result[1] = i;
    		  isFound = true;
    		  break;
    	  }
      }
      if (isFound)
          return result;
     
     //在该棋子左边找到一个合适位置
     for (int i = lastY; i >= 0; i--) {
    	  if (board[lastX][i].equals("十")) {
    		  result[0] = lastX;
    		  result[1] = i;
    		  isFound = true;
    		  break;
    	  }
      }
      if (isFound)
          return result;
    
      //在该棋子上边找到一个合适位置
      for (int i = lastX; i >= 0; i--) {
     	  if (board[i][lastY].equals("十")) {
     		  result[0] = i;
     		  result[1] = lastY;
     		  isFound = true;
     		  break;
     	  }
       }
       if (isFound)
           return result;
      
       //在该棋子下边找到一个合适位置
       for (int i = lastX; i < Chessboard.BOARD_SIZE; i--) {
      	  if (board[i][lastY].equals("十")) {
      		  result[0] = i;
      		  result[1] = lastY;
      		  isFound = true;
      		  break;
      	  }
        }
        if (isFound)
            return result;
      
      //若上下左右均没有合适位置，遍历整个棋盘，找到一个合适位置
      for (int i = 0; i < Chessboard.BOARD_SIZE; i++) 
    	  for (int j = 0; j < Chessboard.BOARD_SIZE; j++)
    		  if (board[i][j].equals("十")){
    			  result[0] = i;
    			  result[1] = j;
    			  break;
    		  }
	  return result;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		//查看横向方向
		boolean isRow = isFiveInRow(board, posX, posY, ico);
		if (isRow)
			return true;
        //查看纵向方向
		boolean isCol = isFiveInCol(board, posX, posY, ico);
		if (isCol)
			return true;
		//查看斜向下方向
		boolean isRB = isFiveInRB(board, posX, posY, ico);
		if (isRB)
			return true;
		//查看斜向上方向
		boolean isRU = isFiveInRU(board, posX, posY, ico);
		if (isRU)
			return true;
		else 
		    return false;
	}

	/**
	 * 
	 * 查看横向相同黑子的数量
	 */
	public int numberInRow(String[][] board, int posX, int posY, String ico) {
		//查看横向方向
		int maxLength = 0;
		int rightLen = 0;
		int leftLen = 0;
		int i = posX;
		int j = posY;
		//查看棋子右边最大长度
		while (board[i][j].equals(ico)) {
		    rightLen++;
		    if (j == 21)
			     break;
			else
			     j++;
		} 
		//查看棋子左边最大长度
		i = posX;
		j = posY;
	    while (board[i][j].equals(ico)) {
			leftLen++;
			if (j == 0)
				break;
			else
			    j--;
		}
		maxLength = leftLen + rightLen - 1;
		
		return maxLength;
	}
	
	/**
	 * 
	 * 查看横向是否有五个相同的棋子
	 */
	public boolean isFiveInRow(String[][] board, int posX, int posY, String ico) {
		
		int maxLength = numberInRow(board, posX, posY, ico);
		if (maxLength == 5)
		    return true;
		else
			return false;
	}
	
	/**
	 * 
	 * 查看纵向相同黑子的数量
	 */
	public int numberInCol(String[][] board, int posX, int posY, String ico) {
		
		//查看纵向方向
		int maxLength = 0;
		int upLen = 0;
		int downLen = 0;
		int i = posX;
		int j = posY;
		//查看棋子上边最大长度
		while (board[i][j].equals(ico)) {
		    upLen++;
		    if (i == 0)
		     	break;
		    else
			    i--;
		} 
		//查看棋子下最大长度
		i = posX;
		j = posY;
	    while (board[i][j].equals(ico)) {
			downLen++;
			if (i == 21)
				break;
			else
			    i++;
		}
		maxLength = upLen + downLen - 1;
		return maxLength;
	}
	
	/**
	 * 
	 * 查看纵向是否有五个相同的棋子
	 */
	public boolean isFiveInCol(String[][] board, int posX, int posY, String ico) {
		
		int maxLength = numberInCol(board, posX, posY, ico);
		if (maxLength == 5)
		    return true;
		else
			return false;
	}
	
	/**
	 * 
	 * 查看斜向下方向相同黑子的数量
	 */
	public int numberInRB(String[][] board, int posX, int posY, String ico) {
		
		//查看斜向下方向
		int maxLength = 0;
		int rbLen = 0;
		int luLen = 0;
		int i = posX;
		int j = posY;
		//查看棋子右下方最大长度
		while (board[i][j].equals(ico)) {
		    rbLen++;
		    if (i == 21 || j == 21)
			    break;
		    else {
			    i++;
				j++;
			}
		} 
		//查看棋子左上方最大长度
		i = posX;
		j = posY;
	    while (board[i][j].equals(ico)) {
			luLen++;
			if (i == 0 || j == 0)
				break;
			else {
			    i--;
				j--;
			}
		}
		maxLength = rbLen + luLen - 1;
		return maxLength;
	}
	
	/**
	 * 
	 * 查看斜向下方向是否有五个相同的棋子
	 */
	public boolean isFiveInRB(String[][] board, int posX, int posY, String ico) {
		
		int maxLength = numberInRB(board, posX, posY, ico);
		if (maxLength == 5)
		    return true;
		else
			return false;
	}
	
	/**
	 * 
	 * 查看斜向上方向相同黑子的数量
	 */
	public int numberInRU(String[][] board, int posX, int posY, String ico) {
		
		//查看斜向上方向
		int maxLength = 0;
		int ruLen = 0;
		int ldLen = 0;
		int i = posX;
		int j = posY;
		//查看棋子右上方最大长度
		while (board[i][j].equals(ico)) {
		    ruLen++;
		    if (i == 0 || j == 21)
		    	break;
		    else {
			    i--;
		    	j++;
		    }
		} 
		//查看棋子左下方最大长度
		i = posX;
		j = posY;
	    while (board[i][j].equals(ico)) {
			ldLen++;
			if (i == 21 || j == 0)
				break;
			else {
			    i++;
				j--;
			}
		}
		maxLength = ruLen + ldLen - 1;
		return maxLength;
	}
	
	/**
	 * 
	 * 查看斜向上方向是否有五个相同的棋子
	 */
	public boolean isFiveInRU(String[][] board, int posX, int posY, String ico) {
		
		int maxLength = numberInRU(board, posX, posY, ico);
		if (maxLength == 5)
		    return true;
		else
			return false;
	}
	
	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
