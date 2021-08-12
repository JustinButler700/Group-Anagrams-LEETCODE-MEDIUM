class Solution {
    
    String[] myArray; // added this a field variable to improve runtime of the match function (so my solution is accepted)
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        myArray = strs;
        //1. we will create a copy of the original array with each string in alphabetical order
        String[] alphabetized = new String[strs.length];
        for(int i = 0; i < strs.length;i++)
        {
            alphabetized[i] = sortString(strs[i]);
        }
        //2. create a copy of the alphabetized array and remove the duplicate strings
        String[] array = new HashSet<String>(Arrays.asList(alphabetized)).toArray(new String[0]);
        List<List<String>> al = new ArrayList(); // this will hold the output
        for(int k = 0; k< array.length; k++)
        {
            al.add(match(alphabetized, array[k]));
        }
        return al;
        
    }
    public List<String> match(String[] strs, String myMatch)
    {
        List<String> al = new ArrayList();
        for(int i = 0; i < strs.length; i++)
        {
            if(strs[i].equals(myMatch))
            {
                al.add(myArray[i]);
            }
        }
        return al;
    }
    public static String sortString(String inputString) // alphabetize the string
    {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
