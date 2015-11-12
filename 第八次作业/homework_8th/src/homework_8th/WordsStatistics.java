package homework_8th;
//输出 到 homework_8th\out 以及cmd
import java.io.*;
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

    public void printWords(String name) {
        out.println(name);
        this.words.forEach((s) -> {
            out.println("# " + s);
        });
    }

    public void printWords(String name, OutputStream out) throws IOException {
        out.write(name.getBytes());
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

    public Integer getListLength() {
        return getWords().size();
    }

    private void printLength(String name) {
        out.println(name + " 长度：" + getListLength());
    }

    private void printLength(String name, OutputStream out) throws IOException {
        out.write((name + " 长度：" + getListLength()).getBytes("utf-8"));
        out.write(System.getProperty("line.separator").getBytes());


    }

    private void printLength() {

        out.println(" 长度：" + getListLength());
    }

    public void print(int type, String name) {
        out.print("--------------------------");
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
        out.write(System.getProperty("line.separator").getBytes());
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
        out.write(System.getProperty("line.separator").getBytes());

    }

    public void printToFile(WordsStatistics words1, WordsStatistics words2, File file) {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            words1.print(WordsStatistics.LEGNTH, "第一个文件单词", outputStream);
            words2.print(WordsStatistics.LEGNTH, "第二个文件单词", outputStream);
            words1.mergeWords(words2).print(WordsStatistics.LIST, "合并不重复单词列表：", outputStream);
            words1.getRepeatedWords(words2).print(WordsStatistics.LIST, "重复单词列表：", outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        readWordsFromFile(words1, new File(WordsStatistics.class.getResource("words1.in").getPath()));
        readWordsFromFile(words2, new File(WordsStatistics.class.getResource("words2.in").getPath()));
        words1.print(WordsStatistics.LEGNTH, "第一个文件单词");
        words2.print(WordsStatistics.LEGNTH, "第二个文件单词");
        words1.mergeWords(words2).print(WordsStatistics.LIST, "合并不重复单词列表：");
        words1.getRepeatedWords(words2).print(WordsStatistics.LIST, "重复单词列表：");
        File file = new File(new File(WordsStatistics.class.getResource("words1.in").getPath()).getParentFile().getAbsoluteFile() + "\\words.out");
        out.println(file.getAbsolutePath());

        if (file.createNewFile())
            words1.printToFile(words1, words2, file);

    }
}
