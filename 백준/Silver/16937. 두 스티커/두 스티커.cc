#include <iostream>
#include <queue>
#include <stack>
#include <cstdio>
#include <vector>
#include <cstring>
#include <string>
#include <math.h>
#include <algorithm>
#include <map>
#include <set>
#include <sstream>
#include <tuple>
 
#pragma warning(disable:4996)  
#pragma comment(linker, "/STACK:336777216")
 
using namespace std;
 
int H = 0, W = 0, N = 0, MAX = 0;
 
bool use[101] = { false, };
 
vector<pair<int, int> > v;
 
bool chk(int y1, int x1, int y2, int x2, int idx)
{
    if (idx == 0)
    {
        int my = max(y1, y2);
 
        if (my > H || x1 + x2 > W) return false;
    }
    else if (idx == 1)
    {
        int mx = max(x1, x2);
 
        if (mx > W || y1 + y2 > H) return false;
    }
 
    return true;
}
 
int area(int y1, int x1, int y2, int x2)
{
    int ret = 0;
 
    if (chk(y1, x1, y2, x2, 0)) ret = max(ret, y1*x1 + y2*x2);
    if (chk(y1, x1, y2, x2, 1)) ret = max(ret, y1*x1 + y2*x2);
 
    if (chk(y1, x1, x2, y2, 0)) ret = max(ret, y1*x1 + x2*y2);
    if (chk(y1, x1, x2, y2, 1)) ret = max(ret, y1*x1 + x2*y2);
 
    if (chk(x1, y1, y2, x2, 0)) ret = max(ret, x1*y1 + y2*x2);
    if (chk(x1, y1, y2, x2, 1)) ret = max(ret, x1*y1 + y2*x2);
 
    if (chk(x1, y1, x2, y2, 0)) ret = max(ret, x1*y1 + y2*x2);
    if (chk(x1, y1, x2, y2, 1)) ret = max(ret, x1*y1 + y2*x2);
 
    return ret;
}
 
void simulation(vector<pair<int, int> > vc, int pos)
{
    if (vc.size() == 2)
    {
        int var = area(vc.at(0).first, vc.at(0).second, vc.at(1).first, vc.at(1).second);
 
        if (var == 0) return;    
 
        MAX = max(MAX, var);
 
        return;
    }
 
    for (int i = pos; i < v.size(); i++)
        if (!use[i])
        {
            use[i] = true;
            vc.push_back(v.at(i));
 
            simulation(vc, i);
 
            use[i] = false;
            vc.pop_back();
        }
}
 
int main(void)
{
    int R = 0, C = 0;
 
    scanf("%d %d %d", &H, &W, &N);
 
    for (int i = 0; i < N; i++)
    {
        scanf("%d %d", &R, &C);
 
        v.push_back({ R, C });
    }
 
    vector<pair<int, int> > vc;
 
    simulation(vc, 0);
 
    printf("%d\n", MAX);
 
    return 0;
}
