import sys

n = int(input())
t,p = [],[]
dp = [0]*(n+1)

for i in range(n):
    tmp = [int(i) for i in sys.stdin.readline().split()]
    t.append(tmp[0])
    p.append(tmp[1])
cmax = 0
for i in range(n):
    cmax = max(cmax,dp[i])
    if i+t[i] > n:
        continue
    dp[i+t[i]] = max(cmax+p[i], dp[i+t[i]])

print(max(dp))