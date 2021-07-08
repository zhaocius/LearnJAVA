package leetcode.hash;

public class LT242_ValidAnagram {

    /*
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * */
    public static boolean validAnagram(String s, String t) {
        int[] letter1 = new int[26];
        for(int i = 0;i<s.length();i++){
            letter1[s.charAt(i)-'a']++;
            letter1[t.charAt(i)-'a']--;
        }
        for(int i =0;i<letter1.length;i++){
            if(letter1[i]!=0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(validAnagram(s,t));
        s = "rat";
        t = "car";
        System.out.println(validAnagram(s,t));
    }
}
