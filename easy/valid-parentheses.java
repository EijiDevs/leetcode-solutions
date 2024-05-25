class Solution {
    // SOLUCIÓN 2 - Implementando Stack nativo de Java
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        // Si solo hay un parentesis o ninguno entonces no es valido
        if(s.length() < 2){
            return false;
        }
        
        // Recorrer cada parentesis
        for(int i = 0; i < s.length(); i++){
            // Agregar a la pila los parentesis de cierre correspondiente de cada uno
            switch(s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    // Si la pila no esta vacia (tiene parentesis de cierre) y el elemento en la cima es el cierre del ultimo parentesis abierto
                    if(!stack.isEmpty() && s.charAt(i) == stack.peek()){
                        // Cerrar parentesis borrandolo
                        stack.pop();
                    } else {
                        // Si la pila estaba vacia y el elemento no coincidia con la cima entonces o es un elemento de cierre de parentesis sin previa apertura o es un elemento de cierre de parentesis para el parentesis equivocado
                        return false;
                    }
            }
        }

        // Si todos los parentesis se cerraron adecuadamente entonces la pila estara vacia y sera valido
        return stack.isEmpty();
    }

    /**
        SOLUCIÓN 1
        public boolean isValid(String s) {
        StackP st = new StackP(s.length());

        if(s.length() == 1){
            return false;
        }
        
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    st.push(')');
                    break;
                case '{':
                    st.push('}');
                    break;
                case '[':
                    st.push(']');
                    break;
                default:
                    if(st.isEmpty() || s.charAt(i) != st.getTop()){
                        return false;
                    } else {
                        st.pop();
                    }
            }
        }

        return st.isEmpty();
    }
}

class StackP {
    short top;
    char[] a;

    public StackP(int size){
        this.top = -1;
        this.a = new char[size];
    } 

    public void push(char value){
        a[++top] = value;
    }

    public boolean isEmpty(){
        return (top < 0);
    }

    public char getTop(){
        if(top < 0){
            return ' ';
        } else {
            return a[top];
        }
    }


    public void pop(){
        if(top < 0){
            return;
        } else {
            a[top] = ' ';
            top--;
            return;
        }
    }
    */
}