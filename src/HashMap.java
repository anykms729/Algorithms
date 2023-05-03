class HashMap{
    String [] keys;
    int [] values;
    int size;

    HashMap(int size){
        this.size = size;
        keys    = new String[size];
        values  = new int [size];
    }

    /**
     It should have a hash function where a
     String is accepted and the sum of all the
     characters in that string (in terms of their
     ASCII value) is calculated. This sum has modulo
     applied respect to the size of the int array.
     The result is and returned from this method.
     The method signature should be as follows: int
     hashFunc(String key)
     */
    int hashFunc(String key){

        // Selecting an ASCII value from a character
        int asciiSum = (int)key.charAt(0);
        
        /* 
        TODO: Write a loop to go through each character 
        in key and get the ascii value. Sum these ascii 
        values and then modulo the sum by the size of the 
        array. This gives a position to store our 
        data in each of these arrays. Return this position.
        */

        for(int index = 1; index < key.length(); index++){
            asciiSum = asciiSum + (int)key.charAt(index);
        }

        return asciiSum % size;
    }


    /**
     * It should have an insertion method
     * where a key value pair is given as a String
     * and int. These will be inserted into the hash 
     * map (the same index position within the string 
     * and in arrays) depending on the result of the above 
     * hash function. This insertion method should have 
     * the following method signature: void add(String key,
     * int value). 
     *
     * Note: you will have to use linear probing within 
     * the add method to match the final result of the 
     * test cases made for this lab. Check notes for what 
     * linear probing is.  
     */
    void add(String key, int value){
        int index = hashFunc(key);
        while(keys[index]!=null){
            index++;
            index = index % size;
        }

        keys[index] = key;
        values[index] = value;
    }

    void printAll(){
        for(int index = 0; index < size; index++){
            if(keys[index]!=null){
                System.out.println(keys[index] + " -> " + values[index]);
            }
        }
    }
}