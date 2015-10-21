package gameJavaLesson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GobangGame {
    // 定义达到赢条件的棋子数目
    private final int WIN_COUNT = 5;
    // 定义用户输入的X坐标
    private int posX = 0;
    // 定义用户输入的X坐标
    private int posY = 0;
    // 定义棋盘
    private Chessboard chessboard;
    //判断输赢，棋子走向
    private static final int[][][] STEP = new int[][][]{
            {{0, 1}, {0, -1}},
            {{1, 0}, {-1, 0}},
            {{1, 1}, {-1, -1}},
            {{1, -1}, {-1, 1}}
    };
    //Logger
    private static Logger logger=Logger.getLogger("GoBang");
    /**
     * 空构造器
     */
    public GobangGame() {
    }

    /**
     * 构造器，初始化棋盘和棋子属性
     *
     * @param chessboard 棋盘类
     */
    public GobangGame(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    /**
     * 检查输入是否合法。
     *
     * @param inputStr 由控制台输入的字符串。
     * @return 字符串合法返回true, 反则返回false。
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
                int[] computerPosArr = computerDo();
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
     * @param chessman "●"为用户，"○"为计算机。
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
     * 分析用户当前坐标的周围8个点
     * @param posX 用户当前x
     * @param posY 用户当前y
     * @return robot's point
     */
    public int[] analysisBoard(int posX, int posY) {
        String[][] board = chessboard.getBoard();
        int pX = posX;
        int pY = posY;
        int ansX = posX;
        int ansY = posY;
        int fst = 1, nxt = 1;
        String ico = board[pX][pY];
        for (int i = 0; i < 4; ++i) {
            pX += STEP[i][0][0];
            pY += STEP[i][0][1];
            if (pX < 0 || pY < 0 || pY > Chessboard.BOARD_SIZE - 1 || pX > Chessboard.BOARD_SIZE - 1) {
                pX = posX;
                pY = posY;
                break;
            }
            if (Objects.equals(board[pX][pY], ico)) {
                pX -= 2 * STEP[i][0][0];
                pY -= 2 * STEP[i][0][1];
                if (pX < 0 || pY < 0 || pY > Chessboard.BOARD_SIZE - 1 || pX > Chessboard.BOARD_SIZE - 1) {
                    pX = posX;
                    pY = posY;

                    break;
                } else {
                    ansX = pX;
                    ansY = pY;
                    fst = i;
                    nxt = 0;

                }
                break;
            }
            pX = posX;
            pY = posY;
        }
        for (int i = 0; i < 4; ++i) {
            pX += STEP[i][1][0];
            pY += STEP[i][1][1];
            if (pX < 0 || pY < 0 || pY > Chessboard.BOARD_SIZE - 1 || pX > Chessboard.BOARD_SIZE - 1) {
                pX = posX;
                pY = posY;
                break;
            }
            if (Objects.equals(board[pX][pY], ico)) {
                pX -= 2 * STEP[i][1][0];
                pY -= 2 * STEP[i][1][1];
                if (pX < 0 || pY < 0 || pY > Chessboard.BOARD_SIZE - 1 || pX > Chessboard.BOARD_SIZE - 1) {
                    pX = posX;
                    pY = posY;
                    break;
                } else {
                    ansX = pX;
                    ansY = pY;
                    fst = i;
                    nxt = 1;
                }
                break;
            }
            pX = posX;
            pY = posY;
        }

        if (ansX < 0) {
            ansX = 0;
        }
        if (ansY < 0) {
            ansY = 0;
        }
        if (ansX > Chessboard.BOARD_SIZE - 1) {
            ansX = Chessboard.BOARD_SIZE - 1;
        }
        if (ansY > Chessboard.BOARD_SIZE - 1) {
            ansY = Chessboard.BOARD_SIZE - 1;
        }
        int i = 0;
        logger.log(Level.INFO,ansX+":"+ansY);
        logger.log(Level.INFO,STEP[fst][nxt][0]+":"+STEP[fst][nxt][1]);

        while (board[ansX][ansY] != "十") {
            ansX+=STEP[fst][nxt][0];
            ansY+=STEP[fst][nxt][1];
            if (ansX < 0 || ansY < 0 || ansY > Chessboard.BOARD_SIZE - 1 || ansX > Chessboard.BOARD_SIZE - 1) {
                ansX=Math.abs(ansX)%Chessboard.BOARD_SIZE;
                ansY=Math.abs(ansY)%Chessboard.BOARD_SIZE;
            }
            logger.log(Level.INFO,ansX+":"+ansY);
//            if (i>100)break;

        }
        return new int[]{ansX, ansY};
    }

    /**
     * 计算机随机下棋
     */
    public int[] computerDo() {
        int[] ansXY = analysisBoard(posX, posY);
        int posX = ansXY[0];
        int posY = ansXY[1];
        String[][] board = chessboard.getBoard();
        while (board[posX][posY] != "十") {
            posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
            posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
        }
        int[] result = {posX, posY};
        return result;
    }

    /**
     * 判断输赢
     *
     * @param posX 棋子的X坐标。
     * @param posY 棋子的Y坐标
     * @param ico  棋子类型
     * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
     */
    public boolean isWon(int posX, int posY, String ico) {
        int stX = posX;
        int stY = posY;
        for (int i = 0; i < 4; ++i) {
            int ans = 1;
            while (true) {
                stX += STEP[i][0][0];
                stY += STEP[i][0][1];
                if (stX < 0 || stY < 0 || stY > Chessboard.BOARD_SIZE - 1 || stX > Chessboard.BOARD_SIZE - 1) {
                    stX = posX;
                    stY = posY;
                    break;
                }
                if (chessboard.getBoard()[stX][stY].equals(ico)) {
                    ans += 1;
                    if (ans >= 5)
                        return true;
                } else {
                    break;
                }
            }
            stX = posX;
            stY = posY;
            while (true) {
                stX += STEP[i][1][0];
                stY += STEP[i][1][1];
                if (stX < 0 || stY < 0 || stY > Chessboard.BOARD_SIZE - 1 || stX > Chessboard.BOARD_SIZE - 1) {
                    stX = posX;
                    stY = posY;
                    break;
                }
                if (chessboard.getBoard()[stX][stY].equals(ico)) {
                    ans += 1;
                    if (ans >= 5)
                        return true;
                } else {
                    break;
                }
            }
            if (ans >= 5)
                return true;
            stX = posX;
            stY = posY;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        GobangGame gb = new GobangGame(new Chessboard());
        gb.start();
    }
}
