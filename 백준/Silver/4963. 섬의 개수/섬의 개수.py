import sys

sys.setrecursionlimit(10**9)
dc=[1,-1,0,0,1,1,-1,-1]
dr=[0,0,1,-1,1,-1,-1,1]

def dfs(r,c,s,visit):
    #print(row)
    #print(col)
    #print(s)
    
    #print(visit)
    for i in range(8):
        nrow = r+dr[i]
        ncol = c+dc[i]
        if 0<=nrow<row and 0<=ncol<col and visit[nrow][ncol]==0 and s[nrow][ncol]==1:
            visit[nrow][ncol]=1
            dfs(nrow,ncol,s,visit)
while True:
    col, row = map(int, input().split(" "))
    if col == 0 and row==0:
        break
    s = [list(map(int,input().split())) for _ in range(row)]
    visit = [[0]*col for _ in range(row)]
    cnt=0
    for i in range(row):
        for j in range(col):
            if s[i][j]==1 and visit[i][j]==0:
                visit[i][j]=1
                dfs(i,j,s,visit)
                cnt=cnt+1
    #print(row)
    #print(col)
    #print(s)
    print(cnt)
