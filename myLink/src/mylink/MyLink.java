package mylink;

public class MyLink {

    public static void main(String[] args) {
        Stack<Person> st = new Stack<>();
        //Person pr = st.peek();
        st.push(new Person("bob",87));
        st.push(new Person("joe",98));
        Person joe = st.pop();
        Person bob = st.pop();
        
        
    }
    
}
