#include <stdio.h>
#include<stdbool.h>
#include<stdlib.h>

char * longestPalindrome(char * s){

    short charArrSize = (sizeof(s) * 2) / sizeof(s[0]);
    char specialCharS[charArrSize];
    short positionCount[charArrSize - 1];
    short longestPalindrome;
    short longestPalindromeCenter;

    for (short i = 0 ; i < charArrSize - 1; i++)
    {
        if(i % 2 == 0) specialCharS[i] = '|';
        else specialCharS[i] = s[(i - 1) / 2];
    }
    
    for (short i = 0; specialCharS[i] != '\0'; i++)
    {
        positionCount[i] = 0;

        bool isPalindrome = true;

        while(isPalindrome) {

            if(i - positionCount[i] - 1 < 0 || i + positionCount[i] + 1 > charArrSize - 2) break;

            if(specialCharS[i - positionCount[i] - 1] == specialCharS[i + positionCount[i] + 1])
            {
                positionCount[i]++;
            } else {
                isPalindrome = false;
            }
        }

        if(positionCount[i] > longestPalindrome) {
        longestPalindromeCenter = i;
        longestPalindrome = positionCount[i];
        }   
    }

    short startPosition = longestPalindromeCenter - longestPalindrome + 1;
    char * returnString = malloc(sizeof(char) * longestPalindrome + 1);

    if(returnString == NULL) {
        return NULL;
    }

    *(returnString + longestPalindrome) = '\0';

    for (short i = startPosition, counter = 0; counter < longestPalindrome; i += 2, counter++)
    {
        *(returnString + counter) = specialCharS[i];
    }

    for(short i = 0; *(returnString + i) != '\0'; i++) printf("%c\n", *(returnString + i));

    return returnString; 
}

void main() {


    char palindrome[]  = "abababa";

    char * returnString = longestPalindrome(palindrome);

    for(short i = 0; *(returnString + i) != '\0'; i++) {
        printf("%c", *(returnString + i));
    }

    if(returnString != NULL) free(returnString);

    
}

