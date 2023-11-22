import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("InputOneTwo.txt"));
        writeFileAllAnswers("answers", challengeOne("InputOneTwo.txt"), challengeTwo("InputOneTwo.txt"),challengeThree("InputThreeFour.txt"),challengeFour("InputThreeFour.txt"));
        System.out.println(challengeTwo("InputOneTwo.txt"));
        System.out.println(challengeThree("InputThreeFour.txt"));
        System.out.println(challengeFour("InputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException
    {
        int[] arr = storeArray(fileName);
        int inc = 0;
        for(int i = 1; i<arr.length; i++)
        {
            if(arr[i] > arr[i-1])
            {
                inc++;
            }
        }
        return inc;
    }


    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int count = 0;
        int[] arr2 = readFile(fileName);
        int end = arr2.length%3;
        for(int i = 2; i<arr2.length-end-2; i++)
        {
            int sum = arr2[i+1] + arr2[i+2] + arr2[i+3];
            int sum2 = arr2[i] + arr2[i-1] + arr2[i-2];

            if(sum > sum2)
            {
                count++;
            }

        }
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] three = storeArrayString(fileName);

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int horizontal = 0;
        int depth = 0;

        for(int i = 0; i <three.length; i++)
        {
            String temp = three[i];

            if(temp.contains("forward"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                horizontal = horizontal + value;
            }
            if(temp.contains("down"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                depth = depth + value;
            }
            if(temp.contains("up"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                depth = depth - value;
            }

        }

        return horizontal * depth;


    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param fileName
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String fileName) throws FileNotFoundException {
        String[] four = storeArrayString(fileName);

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for(int i = 0; i <four.length; i++)
        {
            String temp = four[i];

            if(temp.contains("forward"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                horizontal = horizontal + value;
                depth = depth + aim*value;
            }
            if(temp.contains("down"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                aim = aim + value;
            }
            if(temp.contains("up"))
            {
                String tt = temp.substring(temp.length()-1);
                int value = Integer.parseInt(tt);
                aim = aim - value;
            }

        }

        return horizontal * depth;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

    public static int countLines (String fileName) throws FileNotFoundException {
        int count = 0;
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine())
        {
            count++;
            scanner.nextLine();
        }
        return count;
    }

    public static int[] storeArray (String fileName) throws FileNotFoundException {
        int lines = countLines(fileName);
        int[] array = new int[lines];

        int index = 0;

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            array[index++] = scanner.nextInt();

        }

        return array;

    }

    public static String[] storeArrayString (String fileName) throws FileNotFoundException {
        int lines = countLines(fileName);
        String[] array = new String[lines];

        int index = 0;

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            array[index++] = scanner.nextLine();

        }

        return array;

    }
}