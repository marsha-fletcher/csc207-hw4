package edu.grinnell.csc207.fletcher1.hw4;

import java.io.PrintWriter;

public class StringUtils {

    /**
* splitAt
* @param str, a string
* @param divider, a char
* @return splitString, an array of substrings formed by splitting str at instances of divider
* @author Marsha Fletcher
* @author Evan Manuella
*/
    
    public static String[] splitAt(String str, char divider){
int len = str.length();
String temp = "";
String[] result = new String[len+1]; //worst case scenario, all chars are divider
int resultIndex = 0;
char current;

for (int i = 0; i < len; i ++){
current = str.charAt(i);
if(current == divider){
//add section before current divider
result[resultIndex] = temp;
temp = "";
resultIndex ++;
} else {
temp+=current;
}//else
}// for
//add section after last divider
result[resultIndex] = temp;

//Check if the array needs to be trimmed
if (resultIndex == (len)){
return result;
} else {
return trimStrArray(result);
}//if else
    } //splitAt

    /**
* trimStrArray
* @param strArray
* @return trimmedArray, an array that has the same elements as strArray
* until strArray's first null element
* @author Marsha Fletcher
* @author Evan Manuella
* Created as a helper for splitAt. This is horribly inefficient, but we're
* not sure how to get a properly sized array more efficiently.
*/
    
    public static String[] trimStrArray(String[] strArray){
int len = strArray.length;
int index = 0;
while ((strArray[index] != null) && (index < len)){
index ++;
}//while - find the first instance of null

String[] trimmedArray = new String[index];
for (int i = 0; i < index; i ++){
trimmedArray[i] = strArray[i];
}//for - fill trimmedArray

return trimmedArray;
    }

    /**
* splitCSV
* @param str
* @return splitString[], an array of substrings that were divided by commas
* @author Marsha Fletcher
* @author Evan Manuella
*/
    public static String[] splitCSV(String str){
int len = str.length();
String temp = "";
String[] result = new String[len + 1];
int resultIndex = 0;
char current;
char innerCurrent;

char nextUp;

for (int i = 0; i < len; i ++){
current = str.charAt(i);
switch (current){
case ',':
result[resultIndex] = temp;
temp = "";
resultIndex += 1;
break;
case '\"': //if we have a "
if (str.charAt(1 + i) == '\"'){ //check if it is meant as a character
temp += current;
i ++; //char at i+1 doesn't count
break;
} else { //it's meant to section off a division
for (int j = (i + 1); j < len; j ++){
innerCurrent = str.charAt(j);
nextUp = str.charAt(j + 1);

if (innerCurrent == '\"' && nextUp != '\"'){//We are at the end
i = j; //increment i so that it is past this division
break;
//We are at a " character
} else if (innerCurrent == '\"' && innerCurrent == nextUp){
temp += innerCurrent;
j ++;// nextUp doesn't count as its own char
//We are at a normal character
} else {
temp += innerCurrent;
}//if else
}//inner for
}//conditional dealing with divisions wrapped in quotes
break;
default:
temp += current;
break;
}//switch

}//for
//add last division to array
result[resultIndex] = temp;

//Check if the array needs to be trimmed
if (resultIndex == (len)){
return result;
} else {
return trimStrArray(result);
}//if else trimming
    }//splitCSV

    /**
* deLeet
* Takes a 133+ string that follows the guide below and returns
* a string with normal spelling
* @author Evan Manuella
* @author Marsha Fletcher
* @param str The string that you want converted
* @return The original string converted from leetspeak
*
* + to t,
* @ to a,
* 3 to e,
* 1 to l,
* 0 to o,
* |3 to b,
* |\| to n
*
*
*/

    public static String deLeet(String str){
int len = str.length();
String deLeeted = "";
for (int i = 0; i < len; i ++){
char c = str.charAt(i);
switch (c) {
case '|':
if (str.charAt(i + 1) == '3'){
deLeeted+="b";
//This took care of 2 characters, so advance the index accordingly
i+=1;
break;
} else if (str.charAt(i + 1) == '\\'){
deLeeted+="n";
//This took care of 3 characters, so advance the index accordingly
i += 2;
break;
} else {
deLeeted+=Character.toString(c);
break;
}//if else for |
case '@':
deLeeted+="a";
break;
case '1':
deLeeted+="l";
break;
case '+':
deLeeted+="t";
break;
case '0':
deLeeted+="o";
break;
case '3':
deLeeted+="e";
break;
default:
deLeeted+=Character.toString(c);
break;
}//switch
}//for
return deLeeted;
    }//deLeet

    public static boolean isVowel(Character val){
switch (val){
case 'a': return true;
case 'A' : return true;
case 'e' : return true;
case 'E' : return true;
case 'i' : return true;
case 'I' : return true;
case 'o' : return true;
case 'O' : return true;
case 'u' : return true;
case 'U' : return true;
case 'y' : return true;
case 'Y' : return true;
default: return false;
}//switch
    }//isVowel

    /**
* nameGame
* Takes a name (or any string with at least 2 characters containing
* at least one vowel) and returns a verse of Shirley Ellis's name game.
* @param name, a string
* @return verse, a string
* @author Marsha Fletcher
* @author Evan Manuella
*
*/
    public static String nameGame(String name){
int len = name.length();
String cdrName = name.substring(1);
Character carName = name.charAt(0);

for (int i = 1; i < len; i ++){
if (isVowel(carName)){

//if name starts with a vowel
if (Character.isUpperCase(carName)){
cdrName = Character.toLowerCase(carName) + cdrName;
break;

//if name starts with a vowel but isn't properly capitalized
} else if (i == 1){
cdrName = name;
break;

//else we've hit the first vowel of a name that starts w a consonant
} else{
break;
}
}//if we're at a vowel
else{
carName = name.charAt(i);
cdrName = name.substring(i);
}//else we're at a consonant

}//while
return name + "!\n" + name + ", " + name + " bo B" + cdrName
+ " Bonana fanna fo F"+ cdrName + "\nFee fy mo M" + cdrName + ", "
+ name + "!";
    }//nameGame

//main method for testing the nameGame procedure.
    public static void main (String args[]){
PrintWriter pen = new PrintWriter (System.out, true);
//Experiment with a name beginning with a vowel
pen.println(nameGame("Evan"));
//Experiment with a name beginning with 1 consonant
pen.println(nameGame("Marsha"));
//Experiment with a name beginning with multiple consonants
pen.println(nameGame("Christine"));
//Experiment with a name beginning with a lower case vowel
pen.println(nameGame("askjdfh"));
//Experiment with a name beginning with multiple lower case consonants
pen.println(nameGame("thoreau"));

pen.close();
    }
}