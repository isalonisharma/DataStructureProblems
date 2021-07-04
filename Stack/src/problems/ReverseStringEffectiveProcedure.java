package problems;

public class ReverseStringEffectiveProcedure {
    static String reverse(String input){
        char[] arr = input.toCharArray();
        for(int i=0; i<input.length()/2; i++){
            char temp = arr[i];
            arr[i] = arr[input.length() - 1 - i];
            arr[input.length() - 1 - i] = temp;
        }
        return new String(arr);
    }
    
    public static void main (String[]args) {
        String result = reverse ("amrahs inolas");
        System.out.println ("Reversed string: " + result);
    }
}