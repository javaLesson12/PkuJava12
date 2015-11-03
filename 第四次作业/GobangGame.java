/**
 * ��Ϸ����
 */
package com.qzs.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				
				isOver = true;
			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo(chessboard);
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo(Chessboard chessboard) {
		
		int[] result = new int[2];
		int lastX = chessboard.getLastX();
		int lastY = chessboard.getLastY();
		String[][] board = chessboard.getBoard();
		
		//�ж�������ӵĺ����Ƿ����������ĸ������У��������ֹ
		int lenInRow = numberInRow(board, lastX, lastY, Chessman.BLACK.getChessman());
		if (lenInRow == 3 || lenInRow == 4) {
			//����Ƿ��ҵ�����λ��
			boolean isExist = false;
			//�����һ�����ӵ�λ��Ϊ������Ҳ��Һ���λ��
			for (int i = lastY; i < Chessboard.BOARD_SIZE; i++) {
				if (board[lastX][i-1].equals(Chessman.BLACK.getChessman()) && board[lastX][i].equals("ʮ")) {
					isExist = true;
					result[0] = lastX;
					result[1] = i;
					break;
				}
			}
			//����ұߴ��ں���λ��
			if (isExist)
				return result;
			
			//�����һ�����ӵ�λ��Ϊ���������Һ���λ��
			for (int i = lastY; i >= 0; i--) {
				if (board[lastX][i+1].equals(Chessman.BLACK.getChessman()) && board[lastX][i].equals("ʮ")) {
					isExist = true;
					result[0] = lastX;
					result[1] = i;
					break;
				}
			}
			//�����ߴ��ں���λ��
			if (isExist)
				return result;
		}
		
		//�ж�������ӵ������Ƿ����������ĸ������У��������ֹ
	    int lenInCol = numberInCol(board, lastX, lastY, Chessman.BLACK.getChessman());
	    if (lenInCol == 3 || lenInCol == 4) {
		    //����Ƿ��ҵ�����λ��
	        boolean isExist = false;
	        //�����һ�����ӵ�λ��Ϊ������²��Һ���λ��
		    for (int i = lastX; i < Chessboard.BOARD_SIZE; i++) {
		        if (board[i-1][lastY].equals(Chessman.BLACK.getChessman()) && board[i][lastY].equals("ʮ")) {
			       isExist = true;
				   result[0] = i;
				   result[1] = lastY;
			       break;
			    }
		    }
			//����±ߴ��ں���λ��
			if (isExist)
				return result;
			
			//�����һ�����ӵ�λ��Ϊ������ϲ��Һ���λ��
			for (int i = lastX; i >= 0; i--) {
				if (board[i+1][lastY].equals(Chessman.BLACK.getChessman()) && board[i][lastY].equals("ʮ")) {
					isExist = true;
					result[0] = i;
					result[1] = lastY;
					break;
				}
			}
			//�����ߴ��ں���λ��
			if (isExist)
				return result;
		}
		
	  //�ж�������ӵ�б���·����Ƿ����������ĸ������У��������ֹ
	  int lenInRB = numberInRB(board, lastX, lastY, Chessman.BLACK.getChessman());
	  if (lenInRB == 3 || lenInRB == 4) {
	  	//����Ƿ��ҵ�����λ��
	  	boolean isExist = false;
	  	//�����һ�����ӵ�λ��Ϊ����������Ϸ�����Һ���λ��
	  	for (int i = lastX, j = lastY; i >= 0 && j >= 0; i--, j--) {
	  		if (board[i+1][j+1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("ʮ")) {
	  			isExist = true;
	  			result[0] = i;
	  			result[1] = j;
	  			break;
	  		}
	  	}
	  	//����ұߴ��ں���λ��
	  	if (isExist)
	  		return result;
	  			
		//�����һ�����ӵ�λ��Ϊ����������²��Һ���λ��
	  	for (int i = lastX, j = lastY; i < Chessboard.BOARD_SIZE && j < Chessboard.BOARD_SIZE; i++, j++) {
	  		if (board[i-1][j-1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("ʮ")) {
	  			isExist = true;
	  			result[0] = i;
	  			result[1] = j;
	  			break;
	  		}
	  	}
	  	//�����ߴ��ں���λ��
	  	if (isExist)
	  		return result;
	 }
	  
     //�ж�������ӵ�б���Ϸ����Ƿ����������ĸ������У��������ֹ
     int lenInRU = numberInRU(board, lastX, lastY, Chessman.BLACK.getChessman());
     if (lenInRU == 3 || lenInRU == 4) {
    	 //����Ƿ��ҵ�����λ��
	     boolean isExist = false;
	     //�����һ�����ӵ�λ��Ϊ����������Ϸ�����Һ���λ��
	     for (int i = lastX, j = lastY; i >= 0 && j < Chessboard.BOARD_SIZE; i--, j++) {
	         if (board[i+1][j-1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("ʮ")) {
	  		   isExist = true;
	  		   result[0] = i;
	  		   result[1] = j;
	  		   break;
	  		  }
	  	  }
	  	 //����ұߴ��ں���λ��
	  	 if (isExist)
	        return result;
	  			
	     //�����һ�����ӵ�λ��Ϊ����������·�����Һ���λ��
	  	 for (int i = lastX, j = lastY; i < Chessboard.BOARD_SIZE && j >= 0; i++, j--) {
	  		if (board[i-1][j+1].equals(Chessman.BLACK.getChessman()) && board[i][j].equals("ʮ")) {
	  	        isExist = true;
	  			result[0] = i;
	  		    result[1] = j;
	  		    break;
	  		}
	  	}
	  	//�����ߴ��ں���λ��
	  	if (isExist)
	  	    return result;
	  }
		
      //�������Ҫ�谭����
      //�ڸ������ұ��ҵ�һ������λ��
      boolean isFound = false;
      for (int i = lastY; i < Chessboard.BOARD_SIZE; i++) {
    	  if (board[lastX][i].equals("ʮ")) {
    		  result[0] = lastX;
    		  result[1] = i;
    		  isFound = true;
    		  break;
    	  }
      }
      if (isFound)
          return result;
     
     //�ڸ���������ҵ�һ������λ��
     for (int i = lastY; i >= 0; i--) {
    	  if (board[lastX][i].equals("ʮ")) {
    		  result[0] = lastX;
    		  result[1] = i;
    		  isFound = true;
    		  break;
    	  }
      }
      if (isFound)
          return result;
    
      //�ڸ������ϱ��ҵ�һ������λ��
      for (int i = lastX; i >= 0; i--) {
     	  if (board[i][lastY].equals("ʮ")) {
     		  result[0] = i;
     		  result[1] = lastY;
     		  isFound = true;
     		  break;
     	  }
       }
       if (isFound)
           return result;
      
       //�ڸ������±��ҵ�һ������λ��
       for (int i = lastX; i < Chessboard.BOARD_SIZE; i--) {
      	  if (board[i][lastY].equals("ʮ")) {
      		  result[0] = i;
      		  result[1] = lastY;
      		  isFound = true;
      		  break;
      	  }
        }
        if (isFound)
            return result;
      
      //���������Ҿ�û�к���λ�ã������������̣��ҵ�һ������λ��
      for (int i = 0; i < Chessboard.BOARD_SIZE; i++) 
    	  for (int j = 0; j < Chessboard.BOARD_SIZE; j++)
    		  if (board[i][j].equals("ʮ")){
    			  result[0] = i;
    			  result[1] = j;
    			  break;
    		  }
	  return result;
	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		//�鿴������
		boolean isRow = isFiveInRow(board, posX, posY, ico);
		if (isRow)
			return true;
        //�鿴������
		boolean isCol = isFiveInCol(board, posX, posY, ico);
		if (isCol)
			return true;
		//�鿴б���·���
		boolean isRB = isFiveInRB(board, posX, posY, ico);
		if (isRB)
			return true;
		//�鿴б���Ϸ���
		boolean isRU = isFiveInRU(board, posX, posY, ico);
		if (isRU)
			return true;
		else 
		    return false;
	}

	/**
	 * 
	 * �鿴������ͬ���ӵ�����
	 */
	public int numberInRow(String[][] board, int posX, int posY, String ico) {
		//�鿴������
		int maxLength = 0;
		int rightLen = 0;
		int leftLen = 0;
		int i = posX;
		int j = posY;
		//�鿴�����ұ���󳤶�
		while (board[i][j].equals(ico)) {
		    rightLen++;
		    if (j == 21)
			     break;
			else
			     j++;
		} 
		//�鿴���������󳤶�
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
	 * �鿴�����Ƿ��������ͬ������
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
	 * �鿴������ͬ���ӵ�����
	 */
	public int numberInCol(String[][] board, int posX, int posY, String ico) {
		
		//�鿴������
		int maxLength = 0;
		int upLen = 0;
		int downLen = 0;
		int i = posX;
		int j = posY;
		//�鿴�����ϱ���󳤶�
		while (board[i][j].equals(ico)) {
		    upLen++;
		    if (i == 0)
		     	break;
		    else
			    i--;
		} 
		//�鿴��������󳤶�
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
	 * �鿴�����Ƿ��������ͬ������
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
	 * �鿴б���·�����ͬ���ӵ�����
	 */
	public int numberInRB(String[][] board, int posX, int posY, String ico) {
		
		//�鿴б���·���
		int maxLength = 0;
		int rbLen = 0;
		int luLen = 0;
		int i = posX;
		int j = posY;
		//�鿴�������·���󳤶�
		while (board[i][j].equals(ico)) {
		    rbLen++;
		    if (i == 21 || j == 21)
			    break;
		    else {
			    i++;
				j++;
			}
		} 
		//�鿴�������Ϸ���󳤶�
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
	 * �鿴б���·����Ƿ��������ͬ������
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
	 * �鿴б���Ϸ�����ͬ���ӵ�����
	 */
	public int numberInRU(String[][] board, int posX, int posY, String ico) {
		
		//�鿴б���Ϸ���
		int maxLength = 0;
		int ruLen = 0;
		int ldLen = 0;
		int i = posX;
		int j = posY;
		//�鿴�������Ϸ���󳤶�
		while (board[i][j].equals(ico)) {
		    ruLen++;
		    if (i == 0 || j == 21)
		    	break;
		    else {
			    i--;
		    	j++;
		    }
		} 
		//�鿴�������·���󳤶�
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
	 * �鿴б���Ϸ����Ƿ��������ͬ������
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
