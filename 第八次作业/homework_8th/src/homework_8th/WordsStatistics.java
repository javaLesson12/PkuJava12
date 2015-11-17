package homework_8th;
//输出 到 homework_8th\out 以及cmd

import java.io.*;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by umic-lord on 11/12/2015.
 */
public class WordsStatistics {
    public static final int LEGNTH = 1001;
    public static final int LIST = 1002;
    private ArrayList<String> words;

    private static void printAnsThree(WordsStatistics words1, WordsStatistics words2, String str1, String str2) {
        words1.print(WordsStatistics.LEGNTH, str1);//输出问题3 length(A)
        WordsStatistics words1Uq = words1.getWordsUnique(words2);
        words1Uq.print(WordsStatistics.LEGNTH, str2);//输出问题3 length(A-B)
        printPercent(words1, words1Uq);
    }

    private static void printPercent(WordsStatistics words1, WordsStatistics words1Uq) {
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMinimumFractionDigits(2);
        float words1Percent = (float) words1Uq.getWords().size() / (float) words1.getWords().size();
        float words1PercentUq = (float) words1Uq.uniqueWords().getWords().size() / (float) words1.uniqueWords().getWords().size();
        out.println("以上文件特有单词长度占总单词长度" + format.format(words1Percent) + "，无重复特有单词长度占总单词长度" + format.format(words1PercentUq));
    }

    private static void printPercent(WordsStatistics words1, WordsStatistics words1Uq, OutputStream out) throws Exception {
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMinimumFractionDigits(2);
        float words1Percent = (float) words1Uq.getWords().size() / (float) words1.getWords().size();
        float words1PercentUq = (float) words1Uq.uniqueWords().getWords().size() / (float) words1.uniqueWords().getWords().size();
        out.write(("以上文件特有单词长度占总单词长度" + format.format(words1Percent) + "，无重复特有单词长度占总单词长度" + format.format(words1PercentUq)).getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes("utf-8"));

    }

    public void setWords(List<String> words) {
        this.words = new ArrayList<>();
        this.words.addAll(words);
    }

    public WordsStatistics(List<String> words) {
        this.words = new ArrayList<>();
        this.words.addAll(words);
    }

    public WordsStatistics() {
        this.words = new ArrayList<>();
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public WordsStatistics mergeWords(WordsStatistics words_other) {

        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(words_other.getWords());
        hashSet.addAll(this.words);
        List<String> words = new ArrayList<>();
        words.addAll(hashSet);
        return new WordsStatistics(words);
    }

    public WordsStatistics getRepeatedWords(WordsStatistics words_other) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(words_other.getWords());
        List<String> repeatedWords = new ArrayList<>();
        HashSet<String> hashSet_recv = new HashSet<>();

        this.getWords().forEach((word) -> {
            if (hashSet.contains(word)) {
                hashSet_recv.add(word);
            }
        });
        repeatedWords.addAll(hashSet_recv);
        return new WordsStatistics(repeatedWords);
    }

    public WordsStatistics getWordsUnique(WordsStatistics words_other) {
        List<String> ans = new ArrayList<>();
        List<String> words_other_list = words_other.getWords();
        this.getWords().forEach((w) -> {
            if (!words_other_list.contains(w)) {
                ans.add(w);
            }
        });
        return new WordsStatistics(ans);
    }

    public WordsStatistics uniqueWords() {
        HashSet<String> tmpSet = new HashSet<>();
        tmpSet.addAll(this.getWords());
        List<String> uniqueStr = new ArrayList<>();
        uniqueStr.addAll(tmpSet);
        this.setWords(uniqueStr);
        return this;
    }

    public void printWords(String name) {
        out.println(name);
        this.words.forEach((s) -> {
            out.println("# " + s);
        });
    }

