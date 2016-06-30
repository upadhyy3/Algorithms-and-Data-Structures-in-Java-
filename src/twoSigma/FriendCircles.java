package twoSigma;

    
public class FriendCircles{
static int friendCircles(String[] friends) {
      
        //check if friends exist in an array
        if(friends == null || friends.length <1){
            return 0;
        }
        
        //converting String array to char array
        char[][] friendsArray = new char[friends.length][friends[0].length()];
        
        for(int i=0;i<friends.length;i++){
            friendsArray[i] = friends[i].toCharArray(); 
        }
        
        int numberOfCircles = 0;
        
        /*
            DFS will be the best approach for solving the above problem
            creating boolean array for keeping track of visited friend nodes
        */
        
        boolean visited[] = new boolean[friends.length];
        
        for(int i=0;i<friends.length;i++){
            if(!visited[i]){
               numberOfCircles++;
               visited[i] = true;
               friendCirclesHelper(friendsArray,visited,i);
            }
        }
        
        return numberOfCircles;
    }

    public static void friendCirclesHelper(char[][] friends,boolean[] visited,int currentIndex){
        for(int i=0;i<friends.length;i++){
            if(!visited[i] && i != currentIndex && friends[currentIndex][i] == 'Y'){
                visited[i] = true;
                friendCirclesHelper(friends,visited,i);
            }
        }
    }
}