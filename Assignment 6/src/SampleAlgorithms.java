import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.math.BigInteger;
import java.util.Arrays;

public class SampleAlgorithms
{

    public static void main(String[] args)
    {
        // call methods here. Use the Stopwatch object s to record times.
        Stopwatch s = new Stopwatch();

        // example of using stopwatch
        s.start();
        int total = 0;
        for(int i = 0; i < 4000000; i++){
             total *= 2;
        }
        s.stop();

        // 3 different ways of getting elapsed time
        System.out.println( s.time() );
        System.out.println( s );
        System.out.println( s.timeInNanoseconds() + " nanoseconds");

        // As of summer 2004:
        // on my crusty old laptop (500 MHz processor)
        // the above code took between 0.08 and 0.1 seconds
        // or between 80 and 100 milliseconds.
        // Update, February 2006. On my new latop this takes between 0.01 and 0.02 seconds
        // or between 10 and 20 milliseconds. My new laptop has a 2 GHz processor.
        // The processor is 4 times as fast so if the aboe is O(N) it should
        // take one quarter of the time. The actual results are close.

        // uncomment the following call to processFiles when ready to try method
        // on 3 different files.

        
        /* //running time tests
        int testN = 4000000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method1(testN);
            s.stop();
            System.out.println("Method 1: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 10000000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method2(testN);
            s.stop();
            System.out.println("Method 2: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 1000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method3(testN);
            s.stop();
            System.out.println("Method 3: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 700000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method4(testN);
            s.stop();
            System.out.println("Method 4: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 150;
        for (int i = 0; i <= 3; i++){
            s.start();
            method5(testN);
            s.stop();
            System.out.println("Method 5: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 3000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method6(testN);
            s.stop();
            System.out.println("Method 6: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 300;
        for (int i = 0; i <= 3; i++){
            s.start();
            method7(testN);
            s.stop();
            System.out.println("Method 7: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 200;
        for (int i = 0; i <= 3; i++){
            s.start();
            method8(testN);
            s.stop();
            System.out.println("Method 8: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        String testStringN = "";
        for (int i = 0; i < 2000; i++){
        	testStringN += 1;
        }
        s.start();
        method9(testStringN);
        s.stop();
        System.out.println("Method 9: N = " + testN + ".  Time = " + s);
        for (int i = 0; i < 4000; i++){
        	testStringN += 1;
        }
        s.start();
        method9(testStringN);
        s.stop();
        System.out.println("Method 9: N = " + testN + ".  Time = " + s);
        for (int i = 0; i < 8000; i++){
        	testStringN += 1;
        }
        s.start();
        method9(testStringN);
        s.stop();
        System.out.println("Method 9: N = " + testN + ".  Time = " + s);
        for (int i = 0; i < 16000; i++){
        	testStringN += 1;
        }
        s.start();
        method9(testStringN);
        s.stop();
        System.out.println("Method 9: N = " + testN + ".  Time = " + s);

        
        
        testN = 3000000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method10(testN);
            s.stop();
            System.out.println("Method 10: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }
        
        testN = 4000000;
        for (int i = 0; i <= 3; i++){
            s.start();
            method11(testN);
            s.stop();
            System.out.println("Method 11: N = " + testN + ".  Time = " + s);
            testN *= 2;
        }*/

        
        //processFiles();

        System.out.println();
        Random r = new Random();
        int[] list = new int[1000];
        while(list.length < 4000000){
            for(int i = 0; i < list.length; i++)
                list[i] = r.nextInt();
            System.out.println("List length: " + list.length + ". Number of minimums found: " +
                    numMins(list));
            list = new int[list.length * 2];
        }
    }

    public static void processFiles(){
        Scanner input = new Scanner(System.in);
        FileToStringConverter f = new FileToStringConverter();
        do{
            f.chooseNewFile();
            Stopwatch s = new Stopwatch();

            s.start();
            String[] words = f.getWords();
            s.stop();
            System.out.println( "\nTime to convert file to words: " + s );
            System.out.println( "Number of words in file: " + words.length );

            ArrayList<String> wordList = new ArrayList<String>();
            s.start();
            for(int i = 0; i < words.length; i++)
                wordList.add(words[i]);
            s.stop();
            System.out.println("\nTime to add words to end of ArrayList: " + s);
            wordList.clear();

            s.start();
            for(int i = 0; i < words.length; i++)
                wordList.add(0, words[i]);
            s.stop();
            System.out.println( "\nTime to add words to beginning of ArrayList: " + s );

            System.out.println("\nTreeSet example:");
            handleSet(new TreeSet<String>(), words);

            System.out.println("\nHashSet example:");
            handleSet(new HashSet<String>(), words);

            System.out.print("Another? (type to do another file): ");
        }
        while(input.nextLine().toUpperCase().charAt(0) == 'Y');

    }

    public static void handleSet(Set<String> wordSet, String[] words){
        Stopwatch s = new Stopwatch();
        s.start();
        for(int i = 0; i < words.length; i++)
            wordSet.add(words[i]);
        s.stop();
        System.out.println( "Time to add words to set: " + s);
        System.out.println("Number of words in set: " + wordSet.size());
    }

    /**
     * Count the number of times a new minimum is found in a list.
     * <br>pre: list != null, list.length > 0
     * <br>post: return the number of minimums that occur while searching the list for
     * the true minimum.
     */
    public static int numMins(int[] list)
    {    int numMins = 1;
        int min = list[0];
        for(int i = 1; i < list.length; i++)
            if( list[i] < min ){
                numMins++;
                min = list[i];
            }
        return numMins;
    }

    public static void method1(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i++)
            sum++;
    }

    public static void method2(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i += 2)
            sum++;
    }

    public static void method3(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i++)	
            for(int j = 0; j < n; j++) 
                sum++;
    }

    public static void method4(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i++)
            sum++;
        for(int j = 0; j < n; j++)
            sum++;
    }

    public static void method5(int n)
    {    int sum = 0;						
        for(int i = 0; i < n; i++)				
            for(int j = 0; j < n*n; j++)		
                sum++;
    }

    public static void method6(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < i; j++)
                sum++;
    }

    public static void method7(int n)
    {    double sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                // assume Math.random() is O(1)
                sum += Math.random();
            }
        }
    }

    public static void method8(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++)
                   sum++;
    }

    /**
     * pre: n contains all digits
     *
     * to create a string with enough digits use a for loop back in main
    */
    public static void method9(String n)
    {    int sum = 0;

        // n is all digits
        BigInteger limit = new BigInteger(n);

        BigInteger two = new BigInteger("2");

        //assume the BigInteger methods compareTo and multiply are log N
        for(BigInteger i = new BigInteger("1"); i.compareTo(limit) <= 0; i = i.multiply(two))
            sum++;
    }

    public static void method10(int n)
    {    int sum = 0;
        for(int i = 0; i < n; i++)
            for(int j = 1; j < n; j *= 2)
                sum++;
    }

    public static void method11(int n, int m)
    {    Random r = new Random();			
        int[] list;							
        for(int i = 0; i < m; i++){			
            list = new int[n];				
            for(int j = 0; j < n; j++){		
                 list[j] = r.nextInt();		
            }
            // assume Arrays.sort is O(NlogN)
            Arrays.sort(list);
        }
    }

}