class Solution {
    public boolean isPalindrome(int x) {
        // Si es negativo no es palindromo debido al signo, si termina en 0 no es palindramo a excepción de 0
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }

        int lastDigit = 0;
        int inverted = 0;
        // Copia del numero original para manipular
        int number = x;

        // Invertir el numero matematicamente
        while(number != 0){
            lastDigit = number % 10;
            inverted = (inverted * 10) + lastDigit;
            number = number / 10;
        }

        // Validar si el numero invertido es igual al numero original
        return (x == inverted);
    }
}