    public void printWords(String name, OutputStream out) throws IOException {
        out.write(name.getBytes());
        out.write(System.getProperty("line.separator").getBytes("utf-8"));
        this.words.forEach((s) -> {
            try {
                out.write(("# " + s).getBytes("utf-8"));
                out.write(System.getProperty("line.separator").getBytes());

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void printWords() {
        this.words.forEach((s) -> {
            out.println("# " + s);
        });
    }

    public Integer getListLength(boolean unique) {
        WordsStatistics words = new WordsStatistics(this.getWords());
        int len;
        if (unique) {
            len = words.uniqueWords().getWords().size();
        } else {
            len = words.getWords().size();
        }
        return len;
    }

    private void printLength(String name) {
        out.println(name + "单词长度：" + getListLength(false));
        out.println(name + "单词（无重复）长度：" + getListLength(true));
    }

    private void printLength(String name, OutputStream out) throws IOException {
        out.write((name + "单词长度：" + getListLength(false)).getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes());
        out.write((name + "单词（无重复）长度：" + getListLength(true)).getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes());


    }

    public void print(int type, String name) {
        out.println("--------------------------");
        switch (type) {
            case LEGNTH:
                printLength(name);
                break;
            case LIST:
                printWords(name);
                break;
            default:
        }
        out.println("--------------------------");

    }

    public void print(int type, String name, OutputStream out) throws IOException {
        out.write("--------------------------".getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes("utf-8"));
        switch (type) {
            case LEGNTH:
                printLength(name, out);
                break;
            case LIST:
                printWords(name, out);
                break;
            default:
        }
        out.write("--------------------------\n".getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes("utf-8"));

    }

    public void printToFile(WordsStatistics words1, WordsStatistics words2, File file) {//输出到文件
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            prinAnsThreeToStream(words1, words2, outputStream, "第一个文件单词");
            prinAnsThreeToStream(words2, words1, outputStream, "第二个文件单词");
            words1.mergeWords(words2).print(WordsStatistics.LIST, "合并不重复单词列表：", outputStream);
            words1.getRepeatedWords(words2).print(WordsStatistics.LIST, "重复单词列表：", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prinAnsThreeToStream(WordsStatistics words1, WordsStatistics words2, OutputStream outputStream, String str) throws Exception {
        WordsStatistics words1Uq = words1.getWordsUnique(words2);
        words1Uq.print(WordsStatistics.LEGNTH, str, outputStream);
        printPercent(words1, words1Uq, outputStream);
    }

    public static void readWordsFromFile(WordsStatistics wordsStatistics, File file) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            List<String> words = new ArrayList<>();
            byte[] bytes = new byte[100];
            int byteRead;
            StringBuilder stringBuilder = new StringBuilder();
            while ((byteRead = inputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes).toLowerCase());
            }
            String[] strings = stringBuilder.toString().split(" ");
            for (String s : strings) {
                words.add(s);
            }
            wordsStatistics.setWords(words);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
    }

    public static void main(String[] args) throws Exception {
//        WordsStatistics words1 = new WordsStatistics(new ArrayList<String>() {
//            {
//                add("A");
//                add("B");
//            }
//        });
//        WordsStatistics words2 = new WordsStatistics(new ArrayList<String>() {
//            {
//                add("A");
//                add("C");
//            }
//        });
        WordsStatistics words1 = new WordsStatistics();
        WordsStatistics words2 = new WordsStatistics();
        readWordsFromFile(words1, new File(WordsStatistics.class.getResource("words1.in").getPath()));//文件读取路径
        readWordsFromFile(words2, new File(WordsStatistics.class.getResource("words2.in").getPath()));//文件读取路径
        words1.mergeWords(words2).print(WordsStatistics.LIST, "合并不重复单词列表：");//console 输出问题1，A V B -AB
        words1.getRepeatedWords(words2).print(WordsStatistics.LIST, "重复单词列表：");//输出问题2 AB
        printAnsThree(words1, words2, "第一个文件单词", "第一个文件单词特有");
        printAnsThree(words2, words1, "第二个文件单词", "第二个文件单词特有");
        //输出到文件 work.out
        File file = new File(new File(WordsStatistics.class.getResource("./").getPath()).getAbsoluteFile() + "\\words.out");
//        out.println(file.getAbsolutePath());
        if (file.exists())
            file.delete();
        if (file.createNewFile())
            words1.printToFile(words1, words2, file);

    }


}
