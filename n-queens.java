public class Solution {
    public List<List<String>> solveNQueens(int n) {

		List<List<String>> rst=new ArrayList<List<String>>();

		if(n<=0) return rst;

		List<String> list=new ArrayList<String>();
		int[] cols=new int[n];
		char[] rows=new char[n];
		Arrays.fill(rows,'.');
		dfs(rst,list,n,0,cols,rows);
		return rst; 
    }

    private void dfs(List<List<String>> rst, List<String> list, int n, int row, int[] cols, char[] rows){
    	if(row==n){
    		rst.add(new ArrayList<String>(list));
    		return;
    	}

    	for(int i=0;i<n;i++){
    		if(!isValid(cols,row,i)) continue;
    		rows[i]='Q';
    		list.add(new String(rows));
    		cols[row]=i;
    		rows[i]='.';
    		dfs(rst,list,n,row+1,cols,rows);
    		list.remove(list.size()-1);


    	}

    }

    private boolean isValid(int[] cols, int row, int col){
    	for(int i=0;i<row;i++){
    		if(cols[i]==col) return false;
    		if(Math.abs(col-cols[i])==Math.abs(row-i)) return false;
    	}
    	return true;

    }
}
