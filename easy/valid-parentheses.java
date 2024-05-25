class Solution {
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
}