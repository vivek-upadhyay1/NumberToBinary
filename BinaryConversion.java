import java.util.Scanner;

public class BinaryConversion{

public static void main(String[] args){
System.out.println("Enter a non decimal number to find binary representation ");
Scanner sc = new Scanner(System.in);
long input = sc.nextLong();

String binaryWithString = getBinaryWithString(input);
System.out.println("Only using string " +binaryWithString);

String binaryWithStringBuilder = getBinaryWithStringBuilder(input);
System.out.println("using stringbuilder "+ binaryWithStringBuilder);

}

private static String getBinaryWithStringBuilder(long input){
// this is faster and memory friendly than usage of string
StringBuilder sb = new StringBuilder();
long qutent = 1;
//if()
while(qutent >0){
long tempRemainder = getRemainder(input);
long tempQutent = getQutient(input);
//string build take care of revering the order by inserting new character at 0 and shifting existing to index+1
sb.insert(0,tempRemainder);
input = tempQutent;
qutent = tempQutent;
}
 return sb.toString();	
}

private static String getBinaryWithString(long input){
// drawback here is that since string is immutable, each operation to change the value create a new object hence memory wastage	
String binary = "";
long qutent = 1;

while(qutent >0){
long tempRemainder = getRemainder(input);
long tempQutent = getQutient(input);
binary += tempRemainder;
input = tempQutent;
qutent = tempQutent;
}
int  binaryLength = binary.length();
String reverseData = "";
for (int i =1 ;i<=binaryLength;i++){
	reverseData += binary.charAt(binaryLength-i);
}
return reverseData;
}

private static long getQutient(long number){
// 9/2 return 4	
return number/2;
}

private static long getRemainder(long number){
// 9%2 returns 1	
return number%2;
}
}
