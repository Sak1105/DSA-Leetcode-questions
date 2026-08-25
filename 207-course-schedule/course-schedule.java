class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int count=0;
        int[] indegree=new int[n];
        for(int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp=q.poll();
            count++;
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1]==temp){
                    indegree[prerequisites[i][0]]--;
                    if( indegree[prerequisites[i][0]]==0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if(count==numCourses){
            return true;
        }
        return false;
    }   
}