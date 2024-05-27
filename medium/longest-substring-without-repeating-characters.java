class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Recorrer primeramente el string entero y tomar la primera ventana con caracteres que no se repiten
        // Validar si el caracter actual ya esta registrado en el hash y si no agregarlo y aumentar el contador
        if(s.length() < 2){
            return s.length();
        }

        HashMap<Character, Integer> isCharExist = new HashMap<Character, Integer>();
        int maxSubstringLength = 0;
        int substringLength = 0;
        // Ir recorriendo el String con dos punteros creando una ventana, donde left seria el inicio de la ventana y rigth iria recorriendo el string hasta el final, finalizara cuando el puntero de la izquierda llegue al ultimo elemento
        for(int left = 0, right = 0; left < s.length(); right++){
            // Si el caracter no ha sido contado entonces se agrega y aumenta el contador del substring
            if(right < s.length() && !isCharExist.containsKey(s.charAt(right))){
                isCharExist.put(s.charAt(right), right);
                substringLength++;
            } else {
                // Si existe el caracter actual en el hash entonces el substring finaliza esa ventana(substring) de la cadena
                // Se valida si la longitud del substring es mayor a la longitud de la subcadena más larga registrada
                maxSubstringLength = Math.max(substringLength,maxSubstringLength); 
                
                // Se reinicia el contador de la longitud del substring
                substringLength = 0;

                // Se vacia el hashmap para empezar a revisar otras subcadenas
                isCharExist.clear();

                // Se corre el puntero left 1 hacia la derecha para reducir la ventana 
                left++; 
                // Se vuelve a ubicar el apuntador right desde el inicio de la nueva ventana
                right = left - 1;

            }
        }

        return maxSubstringLength;
    }
}