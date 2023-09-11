class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) {
            if(derived[0]==1){
                return false;
            }
            return true;
        }
        int firstbin = derived[0] == 0 ? 0 : 1;
        int nextbin = 0;
        for (int i = 1; i < derived.length; i++) {
            nextbin = nextbin ^ derived[i];
        }
        if(nextbin==firstbin){
            return true;
        }
        return false;
    }


}