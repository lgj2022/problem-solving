import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int r,c,range;
	static int [][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		ans =-1;
		map = new int [r][c];
		for(int i =0; i<r; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<c; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		ArrayList<Integer> al = new ArrayList<>();
		combination(al,0);
		
		System.out.println(ans);
	}
	private static void combination(ArrayList<Integer> al, int start) {
		// TODO Auto-generated method stub
		
		if(al.size()==3) {
			//System.out.println(al.toString());
			//map 복사 시작
			int [][] cpy = copymap();
			int sum=0;
			//printmap(cpy);
			//활 쏘기 시작
			for(int i =0; i<r; i++) {
			sum+=shot(al,cpy);
			//System.out.println("sum: "+sum);
			//System.out.println("---------shot--------");
			//printmap(cpy);
			down(cpy);
			//System.out.println("---------down------------");
			//printmap(cpy);
			}
			ans =Math.max(ans, sum);
			return;
		}
		
		for(int i=start; i<c; i++) {
			al.add(i);
			combination(al,i+1);
			al.remove(al.size()-1);
		}
		
	}

	private static void down(int[][] cpy) {
		for(int i =r-1; i>0 ; i--) {
			for(int j = c-1; j>=0; j--) {
				cpy[i][j]=cpy[i-1][j];
			}
		}
		
		for(int j=0; j<c; j++) {
			cpy[0][j]=0;
		}
	}
	private static int shot(ArrayList<Integer> al, int[][] cpy) {
		//거리 체크밑  //같으면 왼쪽부터 죽이게
		ArrayList<int []> tl = new ArrayList<>();  
		for(int tmp: al) {
			int mindist =987654321;
			int minrow =-1;
			int mincol =-1;
			//System.out.println("tmp"+tmp);
			for(int i =0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(cpy[i][j]!=0) {
						int dist=Math.abs(i-r) +Math.abs(j-tmp);
						//System.out.println(dist);
						if(dist<=range) {
							if(dist<mindist) {
								mindist=dist;
								minrow=i;
								mincol=j;
							}
							
							else if(dist==mindist) {
								if(mincol>j) {
									mincol=j;
									minrow=i;
								}
							}
						}
					}
				}
			}
			
			if(mindist==987654321) {
				continue;
			}
			else {
				//중복체크
				if(check(tl,minrow,mincol)) {
					tl.add(new int[] {minrow,mincol});
				}
			}
			
		}
		for(int [] tmp: tl) {
			//System.out.println(Arrays.toString(tmp));
			cpy[tmp[0]][tmp[1]]=0;
		}
		return tl.size();
		
	}

	private static boolean check(ArrayList<int[]> tl, int mincol, int minrow) {
		for(int[] tmp: tl) {
			if(tmp[0]==mincol && tmp[1]==minrow)
				return false;
		}
		return true;
	}
	private static int[][] copymap() {
		int [][] cpy = new int [r][c];
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				cpy[i][j]=map[i][j];
			}
		}
		return cpy;
	}
	
	private static void printmap(int map[][]) {
		for(int tmp[] :map) {
			System.out.println(Arrays.toString(tmp));
		}
	}
}
