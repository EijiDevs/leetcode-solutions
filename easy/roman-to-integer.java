class Solution {
    public int romanToInt(String s) {
        short number = 0;

        // Recorrer cada caracter del string con romanos
        for(short i = 0; i < s.length(); i++){
            // Validar si el numero romano actual es el ultimo y si no lo es validar si es menor al que le sigue
            // En caso de que si entonces se le resta el actual a number
            // Si no entonces se suma el actual a number
            if(i != s.length() - 1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))){
                number -= getValue(s.charAt(i));
            } else {
                number += getValue(s.charAt(i));
            }
        }
        
        return number;
    }

    public short getValue(char roman){
        switch(roman){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D': 
                return 500;
            case 'M':
                return 1000;
            default: 
                return 0;
        }
    }
}