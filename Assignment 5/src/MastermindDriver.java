/*  Student information for assignment
 *
 *  On <our|my> honor, <NAME1> and <NAME2>,
 *  this programming assignment is <our|my> own work.
 *
 *  Student #1:
 *  Name #1: Jesse Campos
 *  EID #1: jpc639
 *  email address #1: jesse.campos@mail.utexas.edu
 *  TA name #1: Xiuming
 *  Unique course ID #1: 54022
 *  programming hours #1: 9
 *
 *  Student #2:
 *  Name #2: Zachary Tschirhart
 *  EID #2: zst75
 *  email address #2: ztschir@gmail.com
 *  TA name #2: Xiuming
 *  Unique course ID #2: 54022
 *  programming hours #2: 9
 *
 * Lines of Code:
*/

public class MastermindDriver {

    public static void main(String[] args){
        Game g = new Game(true);
        g.runGames();
        g = new Game(false);
        g.runGames();
    }

}